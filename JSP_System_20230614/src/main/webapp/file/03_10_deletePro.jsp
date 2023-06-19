<%@page import="_05_User.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>탈퇴 처리</title>
</head>
<body>
  <!--
    1. 한글 깨짐
    2. id, pw 가져오기
    3. 체크를 이용해서 userList에 2번에서 가져온 변수값을 이용해서 정보가 있는지 확인
    4. 정보가 있으면 deleteUserId(id) 실행
      세션도 같이 삭제
      alert()로 탈퇴되었다고 알림 띄운 다음 userMain 페이지로 이동하기
    5. 아이디 또는 비밀번호 확인 메시지를 출력하고 바로 이전 페이지로 이동하는 메소드
      history.go(-1)

    deleteUserId(id); 실행 시 리스트와 파일에서도 삭제
      다시 저장하는 saveData() 메소드를 호출해야 한다
  -->
  <%
    request.setCharacterEncoding("utf-8");

    String id = request.getParameter("id");
    String pw = request.getParameter("pw");
    
    UserDAO dao = UserDAO.getInstance();
    
    if (dao.checkUserIdPw(id, pw)) {
      session.removeAttribute("log");
      session.invalidate();
  %>
    <script>
      alert('탈퇴되었습니다');
      location.href = '03_01_userMain.jsp';
    </script>
  <% } else { %>
    <script>
      alert('아이디나 비밀번호를 확인해 주세요');
      history.go(-1);
    </script>
  <% } %>
</body>
</html>
