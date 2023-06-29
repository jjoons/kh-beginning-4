<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
  <h3>
    <c:choose>
      <c:when test="${result}">
        로그인 성공
      </c:when>
      <c:when test="${not result}">
        로그인 실패
      </c:when>
    </c:choose>
  </h3>
</body>
</html>
