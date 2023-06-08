package problem.a1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import problem.DBConnect;

public class ProblemA1 {
  public static void main(String[] args) {
    try (DBConnect db = DBConnect.getInstance()) {
      Connection con = db.getConnection();
      PreparedStatement ps = con.prepareStatement("SELECT * FROM CAFE20230607");
      ResultSet res = ps.executeQuery();

      HashMap<Integer, CafeVO> cafes = new HashMap<>();

      while (res.next()) {
        int cafeId = res.getInt("CAFEID");
        cafes.put(cafeId, new CafeVO(cafeId, res.getString("CAFENAME"),
            res.getString("CORPORATION"), res.getInt("PRICE")));
      }

      for (int key : cafes.keySet()) {
        CafeVO cafe = cafes.get(key);
        System.out.println(cafe);
      }
    } catch (SQLException e) {
      System.err.println("SQL 오류 발생");
      System.err.println(e);
    }
  }
}
