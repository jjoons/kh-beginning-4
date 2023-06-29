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
    국어 성적 = <c:out value="${korScore}"></c:out>
  </h3>
  <h3>
    수학 성적 = <c:out value="${mathScore}"></c:out>
  </h3>
  <h3>
    영어 성적 = <c:out value="${engScore}"></c:out>
  </h3>
  <%--
  <h3>
    평균 점수: <c:out value="${avgScore}"></c:out>
  </h3>
  --%>
  <br />
  <h3>
    <c:choose>
      <c:when test="${result}">합격</c:when>
      <c:when test="${not result}">불합격</c:when>
    </c:choose>
    입니다.
  </h3>
  <h3><c:out value="${resultMsg}" /></h3>
</body>
</html>
