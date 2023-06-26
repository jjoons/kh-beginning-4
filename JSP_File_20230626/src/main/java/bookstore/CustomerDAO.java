package bookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {
  // 주소값 반환받을 수 있게 설정
  // DB 연동 getConnection(): Connection
  private static CustomerDAO instance = null;
  private Connection conn = null;
  private PreparedStatement ps = null;
  private ResultSet rs = null;

  private CustomerDAO() {}

  public static CustomerDAO getInstance() {
    if (instance == null) {
      instance = new CustomerDAO();
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

  // 비교해서 결과를 true, false로 반환하는 메소드
  public int userCheck(String id, String passwd) {
    int check = -1;
    String sql = "SELECT id, passwd FROM member WHERE id = ? AND passwd = ?";

    try {
      this.getConnection();
      this.ps = this.conn.prepareStatement(sql);
      this.ps.setString(1, id);
      this.ps.setString(2, passwd);

      this.rs = ps.executeQuery();

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
