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

    int num = 0;
    // 1. 댓글 중에서 새 댓글을 작성할 때 맨 밑으로 내려가야한다
    String numSql = "SELECT MAX(num) FROM board";

    try {
      PreparedStatement ps = con.prepareStatement(numSql);
      ResultSet rs = ps.executeQuery();

      // 컴파일하고 rs에 데이터를 받아오면
      if (rs.next()) {
        num = rs.getInt(1) + 1;
      }
    } catch (SQLException e) {
      System.out.println(e);
    }

    // 2. 대댓글끼리 뭉치기 위해, 부모 댓글의 댓글 번호호 ref 세팅
    //   글을 읽고 ref가 같아야한다. re_step이 읽은 글의 re_step보다 크면 re_step 1 증가
    String sql = "UPDATE board SET re_level = re_level + 1" + " WHERE ref = ? AND re_level > ?";

    try {
      PreparedStatement ps = con.prepareStatement(numSql);
      ps.setInt(1, ref);
      ps.setInt(2, re_level);

      ps.executeUpdate();
    } catch (SQLException e) {

    }

    // 답변글 데이터 저장
    // 답변글 데이터를 저장

    try {
      String sql2 = "INSERT INTO board (num , writer, email, subject, password, "
          + "reg_date, ref, re_step, re_level, readcount, content) "
          + "VALUES (?,?,?,?,?,now(),?,?,?,0,?)";
      PreparedStatement pstmt = this.con.prepareStatement(sql2);
      // ? 에 값을 대입
      pstmt.setInt(1, num);
      pstmt.setString(2, bean.getWriter());
      pstmt.setString(3, bean.getEmail());
      pstmt.setString(4, bean.getSubject());
      pstmt.setString(5, bean.getPassword());
      pstmt.setInt(6, ref); // 부모의 ref 값을 넣어줌
      pstmt.setInt(7, re_step + 1); // 답글이기에  re_step에 1을 더해줌
      pstmt.setInt(8, re_level + 1);
      pstmt.setString(9, bean.getContent());
      pstmt.executeUpdate();
    } catch (SQLException e) {}

    // NOW(): 현재 날짜와 시간 저장
    // ref: 부모의 ref 값을 넣는다
    // re_step: 답글이기에 re_step을 1 더해줌
  }
}
