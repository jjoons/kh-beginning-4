package problem.a3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import problem.DBConnect;
import problem.a2.BeverageVO;

public class CafeController {
  private DBConnect db = null;
  private Connection con = null;

  public CafeController() {
    this.db = DBConnect.getInstance();

    try {
      this.con = this.db.getConnection();

      if (this.con == null) {
        throw new SQLException("DB 연결 실패");
      }
    } catch (SQLException e) {
      System.err.println(e);
    }
  }

  public List<BeverageVO> getBeverages(int perPage, int page) {
    List<BeverageVO> list = new ArrayList<>();

    try {
      PreparedStatement ps = this.con.prepareStatement(
          "SELECT id, name, price, btype FROM beverages OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");

      ps.setInt(1, perPage * (page - 1));
      ps.setInt(2, perPage);

      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        list.add(new BeverageVO(rs.getInt("id"), rs.getString("name"), rs.getInt("price"),
            rs.getString("btype")));
      }
    } catch (SQLException e) {
      return null;
    }

    return list;
  }
}
