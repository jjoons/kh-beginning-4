package com.kh.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.kh.vo.GuestbookVO;

public class GuestbookDAO {
  // DAO 설정
  private static GuestbookDAO instance = null;

  private GuestbookDAO() {}

  public static GuestbookDAO getInstance() {
    if (instance == null) {
      instance = new GuestbookDAO();
    }

    return instance;
  }

  //InsertService 클래스에서 호출되는 mapper와 테이블에 저장할 데이터가 저장된 객체를 넘겨받고 guestbook.xml 파일의
  //insert sql 명열을 실행하는 메소드
  public void insert(SqlMapClient mapper, GuestbookVO vo) throws SQLException {
    System.out.println("GuestbookDAO의 insert() 메소드 실행");
    // System.out.println(vo);
    // insert("실행할 sql 명령의 id", sql 명령으로 전달할 데이터)
    mapper.insert("insert", vo);
  }

  // 전체 글 개수 확인하는 메소드
  // SelectService 클래스에서 호출되는 mapper를 넘겨받고
  // guestbook.xml 파일의 테이블에 저장된 전체 글의 개수를 얻어오는 SELECT SQL 명령을
  // 실행하는 메소드
  public int selectCount(SqlMapClient mapper) throws SQLException {
    System.out.println("GuestbookDAO.selectCount()");

    // queryForObject(): SELECT SQL 명령 실행 후 결과가 1건일 때 사용
    // queryForList(): SELECT SQL 명령 실행 후 결과가 여러 건일 때 사용

    return (int) mapper.queryForObject("selectCount");
  }

  // 페이지 처리하는 메소드
  // SelectService 클래스에서 호출되는 mapper를 넘겨받고
  // 화면에 표시할 페이지의 시작 인덱스 번호와 끝 인덱스 번호가 저장된 hashMap 개체를 넘겨받고
  // guestbook.xml 한 페이지 분량의 글 목록을 얻어오는 SELECT SQL 명령을 실행하는 메소드
  public ArrayList<GuestbookVO> selectList(SqlMapClient mapper, HashMap<String, Integer> hamp)
      throws SQLException {
    System.out.println("GuestbookDAO.selectList()");

    return (ArrayList<GuestbookVO>) mapper.queryForList("selectList", hamp);
  }
}
