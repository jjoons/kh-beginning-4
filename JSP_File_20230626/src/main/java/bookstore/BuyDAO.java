package bookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BuyDAO {
  private static BuyDAO instance = null;
  private Connection conn = null;
  private PreparedStatement ps = null;
  private ResultSet rs = null;

  private BuyDAO() {}

  public static BuyDAO getInstance() {
    if (instance == null) {
      instance = new BuyDAO();
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

  public List<BuyDTO> getBuyList(String buyer) {
    List<BuyDTO> list = new ArrayList<>();

    try {
      String sql = "SELECT * FROM cart WHERE buyer = ?";

      this.getConnection();
      this.ps = this.conn.prepareStatement(sql);
      this.ps.setString(1, buyer);

      this.rs = this.ps.executeQuery();

      while (this.rs.next()) {
        BuyDTO dto = new BuyDTO();
        dto.setBuy_id(this.rs.getInt("buy_id"));
        dto.setBuyer(this.rs.getString("buyer"));
        dto.setBook_id(this.rs.getInt("book_id"));
        dto.setBook_title(this.rs.getString("book_title"));
        dto.setBuy_price(this.rs.getInt("buy_price"));
        dto.setBuy_count(this.rs.getInt("buy_count"));
        dto.setBook_image(this.rs.getString("book_image"));
        dto.setBuy_date(this.rs.getString("buy_date"));
        dto.setAccount(this.rs.getString("account"));
        dto.setDeliveryName(this.rs.getString("deliveryName"));
        dto.setDeliveryTel(this.rs.getString("deliveryTel"));
        dto.setDeliveryAddress(this.rs.getString("deliveryAddress"));
        dto.setSanction(this.rs.getString("sanction"));

        list.add(dto);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return list;
  }

  public List<String> getAccount() {
    List<String> list = new ArrayList<>();

    try {
      String sql = "SELECT * FROM bank";

      this.getConnection();
      this.ps = this.conn.prepareStatement(sql);

      this.rs = this.ps.executeQuery();

      while (this.rs.next()) {
        String account = this.rs.getString("account");
        String bank = this.rs.getString("bank");
        String name = this.rs.getString("name");

        list.add(account + " / " + bank + " / " + name);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return list;
  }

  public boolean insertBuy(List<CartDTO> cartLists, String buyer, String account,
      String deliveryName, String deliveryTel, String deliveryAddress) {

  }

  // 
  public int getListCount() {
    try {
      String sql = "SELECT COUNT(*) FROM buy";

      this.getConnection();
      this.ps = this.conn.prepareStatement(sql);

      this.rs = this.ps.executeQuery();

      if (this.rs.next()) {
        return this.rs.getInt(1);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return -1;
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
