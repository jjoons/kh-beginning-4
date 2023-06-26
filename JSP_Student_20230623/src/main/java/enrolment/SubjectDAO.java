package enrolment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SubjectDAO {
  private static SubjectDAO instance = new SubjectDAO();
  private Connection conn = null;
  private PreparedStatement pstmt = null;
  private ResultSet rs = null;

  private SubjectDAO() {}

  public static SubjectDAO getInstance() {
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

  public ArrayList<SubjectDTO> getAllSubject() {
    ArrayList<SubjectDTO> s = new ArrayList<>();

    SubjectDTO sto = null;


    try {
      this.getConnection();

      // 1. subject01 테이블 내용 모두 가져오기
      String sql = "SELECT * FROM subject01";

      // 2. rs에 저장하기
      this.pstmt = this.conn.prepareStatement(sql);
      this.rs = this.pstmt.executeQuery();

      // 3. 데이터가 있다면 rs에서 꺼내서 sto에 저장하기
      while (this.rs.next()) {
        sto = new SubjectDTO();

        sto.setSubjectNum(this.rs.getInt("subjectNum"));
        sto.setSubjectName(this.rs.getString("subjectName"));
        sto.setProfessorName(this.rs.getString("professorName"));
        sto.setHakjom(this.rs.getInt("hakjom"));
        sto.setMajor(this.rs.getString("major"));
        sto.setRoom(this.rs.getString("room"));
        sto.setSubjectPurpos(this.rs.getString("subjectPurpos"));
        sto.setSubjectGoal(this.rs.getString("subjectGoal"));
        sto.setSubjectTest(this.rs.getString("subjectTest"));
        sto.setGrade(this.rs.getInt("grade"));
        sto.setStudentCount(this.rs.getInt("studentCount"));

        // 4. 리스트에 추가한다
        s.add(sto);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      this.close();
    }

    return s;
  }

  public SubjectDTO getOneSubject(int subjectNum) {
    SubjectDTO sto = new SubjectDTO();

    try {
      this.getConnection();

      // subjectNum 해당하는 내용 가져오기
      String sql = "SELECT * FROM subject01 WHERE subjectNum = ?";

      this.pstmt = this.conn.prepareStatement(sql);
      this.pstmt.setInt(1, subjectNum);
      this.rs = this.pstmt.executeQuery();

      if (this.rs.next()) {
        sto.setSubjectNum(this.rs.getInt("subjectNum"));
        sto.setSubjectName(this.rs.getString("subjectName"));
        sto.setProfessorName(this.rs.getString("professorName"));
        sto.setHakjom(this.rs.getInt("hakjom"));
        sto.setMajor(this.rs.getString("major"));
        sto.setRoom(this.rs.getString("room"));
        sto.setSubjectPurpos(this.rs.getString("subjectPurpos"));
        sto.setSubjectGoal(this.rs.getString("subjectGoal"));
        sto.setSubjectTest(this.rs.getString("subjectTest"));
        sto.setGrade(this.rs.getInt("grade"));
        sto.setStudentCount(this.rs.getInt("studentCount"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      this.close();
    }

    return sto;
  }

  // 학년과 전공을 넘겨줘서 두 개의 조건을 만족하는 수강 객체를 ArrayList에 저장
  public ArrayList<SubjectDTO> getGradeMajorSubject(String major, int grade) {
    ArrayList<SubjectDTO> s = new ArrayList<>();
    SubjectDTO sto = null;

    String sql = "SELECT * FROM subject01 WHERE major = ? AND grade = ?";

    try {
      this.getConnection();
      this.pstmt = this.conn.prepareStatement(sql);
      this.pstmt.setString(1, major);
      this.pstmt.setInt(2, grade);
      this.rs = this.pstmt.executeQuery();

      while (this.rs.next()) {
        sto = new SubjectDTO();

        sto.setSubjectNum(this.rs.getInt("subjectNum"));
        sto.setSubjectName(this.rs.getString("subjectName"));
        sto.setProfessorName(this.rs.getString("professorName"));
        sto.setHakjom(this.rs.getInt("hakjom"));
        sto.setMajor(this.rs.getString("major"));
        sto.setRoom(this.rs.getString("room"));
        sto.setSubjectPurpos(this.rs.getString("subjectPurpos"));
        sto.setSubjectGoal(this.rs.getString("subjectGoal"));
        sto.setSubjectTest(this.rs.getString("subjectTest"));
        sto.setGrade(this.rs.getInt("grade"));
        sto.setStudentCount(this.rs.getInt("studentCount"));

        s.add(sto);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      this.close();
    }

    return s;
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
