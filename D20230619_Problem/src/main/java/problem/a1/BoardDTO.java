package problem.a1;

public class BoardDTO {
  private int num; // 게시글 번호
  private String writer; // 게시글 작성자
  private String email; // 게시글 작성자의 이메일주소
  private String password; // 게시글 비밀번호
  private String subject; // 게시글 제목
  private String content; // 게시글 내용
  private String regDate; // 게시글 작성일
  private int readCount; // 게시글 조회 수

  public int getNum() {
    return num;
  }

  public BoardDTO setNum(int num) {
    this.num = num;
    return this;
  }

  public String getWriter() {
    return writer;
  }

  public BoardDTO setWriter(String writer) {
    this.writer = writer;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public BoardDTO setEmail(String email) {
    this.email = email;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public BoardDTO setPassword(String password) {
    this.password = password;
    return this;
  }

  public String getSubject() {
    return subject;
  }

  public BoardDTO setSubject(String subject) {
    this.subject = subject;
    return this;
  }

  public String getContent() {
    return content;
  }

  public BoardDTO setContent(String content) {
    this.content = content;
    return this;
  }

  public String getRegDate() {
    return regDate;
  }

  public BoardDTO setRegDate(String regDate) {
    this.regDate = regDate;
    return this;
  }

  public int getReadCount() {
    return readCount;
  }

  public BoardDTO setReadCount(int readCount) {
    this.readCount = readCount;
    return this;
  }

  @Override
  public String toString() {
    return "BoardDTO [num=" + num + ", writer=" + writer + ", email=" + email + ", password="
        + password + ", subject=" + subject + ", content=" + content + ", regDate=" + regDate
        + ", readCount=" + readCount + "]";
  }
}
