<%@page import="java.text.NumberFormat"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.multipart.FileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="bookstore.BookUtil"%>
<%@page import="bookstore.BookDTO"%>
<%@page import="java.util.List"%>
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
    String book_kind = request.getParameter("book_kind");
    BookDAO dao = BookDAO.getInstance();
    
    String bookKindName = BookUtil.getBookKindName(book_kind);
    
    ServletContext context = getServletContext();
    String realFolder = context.getRealPath(BookUtil.getSavePath());
    // MultipartRequest multi = new MultipartRequest(request, realFolder, BookUtil.getFileUploadMaxSize(), "utf-8", new DefaultFileRenamePolicy());
  %>
  <h2><%= bookKindName %> 분류의 목록</h2>
  <a href="00_shopMain.jsp">메인으로</a>
  <%
    for (BookDTO dto : dao.getBooks("all")) {
      NumberFormat nf = NumberFormat.getIntegerInstance();
      int discountPrice = (int) (dto.getBook_price() * ((float) (100 - dto.getDiscount_rate()) / 100));
      
  %>
    <table border="1">
      <colgroup>
        <col />
        <col width="350" />
        <col width="100" />
      </colgroup>
      <tbody>
        <tr>
          <td rowspan="4">
            <img alt="" src="imageFileSave/<%= dto.getBook_image() %>" height="100" width="75" />
          </td>
        	<td>
            <a href="17_bookContent.jsp?book_id=<%= dto.getBook_id() %>">
              <font color="blue">
                <%= dto.getBook_title() %>
              </font>
            </a>
          </td>
          <td rowspan="4">
            
          </td>
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
      </tbody>
    </table>
  <% } %>
</body>
</html>
