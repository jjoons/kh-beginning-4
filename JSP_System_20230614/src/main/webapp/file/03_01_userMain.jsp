<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<body>
  <%
    String log = (String) session.getAttribute("log");
  
    if (log != null) {
  %>
    <p><%= log %>님 환영합니다</p>
    <p>
      <a href="">로그아웃</a>
    </p>
    <p>
      <a href="">회원정보수정</a>
    </p>
    <p>
      <a href="">회원탈퇴</a>
    </p>
  <% } else if (log == null) { %>
    <p>
      <a href="03_02_join.jsp">회원가입</a>
    </p>
    <p>
      <a href="03_04_login.jsp">로그인</a>
    </p>
  <% } %>
</body>
</html>
