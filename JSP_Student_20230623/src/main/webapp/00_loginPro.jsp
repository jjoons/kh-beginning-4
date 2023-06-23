<%@page import="java.sql.Connection"%>
<%@page import="enrolment.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>로그인</title>
</head>
<body>
  <%
    // login.jsp 에서 넘어온 데이터를 꺼낸다
    String hakbun = request.getParameter("hakbun");
    String passwd = request.getParameter("passwd");
    
    // 실제 체크를 해야 한다.
    // StudentDAO가 체크한 다음 데이터가 있으면 세션에 학번을 저장하고 메인으로 이동한다
    StudentDAO sDao = StudentDAO.getInstance();
    int check = sDao.studentCheck(hakbun, passwd);
    
    // 만약 데이터가 있으면 1을 넘겨받고 없으면 0
    if (check == 1) {
      session.setAttribute("hakbun", hakbun);
      response.sendRedirect("01_Main.jsp");
    } else if (check == 0) {
  %>
    <script>
      alert('비밀번호가 맞지 않습니다')
      history.go(-1)
    </script>
  <% } else { %>
    <script>
      alert('학번이 맞지 않습니다')
      history.go(-1)
    </script>
  <% } %>
</body>
</html>
