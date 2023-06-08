import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementTest {
  public static void main(String[] args) {
    // DB 연결된 상태(세션)를 담는 객체
    Connection con = null;

    // SQL문을 나타내는 객체
    Statement stm = null;
    PreparedStatement pstm = null;

    // 쿼리문을 보낸 후 서버에서 받은 반환값을 담는 객체 
    ResultSet rs = null;

    // 쿼리문을 전송할 수 있는 2가지 인터페이스
    // 두 가지의 공통점은 쿼리 전송 기능을 가지고 있다
    // try ~ catch 문으로 throw (예외 처리)를 처리해야한다.
    // String 객체를 전달한다

    // Statement
    //   - 정적인 쿼리문을 처리할 수 있으며 쿼리문에 값이 있어야 한다
    //   - 컴파일할 때마다 서버로 전송해 컴파일을 계속해서 정보를 가지고 온다

    try {
      // SQL 문장을 만들고 만약 문장이 질의어(SELECT)면
      // 그 결과를 담는 ResultSet 객체를 준비한 후 실행한다
      String query = "SELECT * FROM D20230607_CAFE";

      System.out.println("asd");

      con = DBCon.getConnection();
      pstm = con.prepareStatement(query);
      rs = pstm.executeQuery();

      while (rs.next()) {
        int cafeId = rs.getInt("cafeid");
        int cafeName = rs.getInt("cafename");
        int price = rs.getInt("price");

        System.out.println("cafeid: " + cafeId + ", cafename: " + cafeName + ", price: " + price);
      }
    } catch (SQLException e) {
      System.err.println(e);
    } finally {
      try {
        if (rs != null)
          rs.close();

        if (pstm != null)
          pstm.close();

        if (con != null)
          con.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}
