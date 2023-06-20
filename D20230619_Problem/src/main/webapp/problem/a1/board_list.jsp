<%@page import="java.util.Collections"%>
<%@page import="java.util.Comparator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="problem.a1.BoardDTO"%>
<%@page import="problem.a1.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>게시글 목록</title>
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
    <div class="_inner">
      <h2>게시글 목록</h2>
      <div id="articles">
        <table class="table table-hover">
          <colgroup>
            <col />
            <col />
            <col />
            <col style="width: 200px;" />
          </colgroup>
          <thead>
            <tr>
              <th>번호</th>
              <th>제목</th>
              <th>작성자</th>
              <th>시간</th>
            </tr>
          </thead>
          <tbody>
            <%
              BoardDAO dao = BoardDAO.getInstance();
              List<BoardDTO> boards = dao.getBoards(true);
              
              if (boards.size() > 0) {
                for (BoardDTO board : boards) {
            %>
              <tr>
                <td><%= board.getNum() %></td>
                <td>
                  <a href="board_info.jsp?id=<%= board.getNum() %>">
                    <%= board.getSubject() %>
                  </a>
                </td>
                <td><%= board.getWriter() %></td>
                <td><%= board.getRegDate() %></td>
              </tr>
            <%
                }
              } else {
            %>
              <tr>
                <td rowspan="4">게시글이 없습니다.</td>
              </tr>
            <% } %>
          </tbody>
        </table>
      </div>
    </div>
  </div>
  <script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
    crossorigin="anonymous"
  ></script>
</body>
</html>
