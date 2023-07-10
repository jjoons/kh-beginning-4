package com.kh.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.kh.vo.FreeboardVO;

public class FreeboardDAO {
  private static FreeboardDAO instance = null;

  private FreeboardDAO() {}

  public static FreeboardDAO getInstance() {
    if (instance == null) {
      instance = new FreeboardDAO();
    }

    return instance;
  }

  public List<FreeboardVO> getBoards(SqlSession mapper) {
    return mapper.<FreeboardVO>selectList("selectGetBoards");
  }

  public int insert(SqlSession mapper, FreeboardVO vo) {
    return mapper.insert("insert", vo);
  }

  public FreeboardVO getBoardById(SqlSession session, int id) {
    return (FreeboardVO) session.selectOne("selectGetBoard", id);
  }

  public int increaseReadCount(SqlSession session, int id) {
    int result = session.update("updateIncreaseReadCount", id);

    if (result > 0) {
      session.commit();
    }

    return result;
  }

  public int addDummy(SqlSession session, int count) {
    return session.insert("insertDummy");
  }
}
