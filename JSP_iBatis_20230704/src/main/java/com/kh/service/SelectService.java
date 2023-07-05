package com.kh.service;

import java.sql.SQLException;
import java.util.HashMap;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.kh.dao.GuestbookDAO;
import com.kh.ibatis.MyAppSqlConfig;
import com.kh.vo.GuestbookList;
import com.kh.vo.GuestbookVO;
import com.kh.vo.Param;

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

  // selectByIdx.jsp 호출하는 수정 또는 삭제 글번호를 넘겨받고
  // mapper를 얻어온 후 DAO 클래스로 가서 글 1건을 얻어오는 SELECT SQL 명령을
  // 실행하는 메소드를 호출한다
  public GuestbookVO selectByIdx(int idx) {
    System.out.println("SelectService().selectByIdx()");
    SqlMapClient mapper = MyAppSqlConfig.getSqlMapInstance();

    // 글 1건 가지고 오면 저장 (객체 저장 후 리턴)
    GuestbookVO vo = null;

    try {
      vo = GuestbookDAO.getInstance().selectByIdx(mapper, idx);
    } catch (SQLException e) {
      System.err.println(e);
    }

    return vo;
  }

  // list.jsp에서 호출되는 화면에 표시할 페이지 번호와 검색어(이름 + 내용)를 넘겨받아
  // mapper를 얻어온 후 DAO 클래스 1페이지 분량의 검색어를 포함하는 글 목록을 얻어오는
  // SELECT SQL 명령을 실행하는 메소드를 호출하는 메소드
  public GuestbookList selectListMulti(int currentPage, String category, String item) {
    System.out.println("GuestbookDAO().selectListMulti()");
    SqlMapClient mapper = MyAppSqlConfig.getSqlMapInstance();

    GuestbookDAO dao = GuestbookDAO.getInstance();
    GuestbookList guestbookList = null;

    try {
      // 검색어가 포함된 글의 개수를 얻어온다
      int pageSize = 5;

      // 카테고리에 따른 검색어가 포함되었는지 조건을 세워야 하기 때문에
      // Param 클래스 객체를 이용한다
      Param param = new Param();
      param.setItem(item);
      param.setCategory(category);

      int totalCount = dao.selectCountMulti(mapper, param);
      guestbookList = new GuestbookList(pageSize, totalCount, currentPage);
      param.setStartNo(guestbookList.getStartNo());
      param.setEndNo(guestbookList.getEndNo());

      // 실제 북리스트에 저장하는 내용
      // 검색된 개수를 가지고 실제 내용들(글 목록들을 가져오는 메소드를 만들어서 리턴받는다)
      guestbookList.setList(dao.selectListMulti(mapper, param));
      // System.out.println(guestbookList);

    } catch (SQLException e) {
      System.err.println(e);
    }

    return guestbookList;
  }
}
