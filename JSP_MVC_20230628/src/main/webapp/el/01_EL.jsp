<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
  <!--
    EL (Expression Language)
      - 값을 간편하고 간결하게 출력할 수 있도록 해 주는 표현 언어이다
      - 코드 가독성이 좋아진다
      - 표현 방식: \${출력할_값}
      - 값을 찾을 때 작은 범위부터 큰 범위로 찾는다
        scope: 변수를 사용할 수 있는 범위
      - 출력할 때 사용하는 것이기 때문에 if문이나 for문 같은 키워드를 사용할 수 없다
        그래서 JSTL과 연동해서 사용한다
      
      - 사용 방법
        \${requestScope.키값}
        \${paraml.네임값}
        \${영역값.key} 또는 \${구별할_수_있는_변수명}
  -->
  \${2 + 5}: ${2 + 5}<br />
  \${2 - 5}: ${2 - 5}<br />
  \${2 * 5}: ${2 * 5}<br />
  \${2 / 5}: ${2 / 5}<br />
  \${2 mod 5}: ${2 mod 5}<br />
  <br />

  <!--
    혹시라도 산술연산을 하다가 null이 나오게 되면
    내부적으로 long 타입 0으로 변경해서 연산한다
  -->
  \${null + 2}: ${null + 2}<br />
  <br />
  
  <!-- 자바는 문자열로 인식하지만 EL에서는 문자열을 숫자로 바꿔서 연산한다 -->
  \${"1" + 2}: ${"1" + 2}<br />
  <br />
  
  \${10 == 10 && 9 == 9}: ${10 == 10 && 9 == 9}<br />
  \${10 == 10 || 9 == 8}: ${10 == 10 || 9 == 8}<br />
  \${!(10 == 10)}: ${!(10 == 10)}<br />
  <br />
  <br />

  <!--
    비교 연산자를 위처럼 작성할 수도 있지만
    문자열 연산에 "==", "!=" 연산이 가능하다
    
    문자열을 비교할 때 자동으로 compareTo() 메소드가 작동한다
    
    같을 때는 eq, 다를 때는 ne
  -->
  \${10 eq 10}: ${10 eq 10}<br />
  \${"이서희" eq "이서희"}: ${"이서희" eq "이서희"}<br />
  <br />

  \${10 ne 10}: ${10 ne 10}<br />
  \${"이서희" ne "이지희"}: ${"이서희" ne "이지희"}<br />
  
  \${10 < 10}: ${10 < 10}<br />
  \${10 lt 10}: ${10 lt 10}<br />
  
  \${10 > 10}: ${10 > 10}<br />
  \${10 gt 10}: ${10 gt 10}<br />
  
  \${10 <= 10}: ${10 <= 10}<br />
  \${10 le 10}: ${10 le 10}<br />
  
  \${10 >= 10}: ${10 >= 10}<br />
  \${10 ge 10}: ${10 ge 10}<br />
  <br />
  <br />
  
  <!--
    JSTL (JSP Standard Tag Library)
      연산이나 조건문, 반복문을 편하게 처리할 수 있도록 JSP 페이지 내에서
      자바 코드를 사용하지 않고 문장(로직)을 구현할 수 있도록 해 준다
      

    커스텀 태그
      1. JSTL
        JSP 페이지에서 가장 많이 사용하는 기능을 태그로 제공.
        라이브러리를 추가해서 사용해야 한다
      2. 개발자가 만든 커스텀 태그
        스프링 프레임워크에서 미리 만들어서 제공하는 커스텀 태그 등
    
    
    JSTL 라이브러리
      core: 변수, 조건문, 반복문 처리
      국제화 (fmt): 숫자, 날짜 형식, ...
      데이터베이스 (sql): SQL 처리하는 태그
      함수 (functions): 컬렉션 처리, String 처리
      XML: 흐름 제어
  -->
  
  <%
    int age = 20;
    String name1 = "홍길동";
    String name2 = "이순신";
    
    ArrayList<String> list = new ArrayList<>();
  %>
  숫자(\${0 ne age}): <c:if test="${0 ne age}">${0 ne age}</c:if><br />
  문자(\${name1 ne name2}): <c:if test="${name1 ne name2}"></c:if><br />
  null(\${null ne list}): <c:if test="${null ne list}"></c:if><br />
  <br />
  
  객체의 값이 비어있을 때: <c:if test="${empty list}"></c:if><br />
  객체의 값이 있을 때: <c:if test="${!empty list}"></c:if><br />
  <br />
  
  <!-- 삼항 연산자 -->
  \${(5 > 3) ? 5 : 3}: ${(5 > 3) ? 5 : 3}<br />
</body>
</html>
