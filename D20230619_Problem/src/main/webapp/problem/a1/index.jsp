<%@page import="problem.a1.BoardDAO"%>
<%@page import="problem.a1.ArticleDBConnect"%>
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
  BoardDAO dao = BoardDAO.getInstance();
  %>

  <%= dao.getBoardByNum(1) %>
</body>
</html>
