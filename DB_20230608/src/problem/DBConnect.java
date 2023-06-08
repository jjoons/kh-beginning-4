package problem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect implements AutoCloseable {
  private static DBConnect instance;
  private Connection con = null;
  private String url = null;
  private String username = null;
  private String password = null;

  public DBConnect(String url, String username, String password) {
    this.url = url;
    this.username = username;
    this.password = password;
  }

  public static DBConnect getInstance() {
    if (instance == null) {
      instance = new DBConnect("jdbc:oracle:thin:@localhost:1521:orcl", "KH", "KH");
    }

    return instance;
  }

  public Connection getConnection() {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");

      if (this.con == null || this.con.isClosed()) {
        this.con = DriverManager.getConnection(this.url, this.username, this.password);
      }
    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
    }

    return this.con;
  }

  public void close() {
    try {
      if (this.con != null && !this.con.isClosed())
        this.con.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
