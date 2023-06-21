<%@page import="java.util.Collections"%>
<%@page import="java.util.Comparator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="problem.a1.BoardDTO"%>
<%@page import="problem.a1.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
  String pageString = request.getParameter("page");
  String perPageString = request.getParameter("per_page");

  int perPage = 10;
  int pageA = 1;

  if (pageString != null) {
    try {
      pageA = Integer.parseInt(pageString);
    } catch (NumberFormatException e) {
      e.printStackTrace();
      pageA = -1;
    }
  }
  
  if (perPageString != null) {
    try {
      perPage = Integer.parseInt(perPageString);
    } catch (NumberFormatException e) {
      e.printStackTrace();
      perPage = -1;
    }
  }
  
  BoardDAO dao = BoardDAO.getInstance();
  List<BoardDTO> boards = dao.getBoards(perPage, pageA);

  int total = dao.getTotalCount();
%>
<html lang="ko">
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
  <style>
    ._buttons {
      display: flex;
      justify-content: space-between;
    }
  </style>
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
            <col />
          </colgroup>
          <thead>
            <tr>
              <th scope="col">번호</th>
              <th scope="col">제목</th>
              <th scope="col">작성자</th>
              <th scope="col">시간</th>
              <th scope="col">조회</th>
            </tr>
          </thead>
          <tbody>
            <%
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
                <td><%= board.getReadCount() %></td>
              </tr>
            <%
                }
              } else {
            %>
              <tr>
                <td colspan="4">게시글이 없습니다.</td>
              </tr>
            <% } %>
          </tbody>
        </table>
      </div>
      <jsp:include page="components/pagination.jsp">
        <jsp:param name="page" value="<%= pageA %>" />
        <jsp:param name="per_page" value="<%= perPage %>" />
        <jsp:param name="total" value="<%= total %>" />
      </jsp:include>
      <div class="_buttons">
        <div>
          <button type="button" class="btn btn-primary">더미 추가</button>
        </div>
        <div>
          <button type="button" class="btn btn-danger">전체 삭제</button>
        </div>
      </div>
    </div>
  </div>
  <script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
    crossorigin="anonymous"
  ></script>
  <script>
    
  </script>
</body>
</html>
