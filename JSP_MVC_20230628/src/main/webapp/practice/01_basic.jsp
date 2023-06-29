<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
  <%
    // 시작하자마자 바로 자바 코드가 실행될 수 있도록 서블릿으로 이동한다
    // response.sendRedirect("../Test01");
  %>
  <form action="Test01" method="POST">
    <label>
      국어 점수: 
      <input type="number" name="korScore" />
    </label>
    <label>
      수학 점수: 
      <input type="number" name="mathScore" />
    </label>
    <label>
      영어 점수: 
      <input type="number" name="engScore" />
    </label>
    <button type="submit">제출</button>
  </form>
</body>
</html>
