import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

    } catch (ClassNotFoundException e) {
      System.out.println("드라이버 로드 에러");
      e.printStackTrace();
    } catch (SQLException e) {
      System.out.println("연결 에러");
      e.printStackTrace();
    }
  }

  // 데이터베이스 작업에 사용한 객체를 닫는 메소드
  public static void close(Connection conn) {
    if (conn != null) {
      try {
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  public static void close(Statement conn) {
    if (conn != null) {
      try {
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  public static void close(PreparedStatement conn) {
    if (conn != null) {
      try {
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  public static void close(ResultSet rs) {
    if (rs != null) {
      try {
        rs.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}
