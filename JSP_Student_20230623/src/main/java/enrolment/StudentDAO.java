package enrolment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {
  private static StudentDAO instance = new StudentDAO();
  private Connection conn = null;
  private PreparedStatement pstmt = null;
  private ResultSet rs = null;

  private StudentDAO() {}

  public static StudentDAO getInstance() {
    return instance;
  }

  // 연동하는 메소드
  public Connection getConnection() {
    try {
      if (this.conn == null || this.conn.isClosed()) {
        this.conn =
            DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolment01", "root", "1234");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return this.conn;
  }

  public int studentCheck(String hakbun, String passwd) {

  }
}
