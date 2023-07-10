package com.kh.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;
import com.kh.dao.FreeboardDAO;
import com.kh.mybatis.MySession;
import com.kh.vo.FreeboardList;
import com.kh.vo.FreeboardVO;

public class FreeboardService {
  private static FreeboardService instance = null;
  private SqlSession session = MySession.getSession();
  private FreeboardDAO dao = FreeboardDAO.getInstance();

  private FreeboardService() {}

  public static FreeboardService getInstance() {
    if (instance == null) {
      instance = new FreeboardService();
    }

    return instance;
  }

  public FreeboardList getBoards(int perPage, int page) {
    List<FreeboardVO> list = dao.getBoards(session);
    FreeboardList boardList = new FreeboardList(list, perPage, page);

    return boardList;
  }

  public int insert(FreeboardVO vo) {
    // 데이터베이스 정보 획득

    return dao.insert(session, vo);
  }

  public FreeboardVO getBoard(int id) {
    FreeboardVO board = dao.getBoardById(session, id);

    if (board != null) {
      this.increaseReadCount(id);
    }

    return board;
  }

  public int increaseReadCount(int id) {
    return dao.increaseReadCount(session, id);
  }

  // list.nhn 이라는 요청이 들어오면 컨트롤러에서 호출하는 메소드로
  // mapper를 얻은 후 MVCBoardDAO 클래스의 브라우저에 1페이지 분량의
  // 글 목록과 페이징 작업에 사용할 8개의 변수가 저장된 클래스의 객체를 만들어
  // request 영역에 저장하는 메소드를 호출하는 메소드
  public void selectList(HttpServletRequest req, HttpServletResponse res) {
    // 현재 페이지를 보고 있다면 현재 페이지의 번호를 보고 글 목록을 가지고 와야 된다
    // 만약 현재 페이지의 번호가 넘어오지 않는다면 오류가 발생할 수 있다
    // 넘어오지 않으면 무조건 1페이지를 보여줄 수 있도록 코딩
  }

  public boolean addDummy(int count) {
    return this.dao.addDummy(this.session, count) > 0;
  }
}
