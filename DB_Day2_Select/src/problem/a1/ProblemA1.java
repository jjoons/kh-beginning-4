package problem.a1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProblemA1 {
  public static void main(String[] args) {
    BookStoreDBConnect db = BookStoreDBConnect.getInstance();

    try (Connection con = db.getConnection(); Statement st = con.createStatement()) {
      ResultSet res = st.executeQuery("SELECT * FROM book");
      ArrayList<BookVO> books = new ArrayList<>();

      while (res.next()) {
        int bookId = res.getInt("bookid");
        String bookName = res.getString("bookname");
        String publisher = res.getString("publisher");
        int price = res.getInt("price");

        books.add(new BookVO(bookId, bookName, publisher, price));
      }

      System.out.println("번호\t|\t이름\t|\t출판사\t|\t금액");
      for (BookVO book : books) {
        System.out.println(book.getBookId() + "\t|\t" + book.getBookName() + "\t|\t"
            + book.getPublisher() + "\t|\t" + book.getPrice());
      }
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }
}
