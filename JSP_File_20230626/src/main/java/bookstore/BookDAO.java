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
        sql = "SELECT * FROM book WHERE book_kind = ? ORDER BY reg_date DESC";
        this.ps = this.conn.prepareStatement(sql);
        this.ps.setString(1, book_kind);
      }

      this.rs = this.ps.executeQuery();

      // 전체면 전체 내용을 BookDTO에 저장
      // 일부도 저장
      // return 하기

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      this.close();
    }

    return list;
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
