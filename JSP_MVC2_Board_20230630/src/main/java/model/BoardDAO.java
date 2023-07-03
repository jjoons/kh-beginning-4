package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class BoardDAO {
  private static BoardDAO instance = null;
  private Connection con = null;
  private DBConnect db = null;

  private BoardDAO() {
    this.db = DBConnect.getInstance();
    this.con = this.db.getConnection(false);
  }

  public static BoardDAO getInstance() {
    if (instance == null) {
      instance = new BoardDAO();
    }

    return instance;
  }

  public int getTotalCount() {
    String sql = "SELECT COUNT(*) FROM board";

    try (PreparedStatement ps = this.con.prepareStatement(sql)) {
      ResultSet rs = ps.executeQuery();

      if (rs.next()) {
        return rs.getInt(1);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return -1;
  }

  public List<BoardBean> getBoards(int count, int page) {
    List<BoardBean> list = new LinkedList<>();

    String sql = "SELECT * FROM board LIMIT ?, ?";

    try (PreparedStatement ps = this.con.prepareStatement(sql)) {
      int offset = count * (page - 1);

      ps.setInt(1, offset);
      ps.setInt(2, count);
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        BoardBean bean = new BoardBean();
        bean.setNum(rs.getInt("num"));
        bean.setWriter(rs.getString("writer"));
        bean.setEmail(rs.getString("email"));
        bean.setSubject(rs.getString("subject"));
        bean.setPassword(rs.getString("password"));
        bean.setReg_date(rs.getDate("reg_date"));
        bean.setRef(rs.getInt("ref"));
        bean.setRe_step(rs.getInt("re_step"));
        bean.setRe_level(rs.getInt("re_level"));
        bean.setReadcount(rs.getInt("readcount"));
        bean.setContent(rs.getString("content"));

        list.add(bean);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return list;
  }

  public BoardBean getBoard(int num) {
    String sql = "SELECT * FROM board WHERE num = ?";

    try (PreparedStatement ps = this.con.prepareStatement(sql)) {
      ps.setInt(1, num);
      ResultSet rs = ps.executeQuery();

      if (rs.next()) {
        BoardBean bean = new BoardBean();

        bean.setNum(rs.getInt("num"));
        bean.setWriter(rs.getString("writer"));
        bean.setEmail(rs.getString("email"));
        bean.setSubject(rs.getString("subject"));
        bean.setPassword(rs.getString("password"));
        bean.setReg_date(rs.getDate("reg_date"));
        bean.setRef(rs.getInt("ref"));
        bean.setRe_step(rs.getInt("re_step"));
        bean.setRe_level(rs.getInt("re_level"));
        bean.setReadcount(rs.getInt("readcount"));
        bean.setContent(rs.getString("content"));

        return bean;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return null;
  }

  public int increaseReadCount(int num) {
    String sql = "SELECT readcount FROM board WHERE num = ?";

    PreparedStatement ps = null;

    try {
      ps = this.con.prepareStatement(sql);
      ps.setInt(1, num);
      ResultSet rs = ps.executeQuery();

      if (rs.next()) {
        int readCount = rs.getInt(1);
        int newReadCount = readCount + 1;
        ps.close();

        sql = "UPDATE board SET readCount = ? WHERE num = ?";

        ps = this.con.prepareStatement(sql);
        ps.setInt(1, newReadCount);
        ps.setInt(2, num);

        return ps.executeUpdate() > 0 ? newReadCount : readCount;
      }

      ps.close();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        if (ps != null && !ps.isClosed())
          ps.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    return -1;
  }

  // 업데이트 했을 때 저장하는 명령문
  public void updateBoard(BoardBean bean) {
    String sql = "UPDATE board SET subject = ?, content = ? WHERE num = ?";

    try (PreparedStatement ps = this.con.prepareStatement(sql)) {
      ps.setString(1, bean.getSubject());
      ps.setString(2, bean.getContent());
      ps.setInt(3, bean.getNum());
      ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void deleteBoard(int num) {
    String sql = "DELETE FROM board WHERE num = ?";

    try (PreparedStatement ps = this.con.prepareStatement(sql)) {
      ps.setInt(1, num);
      ps.executeQuery();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void reWriteBoard(BoardBean bean) {
    // 글 번호 (댓글을 저장할 그룹으로 사용)
    int ref = bean.getRef();
    // 댓글 순서 저장
    int re_step = bean.getRe_step();
    // 대댓글을 구별하기 위해서 들여쓰기용으로 사용한다
    int re_level = bean.getRe_level();

    String sql = "UPDATE board SET re_level = re_level + 1 WHERE ref = ?";

    // 답변글 데이터 저장
    sql = ""; // INSERT INTO board(field1, field2, ...) VALUES ()
    // NOW(): 현재 날짜와 시간 저장
    // ref: 부모의 ref 값을 넣는다
    // re_step: 답글이기에 re_step을 1 더해줌
  }
}
