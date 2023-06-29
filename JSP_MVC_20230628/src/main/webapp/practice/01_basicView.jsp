<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
  <div>
    국어 점수: <c:out value="${korScore}"></c:out>
  </div>
  <div>
    수학 점수: <c:out value="${mathScore}"></c:out>
  </div>
  <div>
    영어 점수: <c:out value="${engScore}"></c:out>
  </div>
  <div>
    평균 점수: <c:out value="${avgScore}"></c:out>
  </div>
  <br />
  <p style="font-weight: 700">
    <c:out value="${resultMsg}">정보 없음</c:out>
  </p>
</body>
</html>
