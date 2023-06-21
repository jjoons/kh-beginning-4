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
  <!--
    1. 등록하기를 누르면 DTO가 객체 생성을 해야한다. 액션 태그 사용하기
    2. 글의 번호가 몇 번인지 가지고 오기
    3. DAO가 처리할 수 있도록 boardReplyWrite(번호, board)
    4. sendRedirect("04_boardList.jsp");
    
    답글을 저장하는 메소드를 DAO 안에 작성
    현재 답글을 단 게시글의 번호를 가지고 온다.
      그 게시글의 실제 저장을 맡고 있는 arrList의 index를 가지고 와야 된다
      ref 변수들을 이용해서 답글에 대해 추가하는 내용 작성
    새로운 답글도 list에 추가해야 한다. 그리고 idNum 증가
  -->
  <%
    request.setCharacterEncoding("utf-8");

    int num = Integer.parseInt(request.getParameter("num"));
    
  %>
  
  <jsp:useBean id="board" class="problem.a1_solution.BoardDTO">
    <jsp:setProperty property="board" name="*" />
  </jsp:useBean>
  
  <%
    BoardDAO.getInstance().boardReplyWrite(num, board);
    response.sendRedirect("04_boardList.jsp");
  %>
</body>
</html>
