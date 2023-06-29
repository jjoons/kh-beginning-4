<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
  <c:set var='userInput' value='${att_user_value}' />
  <c:choose>
    <c:when test="${userInput == '가위'}">졌다</c:when>
    <c:when test="${userInput == '바위'}">비겼다</c:when>
    <c:when test="${userInput == '보'}">이겼다</c:when>
    <c:otherwise>다시 내라</c:otherwise>
  </c:choose>
</body>
</html>
