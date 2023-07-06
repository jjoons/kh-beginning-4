package com.kh.service;

import java.sql.SQLException;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.kh.dao.GuestbookDAO;
import com.kh.ibatis.MyAppSqlConfig;

public class DeleteService {
  private static DeleteService instance = new DeleteService();

  private DeleteService() {}

  public static DeleteService getInstance() {
    return instance;
  }

  // deleteOK.jsp에서 호출되는 삭제할 글 번호를 넘겨받고 mapper를 얻어온 후
  // 게스트북DAO 클래스의 글 1건을 삭제하는 DELETE SQL 명령을 실행하는 메소드를 호출하는 메소드
  public void delete(int idx) {
    System.out.println("DeleteService().delete()");

    SqlMapClient mapper = MyAppSqlConfig.getSqlMapInstance();

    try {
      GuestbookDAO.getInstance().delete(mapper, idx);
    } catch (SQLException e) {
      System.err.println(e);
    }
  }
}
