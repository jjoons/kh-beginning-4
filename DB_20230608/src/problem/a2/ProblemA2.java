package problem.a2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import problem.DBConnect;

public class ProblemA2 {
  public static void main(String[] args) {
    try (DBConnect db = DBConnect.getInstance()) {
      Connection con = db.getConnection();

      if (con != null)
        System.out.println("연결됨");

      ArrayList<BeverageVO> bevers = new ArrayList<>();
      ArrayList<OrderDetailVO> ods = new ArrayList<>();

      PreparedStatement ps =
          con.prepareStatement("SELECT * FROM beverages OFFSET 0 ROWS FETCH NEXT 200 ROWS ONLY");
      ResultSet res = ps.executeQuery();

      while (res.next()) {
        System.out.println("bever");
        bevers.add(new BeverageVO(res.getInt("ID"), res.getString("name"), res.getInt("price"),
            res.getString("btype")));
      }

      for (BeverageVO bever : bevers) {
        System.out.println(bever);
      }

      res.close();
      ps.close();


      ps = con
          .prepareStatement("SELECT * FROM order_details OFFSET 0 ROWS FETCH NEXT 200 ROWS ONLY");
      res = ps.executeQuery();

      while (res.next()) {
        ods.add(new OrderDetailVO(res.getInt("id"), res.getInt("order_id"),
            res.getInt("beverage_id"), res.getInt("count")));
      }

      for (OrderDetailVO od : ods) {
        System.out.println(od);
      }

      res.close();
      ps.close();
    } catch (SQLException e) {
      System.err.println("SQL 오류 발생");
      System.err.println(e);
    }
  }
}
