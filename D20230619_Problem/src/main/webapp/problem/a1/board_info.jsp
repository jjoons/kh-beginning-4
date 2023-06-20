<%@page import="problem.a1.BoardDTO"%>
<%@page import="problem.a1.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
  String idString = request.getParameter("id");
  
  int id = -1;

  try {
    id = Integer.parseInt(idString);
  } catch (NumberFormatException e) {
    e.printStackTrace();
  }
  
  BoardDAO dao = BoardDAO.getInstance();
  BoardDTO board = dao.getBoardByNum(id);
%>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title><%= board != null ? board.getSubject() + " - " : "" %>게시글</title>
  <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
    crossorigin="anonymous"
  />
  <link rel="stylesheet" href="css/common.css" media="all" />
</head>
<body>
  <div id="wrap">
    <main class="_inner">
      <%
        if (board != null) {
          
      %>
        <article>
          <header class="">
            <div class="fs-2"><%= board.getSubject() %></div>
            <div><%= board.getRegDate() %></div>
            <div>조회수: <%= board.getReadCount() %></div>
            <div><%= board.getWriter() %></div>
          </header>
          <section>
            <%= board.getContent() %>
          </section>
        </article>
      <% } else { %>
        <div>오류가 발생했습니다.</div>
      <% } %>
    </main>
  </div>
  <script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
    crossorigin="anonymous"
  ></script>
</body>
</html>
