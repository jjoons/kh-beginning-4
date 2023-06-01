package problem.a2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class POSDBConnect {
  private static POSDBConnect currentInstance = null;
  private Connection connection = null;

  private String dbms = "mysql";
  private String address = "127.0.0.1";
  private int port = 3306;
  private String dbName = "db_day2_pos";
  private String url = "jdbc:" + this.dbms + "://" + this.address + ":" + this.port + "/";
  private String id = "root";
  private String password = "1234";

  private POSDBConnect() {}

  public static POSDBConnect getInstance() {
    if (currentInstance == null) {
      currentInstance = new POSDBConnect();
    }

    return currentInstance;
  }

  public Connection getConnection() throws SQLException, ClassNotFoundException {
    this.initDB();

    if (this.connection == null || this.connection.isClosed()) {
      Class.forName("com.mysql.cj.jdbc.Driver");
      // DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
      this.connection = DriverManager.getConnection(this.url + this.dbName, this.id, this.password);
    }

    return this.connection;
  }

  public void initDB() throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.cj.jdbc.Driver");

    try (Connection con = DriverManager.getConnection(this.url, this.id, this.password);
        Statement st = con.createStatement()) {
      boolean isExistsDB = false;

      if (st.executeQuery("SHOW DATABASES LIKE '" + this.dbName + "'").next()) {
        isExistsDB = true;
      }

      if (!isExistsDB) {
        st.execute("CREATE DATABASE " + this.dbName);
      }

      st.execute("USE " + this.dbName);

      boolean isExistsTableItems = false;

      if (st.executeQuery("SHOW TABLES LIKE 'items'").next()) {
        isExistsTableItems = true;
      }

      if (!isExistsTableItems) {
        st.execute(new StringBuilder("CREATE TABLE items (\n")
            .append("  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,\n")
            .append("  item_name VARCHAR(45) NOT NULL UNIQUE,\n")
            .append("  item_stock INT UNSIGNED NOT NULL,\n")
            .append("  item_price INT UNSIGNED NOT NULL\n").append(");").toString());

        st.execute(new StringBuilder()
            .append("INSERT INTO items(item_name, item_stock, item_price) VALUES\n")
            .append("  ('새우깡', 50, 1500),\n").append("  ('오렌지주스', 30, 1000),\n")
            .append("  ('신라면', 50, 890),\n").append("  ('진라면', 50, 900),\n")
            .append("  ('열라면', 50, 1000),\n").append("  ('치토스', 50, 1300),\n")
            .append("  ('양파링', 50, 1500),\n").append("  ('포카칩', 50, 1700),\n")
            .append("  ('구슬아이스크림', 20, 3300),\n").append("  ('조스바', 20, 1300),\n")
            .append("  ('바닐라아이스크림', 20, 1500),\n").append("  ('여행자종합세트', 10, 9500),\n")
            .append("  ('치약', 50, 2500)\n").append(";").toString());
      }

      boolean isExistsTableStudents = false;

      if (st.executeQuery("SHOW TABLES LIKE 'students'").next()) {
        isExistsTableStudents = true;
      }

      if (!isExistsTableStudents) {
        st.execute(new StringBuilder().append("CREATE TABLE students (\n")
            .append("  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,\n")
            .append("  class VARCHAR(30) NOT NULL,\n").append("  no VARCHAR(20) NOT NULL,\n")
            .append("  grade INT(1) NOT NULL,\n").append("  name VARCHAR(50) NOT NULL,\n")
            .append("  phone_number VARCHAR(11) NOT NULL\n").append(");").toString());
      }
    } finally {}
  }
}
