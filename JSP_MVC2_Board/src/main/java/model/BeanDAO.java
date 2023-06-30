package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class BeanDAO {
  private static BeanDAO instance = null;
  private Connection con = null;
  private DBConnect db = null;

  private BeanDAO() {
    this.db = DBConnect.getInstance();
    this.con = this.db.getConnection(false);
  }

  public static BeanDAO getInstance() {
    if (instance == null) {
      instance = new BeanDAO();
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
}
