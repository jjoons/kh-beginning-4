<%@page import="problem.a1_solution.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%
    BoardDAO.getInstance().setDummyData();
    response.sendRedirect("04_boardList.jsp");
  %>
</body>
</html>
