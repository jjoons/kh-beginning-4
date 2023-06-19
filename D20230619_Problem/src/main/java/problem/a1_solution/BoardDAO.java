package problem.a1_solution;

import java.util.ArrayList;

public class BoardDAO {
  private static BoardDAO instance = new BoardDAO();

  private BoardDAO() {}

  public static BoardDAO getInstance() {
    return instance;
  }

  // 게시글 고유 번호
  private static int idNum;
  private ArrayList<BoardDTO> boardList = new ArrayList<>();

  // 1. 새 게시글을 저장하는 메소드
  public void boardWrite(BoardDTO board) {
    /*
     * ① 게시글 번호 : 마지막 게시글 번호에 1을 증가시킨다.
     * ② 작성일        : Date클래스를 활용해 작성일자를 저장한다.
     * ③ ref        : 새글의 ref는 현재 최대 ref값에 1을 증가시킨다.
     * ④ reStep     : 새글의 reStep의 값은 1이다.
     * ⑤ reLevel    : 새글의 reLevel의 값은 1이다.
     */
  }
}
