<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
  <!--
    value="출력값"
    value 값이 null이면 기본값이 출력되고 기본값이 없으면 빈 문자열을 출력한다
  -->
  <c:out value="hello world" /><br />
  <c:out value="${null}">JSTL</c:out><br />
  <c:out value="hello">world</c:out><br />
  <c:out value="${null}" /><br />
  
  <!--
    변수를 다룰 때 set
    JSP의 로컬 변수가 아니라 서블릿 보관소에 4가지 영역이 있는데 그 곳에 내가 범위를 설정해서 저장
    
    <%--c:set var="" value="" scope="기본값"></c:set--%>
    scope의 기본값은 page
  -->
  <c:set var="username1" value="이서희" />
  <c:set var="username2">박지성</c:set>
  
  username1: ${username1}<br />
  username2: ${username2}<br />
  
  pageScope.username1: ${pageScope.username1}<br />
  pageScope.username2: ${pageScope.username2}<br />
  
  <!-- jspContext에 저장 -->
  <c:set var="data2" value="${10}" />
  data2: <c:out value="${data2}" /><br />
  
  <!-- 변수 삭제 후 출력 -->
  <c:remove var="data2" />
  data2: <c:out value="${data2}">삭제됨</c:out><br />
  
  <h3>JSTL Core 태그 - if</h3>
  <c:set var="country" value="${'korea'}" />
  <c:if test="${country ne null}">
    국가명: <c:out value="${country}" /><br />
  </c:if>
  
  <c:out value="${country}" />의 겨울은 춥습니다.<br />
  
  <!-- test 안에 조건식을 작성한다 -->
  <c:if test="${10 > 20}" var="result1">
    10은 20보다 크다 <br />
  </c:if>
  result1: ${result1}<br />
  
  <c:if test="${20 > 10}" var="result2">
    20은 10보다 크다 <br />
  </c:if>
  result2: ${result2}<br />
</body>
</html>
