<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
  반복 작업을 할 때 사용한다
  <br />
  var="변수명" items="목록데이터"
  <br />
  컬렉션 (Map, Set, Map, List), 콤마(,) 구분자로 나열된 문자열
  <br />
  var는 반복문을 돌면서 items에서 꺼낸 항목 값을 가리키는 참조 변수이다
  <br />

  <h3>문제 1: 1 ~ 10까지 출력</h3>
  <c:forEach var="i" begin="1" end="10">
    ${i} &nbsp;
  </c:forEach>
  <br />
  
  <h3>문제 2: 1 ~ 10까지 짝수 출력</h3>
  <c:forEach var="i" begin="1" end="10">
    <c:if test="${i % 2 == 0}">
      ${i} &nbsp;
    </c:if>
  </c:forEach>
  <br />
  
  <h3>문제 2: 1 ~ 10까지 합 출력</h3>
  <c:forEach var="i" begin="1" end="10">
    <c:set var="sum" value="${sum = sum + i}" />
  </c:forEach>
  합계: ${sum}
  <br />
  
  <h3>문제 2: 1 ~ 100의 홀수의 개수 출력</h3>
  <c:forEach var="i" begin="1" end="100">
    <c:if test="${i % 2 == 1}">
      <c:set var="totalCount" value="${totalCount = totalCount + 1}"></c:set>
    </c:if>
  </c:forEach>
  합계: ${sum}
  <br />
  
  <!--
    구구단 출력 2단
      2~9단 출력하는 JSTL 문법 이용해서 데이터 출력하기
  -->
  <h3>구구단</h3>
  <c:forEach var="i" begin="2" end="9">
    <c:forEach var="j" begin="1" end="9">
      ${i} * ${j} = <c:out value="${i * j}" /><br />
    </c:forEach>
  </c:forEach>
</body>
</html>
