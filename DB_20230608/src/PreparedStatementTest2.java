import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementTest2 {
  public static void main(String[] args) {
    Connection con = null;
    PreparedStatement pstm = null;

    try {
      String query = "INSERT INTO TEST20230608 VALUES (?, ?, ?)";

      con = DBCon.getConnection();
      pstm = con.prepareStatement(query);

      // 쿼리에 값을 세팅한다.
      // 여기서 1, 2, 3은 첫번째, 두번째, 세번째 위치홀더 라는 뜻
      pstm.setString(1, "id2");
      pstm.setString(2, "pw2");
      pstm.setString(3, "name2");

      int success = pstm.executeUpdate();

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
