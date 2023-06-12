<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
  <form action="insert.jsp" method="POST">
    <label for="">번호</label>
    <input type="text" name="num" />
    <br />
    <label for="">이름</label>
    <input type="text" name="name" />
    <br />
    <label for="">생년월일</label>
    <input type="text" name="birth" />
    <br />
    <label for="">주소</label>
    <input type="text" name="address" />
    <br />
    <input type="submit" />
  </form>
</body>
</html>
