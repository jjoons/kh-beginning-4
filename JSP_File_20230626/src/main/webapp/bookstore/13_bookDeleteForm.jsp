<%@page import="bookstore.BookDTO"%>
<%@page import="bookstore.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
  String managerId = (String) session.getAttribute("managerId");
  
  if (managerId == null) {
    response.sendRedirect("00_shopMain.jsp");
  } else {
    // 수정할 때는 book_id와 book_kind
    int book_id = Integer.parseInt(request.getParameter("book_id"));
    String book_kind = request.getParameter("book_kind");
    
    BookDAO dao = BookDAO.getInstance();
    
    // 수정은 이미 데이터가 input에 저장되어있다
    // 현재 id 값을 기준으로 해서 저장된 수정을 누른 데이터의 정보를 가지고 와야된다
    BookDTO dto = dao.getBook(book_id);
%>
  <!DOCTYPE html>
  <html lang="ko">
  <head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
  </head>
  <body>
    <%
      
    %>
  </body>
  </html>
<% } %>
