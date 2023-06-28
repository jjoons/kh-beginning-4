package bookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDAO {
  private static CartDAO instance = null;
  private Connection conn = null;
  private PreparedStatement ps = null;
  private ResultSet rs = null;

  private CartDAO() {}

  public static CartDAO getInstance() {
    if (instance == null) {
      instance = new CartDAO();
    }

    return instance;
  }

  public Connection getConnection(String url, String user, String password) {
    try {
      if (this.conn == null || this.conn.isClosed()) {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.conn = DriverManager.getConnection(url, user, password);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    return this.conn;
  }

  public Connection getConnection() {
    return this.getConnection("jdbc:mysql://localhost:3306/onlinebook", "root", "1234");
  }

  // id에 해당하는 장바구니 목록
  public List<CartDTO> getCart(String id) {
    CartDTO cart = null;
    List<CartDTO> list = null;

    // 데이터베이스에서 buyer와 id를 조건으로 가지는 값을 꺼내서 CartDTO에 저장한다

    try {
      String sql = "SELECT * FROM cart WHERE buyer = ?";

      this.getConnection();
      this.ps = this.conn.prepareStatement(sql);
      this.ps.setString(1, id);
      this.rs = this.ps.executeQuery();

      list = new ArrayList<>();

      while (this.rs.next()) {
        cart = new CartDTO();
        cart.setCart_id(this.rs.getInt("cart_id"));
        cart.setBuyer(this.rs.getString("buyer"));
        cart.setBook_id(this.rs.getInt("book_id"));
        cart.setBook_title(this.rs.getString("book_title"));
        cart.setBuy_price(this.rs.getInt("buy_price"));
        cart.setBuy_count(this.rs.getInt("buy_count"));
        cart.setBook_image(this.rs.getString("book_image"));
        list.add(cart);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return list;
  }

  // id에 해당하는 레코드의 수를 얻어내는 메소드
  public int getListCount(String id) {
    int count = 0;

    // buyer 기준으로 id를 비교해서 count(*) cart테이블
    try {
      String sql = "SELECT COUNT(*) FROM cart WHERE buyer = ?";

      this.getConnection();
      this.ps = this.conn.prepareStatement(sql);
      this.ps.setString(1, id);
      this.rs = this.ps.executeQuery();

      if (this.rs.next()) {
        count = this.rs.getInt(1);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return count;

  }

  // 장바구니 담기를 누르면 수행되는 것으로 cart 테이블에 새로운 레코드 추가
  public void insertCart(CartDTO cart) {
    int cart_id = 0;

    try {
      String sql = "SELECT MAX(cart_id) FROM cart";

      this.getConnection();
      this.ps = this.conn.prepareStatement(sql);
      this.rs = this.ps.executeQuery();

      if (this.rs.next()) {
        cart_id = rs.getInt(1);
      }

      sql =
          "INSERT INTO cart(cart_id, book_id, buyer, book_title, buy_price, buy_count, book_image) VALUES (?,?,?,?,?,?,?)";
      this.ps = this.conn.prepareStatement(sql);
      this.ps.setInt(1, cart_id + 1);
      this.ps.setInt(2, cart.getBook_id());
      this.ps.setString(3, cart.getBuyer());
      this.ps.setString(4, cart.getBook_title());
      this.ps.setInt(5, cart.getBuy_price());
      this.ps.setInt(6, cart.getBuy_count());
      this.ps.setString(7, cart.getBook_image());

      this.ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public CartDTO getCartItem(int cart_id) {
    try {
      String sql = "SELECT * FROM cart WHERE cart_id = ?";

      this.getConnection();
      this.ps = this.conn.prepareStatement(sql);
      this.ps.setInt(1, cart_id);
      this.rs = this.ps.executeQuery();

      if (this.rs.next()) {
        CartDTO cart = new CartDTO();

        cart.setCart_id(this.rs.getInt("cart_id"));
        cart.setBuyer(this.rs.getString("buyer"));
        cart.setBook_id(this.rs.getInt("book_id"));
        cart.setBook_title(this.rs.getString("book_title"));
        cart.setBuy_price(this.rs.getInt("buy_price"));
        cart.setBuy_count(this.rs.getInt("buy_count"));
        cart.setBook_image(this.rs.getString("book_image"));

        return cart;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return null;
  }

  public boolean updateCartItem(CartDTO cart) {
    try {
      String sql =
          "UPDATE cart SET book_id = ?, book_title = ?, buy_price = ?, buy_count = ?, book_image = ?"
              + " WHERE cart_id = ?";
      this.ps = this.conn.prepareStatement(sql);
      this.ps.setInt(1, cart.getBook_id());
      this.ps.setString(2, cart.getBook_title());
      this.ps.setInt(3, cart.getBuy_price());
      this.ps.setInt(4, cart.getBuy_count());
      this.ps.setString(5, cart.getBook_image());
      this.ps.setInt(6, cart.getCart_id());

      return this.ps.executeUpdate() > 0;
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return false;
  }

  // 장바구니에서 cart_id에 대한 레코드를 삭제하는 메소드
  public boolean deleteList(int cart_id) {
    try {
      String sql = "DELETE FROM cart WHERE cart_id = ?";
      this.ps = this.conn.prepareStatement(sql);
      this.ps.setInt(1, cart_id);

      return this.ps.executeUpdate() > 0;
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return false;
  }

  public boolean deleteAll(String buyer) {
    try {
      String sql = "DELETE FROM cart WHERE buyer = ?";
      this.ps = this.conn.prepareStatement(sql);
      this.ps.setString(1, buyer);

      return this.ps.executeUpdate() > 0;
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return false;
  }

  public void close() {
    try {
      if (this.conn != null && !this.conn.isClosed()) {
        this.conn.close();
      }
      if (this.ps != null && !this.ps.isClosed()) {
        this.ps.close();
      }
      if (this.rs != null && !this.rs.isClosed()) {
        this.rs.close();
      }
    } catch (SQLException e) {}
  }
}
