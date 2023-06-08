import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementTest2 {
  public static void main(String[] args) {
    Connection con = null;
    Statement stm = null;

    try {
      con = DBCon.getConnection();
      stm = con.createStatement();

      String query = "INSERT INTO TEST20230608 VALUES ('id1', 'pw1', 'name1')";
      int success = stm.executeUpdate(query);

      if (success > 0) {
        System.out.println("데이터 입력 성공");
      } else {
        System.out.println("데이터 입력 실패");
      }
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println(e);
    }
  }
}
