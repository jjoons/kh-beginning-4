package problem.a1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
  private static BoardDAO instance = null;
  private ArticleDBConnect db = ArticleDBConnect.getInstance();
  private Connection con = null;

  private BoardDAO() throws Exception {
    this.con = db.getConnection();

    if (this.con == null) {
      throw new Exception("DB 연결 오류");
    }
  }

  public static BoardDAO getInstance() throws Exception {
    if (instance == null) {
      instance = new BoardDAO();
    }

    return instance;
  }

  // (1) 새 게시글을 저장해주는 메서드
  /* 아래 5개의 항목은 입력받을 수 없는 데이터로서
   * 직접 값을 저장해줘야 한다.
   * 
   * ① 게시글 번호 : 마지막 게시글 번호에 1을 증가시킨다.
   * ② 작성일        : Date클래스를 활용해 작성일자를 저장한다.
   * ③ ref        : 새글의 ref는 현재 최대 ref값에 1을 증가시킨다.
   * ④ reStep     : 새글의 reStep의 값은 1이다.
   * ⑤ reLevel    : 새글의 reLevel의 값은 1이다.
   */
  public int add(BoardDTO board) {
    if (!this.validate(board)) {
      return -1;
    }

    String sql =
        "INSERT INTO d20230619p1_articles(writer, email, password, subject, content, reg_date, read_count) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?)";
    try (PreparedStatement ps = this.con.prepareStatement(sql)) {
      ps.setString(1, board.getWriter());
      ps.setString(2, board.getEmail());
      ps.setString(3, board.getPassword());
      ps.setString(4, board.getSubject());
      ps.setString(5, board.getContent());
      ps.setString(6, board.getRegDate());
      ps.setInt(7, board.getReadCount());

      return ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();

      return -1;
    }
  }

  public boolean validate(BoardDTO board) {
    if (board.getNum() == 0 || board.getWriter() == null || board.getEmail() == null
        || board.getPassword() == null || board.getSubject() == null || board.getContent() == null
        || board.getRegDate() == null || board.getReadCount() < 0) {
      return false;
    }

    return true;
  }

  //(2) 전제 게시글 수를 리턴해주는 메서드
  public int getTotalCount() {
    String sql = "SELECT COUNT(*) AS total_count FROM d20230619p1_articles";

    try (PreparedStatement ps = this.con.prepareStatement(sql)) {
      ResultSet rs = ps.executeQuery();

      if (rs.next()) {
        return rs.getInt("total_count");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return -1;
  }

  //(3) 오늘 날짜를 문자열로 리턴해주는 메서드
  public String getTodayDate() {
    LocalDateTime ldt = LocalDateTime.now();

    return ldt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
  }

  //(4) 최대 ref 값을 리턴해주는 메서드
  //(5) 전체 게시글 내용을 출력해주는 메서드 <-- 콘솔에서 검토용
  //(6) boardList를 리턴해주는 메서드
  public List<BoardDTO> getBoards(boolean reverse) {
    List<BoardDTO> list = new ArrayList<>();
    String sql = new StringBuilder().append("SELECT * FROM d20230619p1_articles")
        .append(reverse ? " ORDER BY id DESC" : "")
        .append(" OFFSET 0 ROWS FETCH NEXT 1000 ROWS ONLY").toString();

    try (PreparedStatement ps = this.con.prepareStatement(sql)) {
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        BoardDTO dto = new BoardDTO();

        dto.setNum(rs.getInt("id")).setWriter(rs.getString("writer"))
            .setEmail(rs.getString("email")).setPassword(rs.getString("password"))
            .setSubject(rs.getString("subject")).setContent(rs.getString("content"))
            .setRegDate(rs.getString("reg_date")).setReadCount(rs.getInt("read_count"));

        list.add(dto);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }

    return list;
  }

  public List<BoardDTO> getBoards() {
    return this.getBoards(false);
  }

  //(7) 게시글 번호를 넘겨받으면 해당 게시글의 인덱스를 리턴해주는 메서드
  //(7) 게시글 번호를 넘겨받아 해당 게시글 정보를 리턴해주는 메서드(게시글 내용 확인하기)
  public BoardDTO getBoardByNum(int num) {
    String sql = "SELECT * FROM d20230619p1_articles WHERE id = ?";

    try (PreparedStatement ps = this.con.prepareStatement(sql)) {
      ps.setInt(1, num);
      ResultSet rs = ps.executeQuery();

      if (rs.next()) {
        BoardDTO dto = new BoardDTO();

        dto.setNum(rs.getInt("id"));
        dto.setWriter(rs.getString("writer"));
        dto.setEmail(rs.getString("email"));
        dto.setPassword(rs.getString("password"));
        dto.setSubject(rs.getString("subject"));
        dto.setContent(rs.getString("content"));
        dto.setRegDate(rs.getString("reg_date"));
        dto.setReadCount(rs.getInt("read_count"));

        return dto;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return null;
  }

  //(8) 게시글 번호를 넘겨받아 해당 게시글 정보를 리턴해주는 메서드(게시글 내용 수정하기)
  //(9) 게시글의 내용을(이메일,제목,내용) 수정해주는 메서드
  //(10) 게시글 삭제해주는 메서드 : 비밀번호가 일치하면 1을 불일치하면 -1을 리턴해준다.

  private boolean increaseReadCount() {
    String sql = "UPDATE d20230619p1_articles SET read_count = ? WHERE id = ?";

    try (PreparedStatement ps = this.con.prepareStatement(sql)) {
      // ps.setInt(1, 0);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return false;
  }
}
