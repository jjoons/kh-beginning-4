<%@page import="bookstore.BookUtil"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="bookstore.BookDTO"%>
<%@page import="bookstore.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
  <%
    boolean isLogin = session.getAttribute("id") != null;
    String book_idString = request.getParameter("book_id");
    int book_id = -1;

    try {
      book_id = Integer.parseInt(book_idString);
    } catch (NumberFormatException e) {
      e.printStackTrace();
    }
  
    BookDAO dao = BookDAO.getInstance();
    BookDTO dto = dao.getBook(book_id);
    
    NumberFormat nf = NumberFormat.getNumberInstance();
    int discountPrice = BookUtil.calcDiscountPrice(dto.getBook_price(), dto.getDiscount_rate());
  %>
  <table border="1">
    <colgroup>
      <col width="200" />
      <col />
    </colgroup>
  	<tbody>
  		<tr>
  			<td rowspan="6">
          <img src="imageFileSave/<%= dto.getBook_image() %>" alt="" width="200" />
        </td>
        <td><%= dto.getBook_title() %></td>
  		</tr>
      <tr>
        <td>출판사: <%= dto.getPublishing_com() %></td>
      </tr>
      <tr>
        <td>저자: <%= dto.getAuthor() %></td>
      </tr>
      <tr>
        <td>
          정가: <%= nf.format(dto.getBook_price()) %>원
          <br />
          판매가: <%= nf.format(discountPrice) %>원
        </td>
      </tr>
      <tr>
      	<td>
          수량: <input type="number" name="count" min="1" value="1" />개
          <% if (isLogin) { %>
            <input type="submit" value="장바구니에 담기" />
          <% } %>
          <button type="button">목록으로</button>
          <button type="button">메인으로</button>
        </td>
      </tr>
      <tr>
      	<td><%= dto.getBook_content() %></td>
      </tr>
  	</tbody>
  </table>
</body>
</html>
