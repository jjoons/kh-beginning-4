package com.kh.service;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.kh.dao.FreeboardDAO;
import com.kh.mybatis.MySession;
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

  public List<FreeboardVO> getBoards() {
    List<FreeboardVO> list = dao.getBoards(session);

    return list;
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
}
