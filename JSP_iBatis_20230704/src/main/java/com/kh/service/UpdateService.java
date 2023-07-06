package com.kh.service;

import java.sql.SQLException;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.kh.dao.GuestbookDAO;
import com.kh.ibatis.MyAppSqlConfig;
import com.kh.vo.GuestbookVO;

public class UpdateService {
  private static UpdateService instance = null;

  private UpdateService() {}

  public static UpdateService getInstance() {
    if (instance == null) {
      instance = new UpdateService();
    }

    return instance;
  }

  // updateOK.jsp에서 호출되는 수정할 정보가 저장된 객체를 넘겨받고
  // mapper를 얻은 후 GuestbookDAO 클래스에서 글 1건을 수정하는
  // UPDATE SQL 명령을 실행하는 메소드를 호출하는 메소드
  public void update(GuestbookVO vo) {
    System.out.println("DeleteService().delete()");

    SqlMapClient mapper = MyAppSqlConfig.getSqlMapInstance();

    try {
      GuestbookDAO.getInstance().update(mapper, vo);
    } catch (SQLException e) {
      System.err.println(e);
    }
  }
}
