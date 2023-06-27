<%@page import="bookstore.BookDAO"%>
<%@page import="bookstore.BookDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
  String managerId = (String) session.getAttribute("managerId");
  
  if (managerId == null) {
    response.sendRedirect("00_shopMain.jsp");
  } else {
    // 로그인을 해서 관리자 확인이 되면 관리자 페이지를 확인할 수 있음
    ArrayList<BookDTO> bookList = null;
    int number = 0;
    String book_kind = request.getParameter("book_kind");
    
    BookDAO dao = BookDAO.getInstance();
    int count = dao.getBookCount();
    
    bookList = new ArrayList<>();
    
    if (count > 0) {
      bookList = (ArrayList<BookDTO>) dao.getBooks(book_kind); 
    }
    
    String book_kindName = "";
    
    if (book_kind.equals("100")) {
      book_kindName = "문학";
    } else if (book_kind.equals("200")) {
      book_kindName = "외국어";
    } else if (book_kind.equals("300")) {
      book_kindName = "컴퓨터";
    } else if (book_kind.equals("all")) {
      book_kindName = "전체";
    }
%>
  <!DOCTYPE html>
  <html lang="ko">
  <head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
  </head>
  <body>
    <!--
      관리자 전용 페이지. 상품을 등록하면 분류에 따라서 등록한 분류 목록을 보여준다
      만약 관리자가 아닐 경우에는 메인 페이지(00_shopMain.jsp)로 이동
      현재 추가한 분류 목록을 가지고 책들을 리스트에 올린다
      현재 추가한 분류 목록의 책의 정보들을 전부 가지고 올 것인지
      현재 전체 조회가 아니라면 각각 분류 목록의 count를 해야 한다
    -->
    <a href="06_managerMain.jsp">관리자 메인으로</a>
    <br />
    <%= book_kindName %>분류의 목록: <%= bookList.size() %>개
    <table border="1">
    	<tr>
    		<td>
          <a href="08_bookRegisterForm.jsp">책 등록</a>
        </td>
    	</tr>
    </table>
    <table border="1">
    	<thead>
    		<tr>
    			<th>번호</th>
    			<th>책분류</th>
    			<th>제목</th>
    			<th>가격</th>
    			<th>수량</th>
    			<th>저자</th>
    			<th>출판사</th>
    			<th>출판일</th>
    			<th>책이미지</th>
    			<th>할인율</th>
    			<th>등록일</th>
    			<th>수정</th>
    			<th>삭제</th>
    		</tr>
    	</thead>
      <tbody>
        <%
          for (int i = 0; i < bookList.size(); i++) {
            BookDTO dto = bookList.get(i);
        %>
          <tr>
          	<td><%= dto.getBook_id() %></td>
          	<td><%= dto.getBook_kind() %></td>
          	<td><%= dto.getBook_title() %></td>
          	<td><%= dto.getBook_price() %></td>
          	<td><%= dto.getBook_count() %></td>
          	<td><%= dto.getAuthor() %></td>
          	<td><%= dto.getPublishing_com() %></td>
          	<td><%= dto.getPublishing_date() %></td>
          	<td><%= dto.getBook_image() %></td>
          	<td><%= dto.getDiscount_rate() %></td>
          	<td><%= dto.getReg_date() %></td>
          	<td>
              <a href="11_bookUpdateForm.jsp?book_id=<%= dto.getBook_id()%>&book_kind=<%= dto.getBook_kind()%>">수정</a>
            </td>
          	<td>
              <a href="13_bookDeleteForm.jsp?book_id=<%= dto.getBook_id()%>&book_kind=<%= dto.getBook_kind()%>">삭제</a>
            </td>
          </tr>
        <% } %>
      </tbody>
    </table>

  <% if (false) { // 강사님 코드 %>
    <a href="06_managerMain.jsp">관리자 메인으로</a> &nbsp;
    <p><%= book_kindName %>분류의 목록 :
      <% if(book_kind.equals("all")) { %>
        <%= count %>개
      <% }else { %>
        <%= bookList.size() %>개
      <% } %>
    </p>
    
    <table border="1">
      <tr>
        <td align="right">
          <a href="08_bookRegisterForm.jsp">책 등록</a>
        </td>
      </tr>
    </table>
    
    <%
      if(count == 0){
    %>
      <table border="1">
        <tr>
          <td align="center">
            등록된 책이 없습니다.
          </td>
        </tr>
      </table>
    <% }else { %>
      <table border="1">
            <tr height="30"> 
            <td align="center"  width="30">번호</td> 
            <td align="center"  width="30">책분류</td> 
            <td align="center"  width="100">제목</td>
            <td align="center"  width="50">가격</td> 
            <td align="center"  width="50">수량</td> 
            <td align="center"  width="70">저자</td>
            <td align="center"  width="70">출판사</td>
            <td align="center"  width="120">출판일</td>
            <td align="center"  width="100">책이미지</td>
            <td align="center"  width="30">할인율</td>
            <td align="center"  width="150">등록일</td>
            <td align="center"  width="50">수정</td>
            <td align="center"  width="50">삭제</td>         
          </tr>
          
          <% 
            for(int i=0; i<bookList.size(); i++) {
              BookDTO dto = bookList.get(i);
          %>
          <tr height="30">
            <td width="30"><%= ++number %></td>
            <td width="30"><%= dto.getBook_kind() %></td>
            <td width="100"><%= dto.getBook_title() %></td>
            <td width="50" align="right"><%= dto.getBook_price() %></td>
            <td width="50" align="right">
            <!-- 전체 수량이 아니라 각 책의 수량을 가져오는 getter -->
            <% if(dto.getBook_count() == 0){ %>
              <font color="red">일시품절</font>
            <% }else { %>
              <%= dto.getBook_count() %>
            <% } %>
            </td>
            <td width="70"><%= dto.getAuthor() %></td>
            <td width="70"><%= dto.getPublishing_com() %></td>
            <td width="120"><%= dto.getPublishing_date() %></td>
            <td width="100"><%= dto.getBook_image() %></td>
            <td width="50"><%= dto.getDiscount_rate() %></td>
            <td width="150"><%= dto.getReg_date() %></td>
            <td width="50">
               <a href="11_bookUpdateForm.jsp?book_id=<%= dto.getBook_id()%>&book_kind=<%= dto.getBook_kind()%>">수정</a></td>
            <td width="50">
               <a href="13_bookDeleteForm.jsp?book_id=<%= dto.getBook_id()%>&book_kind=<%= dto.getBook_kind()%>">삭제</a></td>                
          </tr>
          <% } %>
      </table>      
    <% } %>
<% } %>
    </body>
  </html>
<% } %>
