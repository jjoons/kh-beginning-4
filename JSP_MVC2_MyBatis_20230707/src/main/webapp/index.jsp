<%@page import="oracle.jdbc.replay.driver.NonTxnReplayableResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Insert title here</title>
</head>
<body>
  <%
    // 게시판이 최초로 실핼될 때 또는 INSERT, SELECT, DELETE, UPDATE SQL
    // 명령이 실행되고 난 뒤 브라우저에 표시할 1페이지 분량의 글 목록을 얻어오는 요청을 컨트롤러한테 한다
    response.sendRedirect("list.nhn");
  %>
</body>
</html>
