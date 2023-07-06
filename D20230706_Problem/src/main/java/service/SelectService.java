package service;

import java.sql.SQLException;
import dao.UserDAO;
import dto.UserDTO;
import dto.UserLoginDTO;
import ibatis.SqlMap;

public class SelectService {
  private static SelectService instance;

  private SelectService() {}

  public static SelectService getInstance() {
    if (instance == null) {
      instance = new SelectService();
    }

    return instance;
  }

  public boolean login(String id, String pw) {
    boolean result = false;

    if (id == null || id.length() == 0 || pw == null || pw.length() == 0) {
      return false;
    }

    var mapper = SqlMap.getSqlMapClientInstance();
    var dto = new UserLoginDTO(id, pw);

    try {
      result = UserDAO.getInstance().selectLogin(mapper, dto);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return result;
  }

  public UserDTO getUserById(String id) {
    UserDTO dto = null;

    if (id == null || id.length() == 0) {
      return null;
    }

    var mapper = SqlMap.getSqlMapClientInstance();

    try {
      dto = UserDAO.getInstance().selectById(mapper, id);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return dto;
  }
}
