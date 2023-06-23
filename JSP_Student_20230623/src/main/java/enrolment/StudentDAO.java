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
    String url = "jdbc:mysql://localhost:3306/enrolment01";
    String user = "root";
    String password = "1234";

    try {
      if (this.conn == null || this.conn.isClosed()) {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.conn = DriverManager.getConnection(url, user, password);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    return this.conn;
  }

  // 학번과 비밀번호를 확인하는 메소드
  public int studentCheck(String hakbun, String passwd) {
    int check = -1;
    String dbPassword = "";

    // 연결하는 내용. 만약 에러가 발생하면 드라이버를 가져올 수 없다
    try {
      this.getConnection();

      // SQL문 작성. 학번을 이용해서 기존에 데이터베이스에 있는 비밀번호를 조회해서 가져온 다음에
      // 새로 매개변수로 받은 passwd랑 비교해서 결과가 같으면 체크 1, 아니면 0

      // 1. 쿼리
      String sql = "SELECT hakbun, passwd FROM member WHERE hakbun = ?";

      // 2. 학번 저장
      this.pstmt = this.conn.prepareStatement(sql);
      this.pstmt.setString(1, hakbun);

      // 3. rs 꺼내서 비교하기
      this.rs = pstmt.executeQuery();

      // dbPassword 가지고 온 데이터랑 passwd가 같으면
      //   같으면 체크 1, 아니면 0
      if (this.rs.next()) {
        dbPassword = this.rs.getString("passwd");
        check = dbPassword.equals(passwd) ? 1 : 0;
      }

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        if (this.rs != null && !this.rs.isClosed())
          this.rs.close();
        if (this.pstmt != null && !this.pstmt.isClosed())
          this.pstmt.close();
        if (this.conn != null && !this.conn.isClosed())
          this.conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    return check;
  }

  public StudentDTO getStudent(String hakbun) {
    StudentDTO sto = null;

    // SQL에 조회해서 내용을 가지고 온 다음 sto 변수에 저장해서 반환
    String sql = "SELECT * FROM member WHERE hakbun = ?";

    try {
      this.getConnection();
      this.pstmt = this.conn.prepareStatement(sql);
      this.pstmt.setString(1, hakbun);

      // 데이터베이스에서 결과값 꺼내서 객체로 만들어줘라
      this.rs = this.pstmt.executeQuery();

      // 한 행을 꺼내온다. 데이터가 없으면 false, 있으면 true
      if (rs.next()) {
        sto = new StudentDTO();
        sto.setHakbun(hakbun);
        sto.setPasswd(rs.getString("passwd"));
        sto.setName(rs.getString("name"));
        sto.setAddress(rs.getString("address"));
        sto.setTel(rs.getString("tel"));
        sto.setEmail(rs.getString("email"));
        sto.setMajor(rs.getInt("major"));
        sto.setGrade(rs.getInt("grade"));
        sto.setHakjom(rs.getInt("hakjom"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      this.close();
    }

    return sto;
  }

  public void close() {
    try {
      if (this.rs != null && !this.rs.isClosed())
        this.rs.close();
      if (this.pstmt != null && !this.pstmt.isClosed())
        this.pstmt.close();
      if (this.conn != null && !this.conn.isClosed())
        this.conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
