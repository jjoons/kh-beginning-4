package problem.a2;

import java.sql.Date;

public class ProblemA2Book {
  private int no;
  private String kind;
  private String title;
  private int price;
  private int count;
  private String author;
  private String publishingComl;
  private String publishingDate;
  private String image;
  private String content;
  private int discountRate;
  private Date regDate;

  public ProblemA2Book() {}

  public ProblemA2Book(int no, String kind, String title, int price, int count, String author,
      String publishingComl, String publishingDate, String image, String content, int discountRate,
      Date regDate) {
    this.no = no;
    this.kind = kind;
    this.title = title;
    this.price = price;
    this.count = count;
    this.author = author;
    this.publishingComl = publishingComl;
    this.publishingDate = publishingDate;
    this.image = image;
    this.content = content;
    this.discountRate = discountRate;
    this.regDate = regDate;
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getKind() {
    return kind;
  }

  public void setKind(String kind) {
    this.kind = kind;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getPublishingComl() {
    return publishingComl;
  }

  public void setPublishingComl(String publishingComl) {
    this.publishingComl = publishingComl;
  }

  public String getPublishingDate() {
    return publishingDate;
  }

  public void setPublishingDate(String publishingDate) {
    this.publishingDate = publishingDate;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public int getDiscountRate() {
    return discountRate;
  }

  public void setDiscountRate(int discountRate) {
    this.discountRate = discountRate;
  }

  public Date getRegDate() {
    return regDate;
  }

  public void setRegDate(Date regDate) {
    this.regDate = regDate;
  }

  @Override
  public String toString() {
    return "ProblemA2Book [no=" + no + ", kind=" + kind + ", title=" + title + ", price=" + price
        + ", count=" + count + ", author=" + author + ", publishingComl=" + publishingComl
        + ", publishingDate=" + publishingDate + ", image=" + image + ", content=" + content
        + ", discountRate=" + discountRate + ", regDate=" + regDate + "]";
  }
}
