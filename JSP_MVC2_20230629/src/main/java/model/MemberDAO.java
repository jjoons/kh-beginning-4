package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
  private static MemberDAO instance = null;
  private DBConnect db = null;

  private Connection con = null;

  private MemberDAO() {
    this.db = DBConnect.getInstance();
    this.con = this.db.getConnection(false);
  }

  public static MemberDAO getInstance() {
    if (instance == null) {
      instance = new MemberDAO();
    }

    return instance;
  }

  // DB 연동

  // id 중복 체크
  public boolean isExistId(String id) {
    String sql = "SELECT id FROM member WHERE id = ?";
    try (PreparedStatement ps = this.con.prepareStatement(sql)) {
      ps.setString(1, id);
      ResultSet rs = ps.executeQuery();

      return rs.next();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return false;
  }

  // 회원가입
  public boolean register(MemberBean member) {
    String sql = "INSERT INTO member(id, pw, name, tel, email, field, skill, major)"
        + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    try (PreparedStatement ps = this.con.prepareStatement(sql)) {
      ps.setString(1, member.getId());
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return false;
  }

  // 로그인

  // 화면 정보 꺼내오기 (한명의 정보)

  // 회원정보 수정

  // 입사지원 하기

  // 탈퇴하기
}
