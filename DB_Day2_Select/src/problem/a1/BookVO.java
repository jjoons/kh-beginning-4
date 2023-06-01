package problem.a1;

import java.util.Objects;

public class BookVO {
  private int bookId;
  private String bookName;
  private String publisher;
  private int price;

  public BookVO(int bookId, String bookName, String publisher, int price) {
    this.bookId = bookId;
    this.bookName = bookName;
    this.publisher = publisher;
    this.price = price;
  }

  public int getBookId() {
    return bookId;
  }

  public String getBookName() {
    return bookName;
  }

  public String getPublisher() {
    return publisher;
  }

  public int getPrice() {
    return price;
  }

  @Override
  public int hashCode() {
    return Objects.hash(bookId, bookName, price, publisher);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    BookVO other = (BookVO) obj;
    return bookId == other.bookId && Objects.equals(bookName, other.bookName)
        && price == other.price && Objects.equals(publisher, other.publisher);
  }

  @Override
  public String toString() {
    return "BookVO [bookId=" + bookId + ", bookName=" + bookName + ", publisher=" + publisher
        + ", price=" + price + "]";
  }
}
