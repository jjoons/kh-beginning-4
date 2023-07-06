package dao;

import java.sql.SQLException;
import com.ibatis.sqlmap.client.SqlMapClient;
import dto.UserDTO;
import dto.UserLoginDTO;

public class UserDAO {
  private static UserDAO instance = null;

  private UserDAO() {}

  public static UserDAO getInstance() {
    if (instance == null) {
      instance = new UserDAO();
    }

    return instance;
  }

  public boolean selectLogin(SqlMapClient mapper, UserLoginDTO dto) throws SQLException {
    return ((int) mapper.queryForObject("selectLogin", dto)) == 1;
  }

  public UserDTO selectById(SqlMapClient mapper, String id) throws SQLException {
    var dto = (UserDTO) mapper.queryForObject("selectById", id);
    System.out.println("selctById: " + dto);
    return dto;
  }
}
