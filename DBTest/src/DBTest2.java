import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest2 {
  public static void main(String[] args) throws SQLException {
    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pos", "root", "1234");

    if (con == null) {
      throw new SQLException("연결 실패");
    }

    // DB와 연결된 con 객체로부터 Statement 객체 획득
    // 내가 데이터베이스에게 질의할 수 있다
    Statement st = con.createStatement();

    // Query 만들기
    //   문자열로 넘어감
    StringBuilder sb = new StringBuilder();
    String sql = sb.append("CREATE TABLE IF NOT EXISTS student(\n").append("id INT,\n")
        .append("grade INT\n").append(");").toString();

    System.out.println(sql);

    // Query 문 날리기
    boolean a = st.execute(sql);
    System.out.println("Result: " + a);

    con.close();
  }
}
