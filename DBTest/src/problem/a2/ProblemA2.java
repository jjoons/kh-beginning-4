package problem.a2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProblemA2 {
  public static void main(String[] args) throws SQLException {
    /*
     * 1. bookstore 데이터베이스를 이용해서 book 테이블 내용을 꺼내온다.
     * 2. book클래스를 이용해서 객체 생성해서 arraylist에 넣어서 전체 출력하세요!
     *   출력을 할 때는 메서드 이용해도 되고 내가 만든 메서드에 arraylist 전달해서 
     *   출력해도 됩니다!.
     */

    Connection con =
        DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db2_book_store", "root", "1234");
    Statement st = con.createStatement();

    ArrayList<ProblemA2Book> books = new ArrayList<>();

    ResultSet result = st.executeQuery("SELECT * FROM book");

    while (result.next()) {
      int bookNo = result.getInt("book_no");
      String bookKind = result.getString("book_kind");
      String bookTitle = result.getString("book_title");
      int bookPrice = result.getInt("book_price");
      int bookCount = result.getInt("book_count");
      String bookAuthor = result.getString("book_author");
      String bookPublishingCom = result.getString("book_publishing_com");
      String bookPublishingDate = result.getString("book_publishing_date");
      String bookImage = result.getString("book_image");
      String bookContent = result.getString("book_content");
      int bookDiscountRate = result.getInt("book_discount_rate");
      Date bookRegDate = result.getDate("book_reg_date");

      ProblemA2Book book = new ProblemA2Book(bookNo, bookKind, bookTitle, bookPrice, bookCount,
          bookAuthor, bookPublishingCom, bookPublishingDate, bookImage, bookContent,
          bookDiscountRate, bookRegDate);
      books.add(book);
    }

    for (ProblemA2Book book : books) {
      System.out.println(book);
    }
  }
}
