<%@page import="_05_User.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>로그인 처리 페이지</title>
</head>
<body>
  <% request.setCharacterEncoding("utf-8"); %>
  <%
    String id = request.getParameter("id");
    String pw = request.getParameter("pw");

    // 아이디와 패스워드를 확인하는 메소드
    boolean check = UserDAO.getInstance().checkUserIdPw(id, pw);

    if (check) {
      // 회원가입한 내용이 있을 경우에는 세션을 만들어준다
      session.setAttribute("log", id);
      
      // 세션 유효시간 섲엉으로 1분 후 자동으로 세션이 삭제되도록 설정
      session.setMaxInactiveInterval(60); // 1분
  %>
    <script>
      alert('로그인되었습니다');
      location.href = '03_01_userMain.jsp';
    </script>
  <% } else { %>
    <script>
      alert('아이디나 패스워드를 확인해 주세요');
      location.href = '03_04_login.jsp';
    </script>
  <% } %>
</body>
</html>
