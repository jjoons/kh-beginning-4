package bookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
