<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  
%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
  <div id="wrap">
    <form action="subject.jsp" method="POST">
      <div>
        <h2>수강신청</h2>
      </div>
      <div>
        <label for="form_student_id">학번</label>
        <input type="number" name="student_id" id="form_student_id" />
      </div>
      <div>
        <label for="form_password">비밀번호</label>
        <input type="password" name="password" id="form_password" />
      </div>
      <div>
        <button type="submit">로그인</button>
      </div>
    </form>
  </div>
</body>
</html>
