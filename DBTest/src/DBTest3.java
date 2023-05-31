import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest3 {
  public static void main(String[] args) throws SQLException {
    Connection con =
        DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/day5_1", "root", "1234");

    if (con == null) {
      throw new SQLException("연결 실패");
    }

    Statement st = con.createStatement();

    // 조회
    //   쿼리문을 통해 데이터를 가지고 온다
    //   next(): 다음 데이터가 있으면 true, 없으면 false
    ResultSet result = st.executeQuery("SELECT * FROM beverages;");

    System.out.println("번호 / 메뉴명 / 메뉴가격 / 메뉴타입");

    while (result.next()) {
      // 데이터 꺼내는 방식
      //   - 인덱스 번호 이용
      //   - 컬럼 이름을 이용해서 데이터를 꺼내는 것이 안전하다
      //     getString("컬럼이름");
      int id = Integer.parseInt(result.getString("id"));
      String name = result.getString("name");
      int price = result.getInt("price");
      String btype = result.getString("btype");

      System.out.println(id + " / " + name + " / " + price + " / " + btype);
    }

    con.close();
  }
}
