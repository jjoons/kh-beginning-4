import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon {
  private DBCon() {}

  private static Connection dbConn;

  public static Connection getConnection() {
    dbConn = null;

    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");

      String user = "KH";
      String pw = "KH";
      String url = "jdbc:oracle:thin:@localhost:1521:orcl";

      dbConn = DriverManager.getConnection(url, user, pw);
    } catch (ClassNotFoundException e) {
      System.err.println("ojdbc 라이브러리 로드 실패");
      System.err.println(e);
    } catch (SQLException e) {
      System.err.println("DB 접속 실패");
      System.err.println(e);
    }

    return dbConn;
  }
}
