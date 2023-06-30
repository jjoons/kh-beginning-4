<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Insert title here</title>
</head>
<body>
  <script>
    <c:if test="${ result }">
      alert('탈퇴되었습니다')
    </c:if>
    <c:if test="${ not result }">
      alert('비정상적인 접근입니다.')
    </c:if>
    location.href = 'index.do'
  </script>
</body>
</html>
