package problem.a1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ArticleDBConnect {
  private static ArticleDBConnect instance = null;
  private Connection con = null;
  private String url = null;
  private String id = null;
  private String password = null;

  private ArticleDBConnect(String url, String id, String password) {
    this.url = url;
    this.id = id;
    this.password = password;
  }

  public static ArticleDBConnect getInstance(String url, String id, String password) {
    if (instance == null) {
      instance = new ArticleDBConnect(url, id, password);
    }

    return instance;
  }

  public static ArticleDBConnect getInstance() {
    return getInstance("jdbc:oracle:thin:@localhost:1521:orcl", "kh", "KH");
  }

  public Connection getConnection() {
    try {
      if (this.con == null || this.con.isClosed()) {
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        this.con = DriverManager.getConnection(this.url, this.id, this.password);
      }
    } catch (SQLException e) {
      System.err.println(e);

      return null;
    }

    return this.con;
  }
}
