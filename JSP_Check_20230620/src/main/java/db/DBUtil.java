package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
  // MySQL에 연결하는 Connection을 리턴하는 메소드
  public static Connection getMySQLConnection() {
    Connection conn = null;

    // 라이브러리 8 버전 가져오기
    // 드라이버 만들어서 가지고 오고 URL 연결해서 연결 성공

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");

      String url = "jdbc:mysql://localhost:3306/memolists?serverTimezone=UTC";
      conn = DriverManager.getConnection(url, "root", "1234");
    } catch (ClassNotFoundException e) {
      System.out.println("드라이버 클래스가 없거나 읽어올 수 없습니다.");
      e.printStackTrace();
    } catch (SQLException e) {
      System.out.println("데이터베이스 접속 정보가 올바르지 않습니다.");
      e.printStackTrace();
    }

    return conn;
  }

  public static void close(Connection conn) {
    if (conn != null) {
      try {
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}
