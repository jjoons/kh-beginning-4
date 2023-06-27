package bookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
  private static BookDAO instance = null;
  private Connection conn = null;
  private PreparedStatement ps = null;
  private ResultSet rs = null;

  private BookDAO() {}

  public static BookDAO getInstance() {
    if (instance == null) {
      instance = new BookDAO();
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

  // 관리자 인증 메소드
  public int managerCheck(String id, String pw) {
    int check = -1;

    try {
      this.getConnection();
      String sql = "SELECT * FROM manager WHERE id = ? AND pw = ?";
      this.ps = this.conn.prepareStatement(sql);
      this.ps.setString(1, id);
      this.ps.setString(2, pw);

      this.rs = this.ps.executeQuery();

      if (this.rs.next()) {
        check = 1;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      this.close();
    }

    return check;
  }

  // 책 등록
  public void insertBook(BookDTO dto) {
    try {
      this.getConnection();
      int num = 0;

      String sql = "SELECT MAX(book_id) FROM book";
      this.ps = this.conn.prepareStatement(sql);
      this.rs = this.ps.executeQuery();

      if (this.rs.next()) {
        num = rs.getInt(1);
      }

      sql = "INSERT INTO book VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW())";
      this.ps = this.conn.prepareStatement(sql);

      ps.setString(2, dto.getBook_kind());
      ps.setString(3, dto.getBook_title());
      ps.setInt(4, dto.getBook_price());
      ps.setInt(5, dto.getBook_count());
      ps.setString(6, dto.getAuthor());
      ps.setString(7, dto.getPublishing_com());
      ps.setString(8, dto.getPublishing_date());
      ps.setString(9, dto.getBook_image());
      ps.setString(10, dto.getBook_content());
      ps.setInt(11, dto.getDiscount_rate());
      ps.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      this.close();
    }
  }

  public BookDTO[] getBooks(String book_kind, int count) {

    BookDTO[] bookList = null;
    int i = 0;

    try {
      conn = getConnection();

      String sql = "SELECT * FROM book WHERE book_kind=? ";
      sql += "ORDER BY reg_date DESC LIMIT ?,?";

      ps = conn.prepareStatement(sql);
      ps.setString(1, book_kind);
      ps.setInt(2, 0);
      ps.setInt(3, count);

      rs = ps.executeQuery();

      if (rs.next()) {
        bookList = new BookDTO[count];
        do {
          BookDTO dto = new BookDTO();
          dto.setBook_id(rs.getInt("book_id"));
          dto.setBook_kind(rs.getString("book_kind"));
          dto.setBook_title(rs.getString("book_title"));
          dto.setBook_price(rs.getInt("book_price"));
          dto.setBook_count(rs.getInt("book_count"));
          dto.setAuthor(rs.getString("author"));
          dto.setPublishing_com(rs.getString("publishing_com"));
          dto.setPublishing_date(rs.getString("publishing_date"));
          dto.setBook_image(rs.getString("book_image"));
          dto.setDiscount_rate(rs.getInt("discount_rate"));
          dto.setReg_date(rs.getString("reg_date"));

          bookList[i] = dto;

          i++;
        } while (rs.next());
      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      this.close();
    }
    return bookList;
  }

  // 분류별 또는 전체 등록된 책의 정보
  public List<BookDTO> getBooks(String book_kind) {
    List<BookDTO> list = new ArrayList<>();

    try {
      this.getConnection();
      int num = 0;

      String sql = "SELECT * FROM book";

      if (book_kind.equals("all")) {
        this.ps = this.conn.prepareStatement(sql);
      } else {
        sql += " WHERE book_kind = ? ORDER BY reg_date DESC";
        this.ps = this.conn.prepareStatement(sql);
        this.ps.setString(1, book_kind);
      }

      this.rs = this.ps.executeQuery();

      // 전체면 전체 내용을 BookDTO에 저장
      // 일부도 저장
      // return 하기
      while (this.rs.next()) {
        BookDTO dto = new BookDTO();
        dto.setBook_id(this.rs.getInt("book_id"));
        dto.setBook_kind(this.rs.getString("book_kind"));
        dto.setBook_title(this.rs.getString("book_title"));
        dto.setBook_price(this.rs.getInt("book_price"));
        dto.setBook_count(this.rs.getInt("book_count"));
        dto.setAuthor(this.rs.getString("author"));
        dto.setPublishing_com(this.rs.getString("publishing_com"));
        dto.setPublishing_date(this.rs.getString("publishing_date"));
        dto.setBook_image(this.rs.getString("book_image"));
        dto.setBook_content(this.rs.getString("book_content"));
        dto.setDiscount_rate(this.rs.getInt("discount_rate"));
        dto.setReg_date(this.rs.getString("reg_date"));

        list.add(dto);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      this.close();
    }

    return list;
  }

  /*
  public ArrayList<BookDTO> getBooks(String book_kind) {
    ArrayList<BookDTO> bookList = null;
  
    // 혹시 전체적인 내용이 나올 수도 있음
    String sql = "SELECT * FROM book";
    sql += " WHERE book_kind = ? ORDER BY reg_date DESC";
  
    // 데이터를 가지고 오면 그 때 ArrayList 객체 생성하고 각각 데이터 채우기
  
    return bookList;
  }
  */

  public int getBookCount() {
    int count = 0;
    String sql = "SELECT COUNT(*) FROM book";

    try {
      this.getConnection();
      this.ps = this.conn.prepareStatement(sql);

      this.rs = this.ps.executeQuery();

      if (this.rs.next()) {
        count = this.rs.getInt(1);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      this.close();
    }

    return count;
  }

  // 책 하나의 정보를 리턴하는 메소드
  public BookDTO getBook(int book_id) {
    BookDTO dto = null;

    // 데이터베이스에서 book_id 기준으로 데이터를 가져온다
    String sql = "SELECT * FROM book WHERE book_id = ?";

    try {
      this.getConnection();
      this.ps = this.conn.prepareStatement(sql);
      this.ps.setInt(1, book_id);

      this.rs = this.ps.executeQuery();

      if (this.rs.next()) {
        dto = new BookDTO();
        dto.setBook_id(this.rs.getInt("book_id"));
        dto.setBook_kind(this.rs.getString("book_kind"));
        dto.setBook_title(this.rs.getString("book_title"));
        dto.setBook_price(this.rs.getInt("book_price"));
        dto.setBook_count(this.rs.getInt("book_count"));
        dto.setAuthor(this.rs.getString("author"));
        dto.setPublishing_com(this.rs.getString("publishing_com"));
        dto.setPublishing_date(this.rs.getString("publishing_date"));
        dto.setBook_image(this.rs.getString("book_image"));
        dto.setBook_content(this.rs.getString("book_content"));
        dto.setDiscount_rate(this.rs.getInt("discount_rate"));
        dto.setReg_date(this.rs.getString("reg_date"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      this.close();
    }

    return dto;
  }

  // 등록된 책의 정보를 수정하는 메소드
  public void updateBoard(BookDTO dto, int book_id) {
    try {
      this.getConnection();

      String sql = "UPDATE BOOK SET book_kind=?, book_title=?, book_price=?";
      sql += ",book_count=?,author=?,publishing_com=?,publishing_date=?";
      sql += ",book_image=?,book_content=?,discount_rate=?";
      sql += " where book_id=?";

      this.ps = this.conn.prepareStatement(sql);

      this.ps.setString(1, dto.getBook_kind());
      this.ps.setString(2, dto.getBook_title());
      this.ps.setInt(3, dto.getBook_price());
      this.ps.setInt(4, dto.getBook_count());
      this.ps.setString(5, dto.getAuthor());
      this.ps.setString(6, dto.getPublishing_com());
      this.ps.setString(7, dto.getPublishing_date());
      this.ps.setString(8, dto.getBook_image());
      this.ps.setString(9, dto.getBook_content());
      this.ps.setInt(10, dto.getDiscount_rate());
      this.ps.setInt(11, book_id);

      this.ps.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      this.close();
    }
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
