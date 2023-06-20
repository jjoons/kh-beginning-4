package problem.a1_solution;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

    // 게시글 고유번호를 증가시켜서 출력 0번부터 시작
    int num = BoardDAO.idNum + 1;

    // 현재 날짜를 가지고 옴
    String regDate = this.getDate();

    int ref = getMaxOfRef() + 1;
    int reStep = 1;
    int reLevel = 1;

    board.setNum(num);
    board.setRegDate(regDate);
    board.setReLevel(reLevel);
    board.setReStep(reStep);

    BoardDAO.idNum++;
    boardList.add(board);
  }

  // (2) 전체 게시글 수를 리턴해 주는 메소드
  public int getAllCount() {
    return this.boardList.size();
  }

  // (3) 현재 날짜를 리턴해 주는 메소드
  public String getDate() {
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    return sdf.format(date);
  }

  // (4) 최대 ref 값을 리턴하는 메소드
  public int getMaxOfRef() {
    int maxRef = 0;

    if (this.boardList.size() != 0) {
      int lastIndex = this.boardList.size() - 1;
      maxRef = boardList.get(lastIndex).getRef();
    }

    return maxRef;
  }

  // (5) 전체 게시글 내용을 출력해 주는 메소드 (콘솔에서 검토용)
  public void printBoardList() {
    for (BoardDTO temp : this.boardList) {
      System.out.println(temp);
    }

    System.out.println("\n");
  }

  // (6) boardList를 리턴해 주는 메소드
  public ArrayList<BoardDTO> getBoardList() {
    return this.boardList;
  }

  // (7) 게시글 번호를 넘겨받아 해당 게시글 정보를 리턴해 주는 메소드 (게시글 내용 확인하기)
  public BoardDTO getBoardOfInfo(int num) {
    // 게시글 리스트에서 인덱스 번호를 알아야한다
    int index = this.getBoardIndex(num);
    BoardDTO board = boardList.get(index);

    // 게시글을 선택했기 때문에 조회수를 1 증가시킨다
    board.setReadCount(board.getReadCount() + 1);

    return board;
  }

  // (7) 게시글 번호를 넘겨받으면 해당 게시글의 인덱스를 리턴해 주는 메소드
  public int getBoardIndex(int num) {
    int index = 0;

    for (int i = 0; i < this.boardList.size(); i++) {
      if (this.boardList.get(i).getNum() == num) {
        index = i;
      }
    }

    return index;
  }

  // (8) 게시글 번호를 넘겨받아 해당 게시글 정보를 리턴해 주는 메소드 (게시글 내용 수정하기)
  public BoardDTO getBoardOfUpdate(int num) {
    int index = this.getBoardIndex(num);
    return this.boardList.get(index);
  }

  // (9) 게시글 (이메일, 제목, 내용)을 수정하는 메소드
  public void boardUpdate(BoardDTO board) {
    int index = this.getBoardIndex(board.getNum());
    // BoardDTO temp = this.boardList.get(index);

    this.boardList.get(index).setEmail(board.getEmail());
    this.boardList.get(index).setSubject(board.getSubject());
    this.boardList.get(index).setContent(board.getContent());
  }

  // (10) 게시글 삭제해 주는 메소드: 비밀번호가 일치하면 1, 불일치하면 -1을 리턴한다
  public int boardDelete(int num, String password) {
    int result = -1;

    int index = this.getBoardIndex(num);
    String dbPassword = this.boardList.get(index).getPassword();

    if (dbPassword.equals(password)) {
      result = 1;
      this.boardList.remove(index);
    }

    return result;
  }

  // (11) 더미 파일 세팅
  public void setDummyData() {
    for (int i = 0; i < 10; i++) {
      int index = BoardDAO.idNum + 1;

      BoardDTO board = new BoardDTO();
      board.setWriter("작성자" + index);
      board.setSubject("제목" + index);
      board.setEmail("email" + index + "@example.com");
      board.setPassword("1234");
      board.setContent("내용" + index);

      this.boardWrite(board);
    }
  }

  // (12) 전체 게시글 삭제
  public void boardClear() {
    this.boardList.clear();
  }
}
