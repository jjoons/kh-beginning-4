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
  <% request.setCharacterEncoding("utf-8"); %>
  <%
    int num = Integer.parseInt(request.getParameter("num"));
    String password = request.getParameter("password");
    
    int result = BoardDAO.getInstance().boardDelete(num, password);
    
    if (result == 1) {
  %>
    <script>
      alert('삭제되었습니다');
      location.href = '04_boardList.jsp';
    </script>
  <% } else if (result == -1) { %>
    <script>
      alert('비밀번호를 확인해 주세요');

      // 이전 페이지로 돌아가기 위해서 사용하는 메소드
      history.go(-1);
    </script>
  <% } %>
</body>
</html>
