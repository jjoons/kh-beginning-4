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
      ps.setString(2, member.getPw());
      ps.setString(3, member.getName());
      ps.setString(4, member.getTel());
      ps.setString(5, member.getEmail());
      ps.setString(6, member.getField());
      ps.setString(7, member.getSkill());
      ps.setString(8, member.getMajor());

      return ps.executeUpdate() > 0;
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return false;
  }

  // 로그인
  public int checkIdPw(String id, String pw) {
    String sql = "SELECT id FROM member WHERE id = ? AND pw = ?";

    try (PreparedStatement ps = this.con.prepareStatement(sql)) {
      ps.setString(1, id);
      ps.setString(2, pw);
      ResultSet rs = ps.executeQuery();

      return rs.next() ? 1 : 0;
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return -1;
  }

  // 화면 정보 꺼내오기 (한명의 정보)
  public MemberBean getOneMember(String id) {
    String sql = "SELECT id FROM member WHERE id = ?";

    try (PreparedStatement ps = this.con.prepareStatement(sql)) {
      ps.setString(1, id);
      ResultSet rs = ps.executeQuery();

      if (rs.next()) {
        MemberBean bean = new MemberBean();
        bean.setId(rs.getString("id"));
        bean.setPw(rs.getString("pw"));
        bean.setName(rs.getString("name"));
        bean.setTel(rs.getString("tel"));
        bean.setEmail(rs.getString("email"));
        bean.setField(rs.getString("field"));
        bean.setSkill(rs.getString("skill"));
        bean.setMajor(rs.getString("major"));

        return bean;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return null;
  }

  // 회원정보 수정
  public void apply(String id, String field, String skill, String major) {
    String sql = "UPDATE member SET field = ?, skill = ?, major = ? WHERE id = ?";

    try (PreparedStatement ps = this.con.prepareStatement(sql)) {
      ps.setString(1, field);
      ps.setString(2, skill);
      ps.setString(3, major);
      ps.setString(4, id);

      ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public boolean delete(String id) {
    String sql = "DELETE FROM member WHERE id = ?";

    try (PreparedStatement ps = this.con.prepareStatement(sql)) {
      ps.setString(1, id);
      return ps.executeUpdate() > 0;
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return false;
  }

  public boolean updateMember(String id, MemberBean bean) {
    String sql =
        "UPDATE member SET pw = ?, name = ?, tel = ?, email = ?, field = ?, skill = ?, major = ? WHERE id = ?";

    try (PreparedStatement ps = this.con.prepareStatement(sql)) {
      ps.setString(1, bean.getPw());
      ps.setString(2, bean.getName());
      ps.setString(3, bean.getTel());
      ps.setString(4, bean.getEmail());
      ps.setString(5, bean.getField());
      ps.setString(6, bean.getSkill());
      ps.setString(7, bean.getMajor());
      ps.setString(8, bean.getId());

      return ps.executeUpdate() > 0;
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return false;
  }

  // 입사지원 하기

  // 탈퇴하기
}
