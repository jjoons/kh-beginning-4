package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dto.AccountDTO;

public class AccountDAO {
  private static AccountDAO instance;
  private Connection con = null;
  private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
  private String user = "kh";
  private String password = "KH";

  private AccountDAO() {
    this.initConnection();
  }

  public static AccountDAO getInstance() {
    if (instance == null) {
      instance = new AccountDAO();
    }

    return instance;
  }

  public void initConnection() {
    try {
      if (this.con == null || this.con.isClosed()) {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        this.con = DriverManager.getConnection(this.url, this.user, this.password);
      }
    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public int checkDuplicateId(String id) {
    String sql = "SELECT COUNT(*) FROM d20230712_problem WHERE id = ?";

    try (PreparedStatement ps = this.con.prepareStatement(sql)) {
      ps.setString(1, id);
      ResultSet rs = ps.executeQuery();

      if (rs.next()) {
        return rs.getInt(1);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return -1;
  }

  public int insertAccount(AccountDTO dto) {
    String sql = "INSERT INTO d20230712_problem(id, password, name, age, gender, email)"
        + "VALUES (?, ?, ?, ?, ?, ?)";

    try (PreparedStatement ps = this.con.prepareStatement(sql)) {
      ps.setString(1, dto.getId());
      ps.setString(2, dto.getPassword());
      ps.setString(3, dto.getName());
      ps.setInt(4, dto.getAge());
      ps.setString(5, dto.getGender());
      ps.setString(6, dto.getEmail());

      return ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return -1;
  }
}
