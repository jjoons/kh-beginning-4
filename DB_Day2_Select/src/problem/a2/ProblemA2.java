package problem.a2;

import java.sql.Connection;
import java.sql.SQLException;

public class ProblemA2 {
  public static void main(String[] args) throws ClassNotFoundException, SQLException {
    POSDBConnect posDB = POSDBConnect.getInstance();
    Connection con = posDB.getConnection();


  }
}
