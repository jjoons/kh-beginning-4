package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
  private static DBConnect instance = null;
  private Connection conn = null;
  private String url = null;
  private String user = null;
  private String password = null;

  private DBConnect() {}

  public static DBConnect getInstance() {
    if (instance == null) {
      instance = new DBConnect();
    }

    return instance;
  }

  public Connection getConnection(String url, String user, String password, boolean copy) {
    try {
      if (!copy && (this.conn == null || this.conn.isClosed())) {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.conn = DriverManager.getConnection(url, user, password);
        this.url = url;
        this.user = user;
        this.password = password;
      } else if (copy || !this.url.equals(url) || !this.user.equals(user)
          || !this.password.equals(password)) {
        return DriverManager.getConnection(url, user, password);
      }
    } catch (SQLException | ClassNotFoundException e) {
      System.err.println("DB 연결 오류");
      e.printStackTrace();
    }

    return this.conn;
  }

  public Connection getConnection(boolean copy) {
    return getConnection("jdbc:mysql://localhost:3306/joinmvcdb04", "root", "1234", copy);
  }

  public void close() {
    try {
      if (this.conn != null && !this.conn.isClosed()) {
        this.conn.close();
        this.url = this.user = this.password = null;
      }
    } catch (SQLException e) {
      System.err.println("DB 연결 닫기 실패");
      e.printStackTrace();
    }
  }
}
