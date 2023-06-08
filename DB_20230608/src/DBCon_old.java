import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCon_old {
  public static void main(String[] args) {
    // Java 버전과 오라클 DB 버전에 맞춰서 JDBC 라이브러리를 설정해야 함

    Connection con = null;

    try {
      // JDBC 드라이버(ojdbc6~8.jar)를 불러오는 부분
      // 로딩에 실패할 시 ClassNotFoundException 예외가 발생함
      Class.forName("oracle.jdbc.driver.OracleDriver");

      String user = "kh";
      String pw = "KH";
      String url = "jdbc:oracle:thin:@localhost:1521:orcl";

      // jdbc:oracle:thin:
      //   오라클 DB로 접속하겠다고 알려줌
      // @localhost
      //   내 IP 주소
      // 1521
      //   포트번호
      // orcl
      //   접속할 DB 이름

      con = DriverManager.getConnection(url, user, pw);
    } catch (ClassNotFoundException e) {
      System.out.println("ojdbc 라이브러리 로드 실패");
      System.out.println(e);
      System.exit(1);
    } catch (SQLException e) {
      System.out.println("DB 접속 실패");
      System.err.println(e);
      System.exit(1);
    }

    try {
      Statement st = con.createStatement();
      ResultSet res = st.executeQuery("SELECT 'Test' AS a FROM DUAL");

      while (res.next()) {
        String a = res.getString("a");
        System.out.println("a: " + a);
      }

    } catch (SQLException e) {
      System.err.println(e);
    } finally {
      try {
        con.close();
      } catch (SQLException e2) {
        System.err.println("db connection close error");
        System.err.println(e2);
      }
    }
  }
}
