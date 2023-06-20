<%@page import="problem.a1_solution.BoardDTO"%>
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
    request.setCharacterEncoding("utf-8");
  %>
  
  <!-- 액션 태그 이용해서 객체 생성 -->
  <jsp:useBean id="boardDTO" class="problem.a1_solution.BoardDTO">
    <jsp:setProperty property="*" name="boardDTO" />
  </jsp:useBean>
  
  <%
    // DAO 클래스로 데이터를 전송해서 처리하는 내용
    BoardDAO.getInstance().boardWrite(boardDTO);
  
    // 새 글을 보여주는 목록으로 이동시킨다
    response.sendRedirect("04_boardList.jsp");
  %>
</body>
</html>
