package com.kh.service;

import java.sql.SQLException;
import java.util.HashMap;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.kh.dao.GuestbookDAO;
import com.kh.ibatis.MyAppSqlConfig;
import com.kh.vo.GuestbookList;

public class SelectService {
  private static SelectService instance = new SelectService();

  private SelectService() {}

  public static SelectService getInstance() {
    return instance;
  }

  // list.jsp에서 호출되는 화면에 표시할 페이지 번호를 넘겨받고 mapper를 얻어온 후
  // guestbookDAO 클래스의 한 페이지 분량을 글 목록을 얻어오는
  // SELECT SQL 명령문을 실행하는 메소드 만들기
  public GuestbookList selectList(int currentPage) {
    SqlMapClient mapper = MyAppSqlConfig.getSqlMapInstance();

    // 한 페이지 분량의 글 목록과 페이징 작업에 사용할 8개의 변수를 이용해서
    // 리턴시킬 객체를 선언한다
    GuestbookList guestbookList = null;

    // GuestbookDAO 클래스에 2번 접근해서 SQL 명령을 실행해야 하므로
    // GuestbookDAO 인스턴스를 미리 얻어둔다
    GuestbookDAO dao = GuestbookDAO.getInstance();

    try {
      // 1페이지당 표시할 글의 개수를 정한다
      int pageSize = 10;

      // 테이블에 저장된 전체 글의 개수를 얻어온다
      int totalCount = dao.selectCount(mapper);
      guestbookList = new GuestbookList(pageSize, totalCount, currentPage);

      // pageSize, totalCount, currentPage 변수를 이용해서 GuestbookList 객체를 생성한다
      HashMap<String, Integer> hMap = new HashMap<>();
      hMap.put("startNo", guestbookList.getStartNo());
      hMap.put("endNo", guestbookList.getEndNo());

      // 1페이지 분량의 글 목록을 얻어와서 GuestbookList 클래스 객체에 저장
      guestbookList.setList(dao.selectList(mapper, hMap));
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return guestbookList;
  }
}
