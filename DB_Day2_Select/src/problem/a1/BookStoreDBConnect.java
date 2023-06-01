package problem.a1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BookStoreDBConnect {
  private static BookStoreDBConnect currentInstance = null;
  private Connection connection = null;

  private String dbms = "mysql";
  private String address = "127.0.0.1";
  private int port = 3306;
  private String dbName = "bookstore";
  private String url =
      "jdbc:" + this.dbms + "://" + this.address + ":" + this.port + "/" + this.dbName;
  private String id = "root";
  private String password = "1234";

  private BookStoreDBConnect() {}

  public static BookStoreDBConnect getInstance() {
    if (currentInstance == null) {
      currentInstance = new BookStoreDBConnect();
    }

    return currentInstance;
  }

  public Connection getConnection() throws SQLException, ClassNotFoundException {
    if (this.connection == null || this.connection.isClosed()) {
      Class.forName("com.mysql.cj.jdbc.Driver");
      this.connection = DriverManager.getConnection(this.url, this.id, this.password);
    }

    return this.connection;
  }
}
