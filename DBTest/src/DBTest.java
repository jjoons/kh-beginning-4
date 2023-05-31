import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBTest {
  public static void main(String[] args) {
    // JDBC 드라이버 클래스
    //   - DB의 드라이버 클래스 이름, 연결하기 위해서 사용한다

    // Class.forName() 메소드를 사용해서 JDBC 드라이버 로드

    // 오라클
    //   Class.forName("oracle.jdbc.driver.OracleDriver");
    //   - 기본 포트 번호: 1521

    // 5.x
    // Class.forName("com.mysql.jdbc.Driver");

    // 8.x
    try {
      Class<?> a = Class.forName("com.mysql.cj.jdbc.Driver");
      String url = "jdbc:mysql://localhost:3306/pos?serverTimezone=UTC";
      String user = "root";
      String pass = "1234";

      // 데이터베이스 연결을 도와주는 클래스
      Connection con = DriverManager.getConnection(url, user, pass);

      if (con != null) {
        System.out.println("DB 연결 성공");
      }

      con.close();
    } catch (ClassNotFoundException e) {
      System.out.println("드라이버 로드 에러");
      e.printStackTrace();
    } catch (SQLException e) {
      System.out.println("연결 에러");
      e.printStackTrace();
    }
  }
}
