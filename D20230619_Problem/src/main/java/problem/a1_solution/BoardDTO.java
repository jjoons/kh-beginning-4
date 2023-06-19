package problem.a1_solution;

public class BoardDTO {
  private int num; // 게시글 번호
  private String writer; // 게시글 작성자
  private String email; // 게시글 작성자의 이메일주소
  private String password; // 게시글 비밀번호
  private String subject; // 게시글 제목
  private String content; // 게시글 내용
  private String regDate; // 게시글 작성일
  private int readCount; // 게시글 조회 수
  private int ref;
  private int reStep;
  private int reLevel;

  public BoardDTO() {}

  public BoardDTO(int num, String writer, String email, String password, String subject,
      String content, String regDate, int readCount, int ref, int reStep, int reLevel) {
    super();
    this.num = num;
    this.writer = writer;
    this.email = email;
    this.password = password;
    this.subject = subject;
    this.content = content;
    this.regDate = regDate;
    this.readCount = readCount;
    this.ref = ref;
    this.reStep = reStep;
    this.reLevel = reLevel;
  }

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }

  public String getWriter() {
    return writer;
  }

  public void setWriter(String writer) {
    this.writer = writer;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getRegDate() {
    return regDate;
  }

  public void setRegDate(String regDate) {
    this.regDate = regDate;
  }

  public int getReadCount() {
    return readCount;
  }

  public void setReadCount(int readCount) {
    this.readCount = readCount;
  }

  public int getRef() {
    return ref;
  }

  public void setRef(int ref) {
    this.ref = ref;
  }

  public int getReStep() {
    return reStep;
  }

  public void setReStep(int reStep) {
    this.reStep = reStep;
  }

  public int getReLevel() {
    return reLevel;
  }

  public void setReLevel(int reLevel) {
    this.reLevel = reLevel;
  }

  @Override
  public String toString() {
    return "BoardDTO [num=" + num + ", writer=" + writer + ", email=" + email + ", password="
        + password + ", subject=" + subject + ", content=" + content + ", regDate=" + regDate
        + ", readCount=" + readCount + ", ref=" + ref + ", reStep=" + reStep + ", reLevel="
        + reLevel + "]";
  }
}
