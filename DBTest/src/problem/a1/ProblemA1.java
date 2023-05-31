package problem.a1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ProblemA1 {
  public static void main(String[] args) throws SQLException {
    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pos", "root", "1234");
    Statement st = con.createStatement();

    boolean queryResult =
        st.execute(new StringBuilder().append("CREATE TABLE IF NOT EXISTS students(\n"
            + "id VARCHAR(20) PRIMARY KEY,\n" + "pw VARCHAR(30),\n" + "name VARCHAR(30),\n"
            + "address VARCHAR(120),\n" + "phone VARCHAR(11)\n" + ");").toString());

    System.out.println(queryResult);
  }
}
