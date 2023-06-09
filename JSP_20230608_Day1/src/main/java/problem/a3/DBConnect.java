package problem.a3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
  private static DBConnect instance;

  private String url = null;
  private String username = null;
  private String password = null;

  private Connection con = null;

  public DBConnect(String url, String username, String password) {
    this.url = url;
    this.username = username;
    this.password = password;
  }

  public static DBConnect getInstance() {
    if (instance == null) {
      instance = new DBConnect("jdbc:oracle:thin:@localhost:1521:orcl", "kh", "KH");
    }

    return instance;
  }

  public Connection getConnection() throws SQLException {
    if (con == null || con.isClosed()) {
      con = DriverManager.getConnection(this.url, this.username, this.password);
    }

    return con;
  }

  public String getUrl() {
    return url;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }
}
