package com.kh.dao;

import java.sql.SQLException;
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
}
