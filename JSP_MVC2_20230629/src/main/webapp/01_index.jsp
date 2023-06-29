<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Insert title here</title>
</head>
<body>
  <!--
    JSTL 이용해서 JSP 페이지에서 로그인이 안 되어 있으면 기본 페이지를 보여주고
    로그인이 되었다면 회원 메인페이지로 이동하는 내용 적기
    단 출력을 할 때 if문으로 비교해서 로그인이 안 되면 ...
    
    if문을 이용해서 보여지는 부분만 선택해서 보여준다
  -->
  <div align="center">
    <c:if test="${null ne id}">
      ${ id }님 환영합니다. <br />
      <br />
      
      <!--
        가상 주소를 사용하는 이유
        
        다른 서블릿과 URL 충돌을 막기 위해서 사용
        정부 표준 기본 세팅에서 URL 확장자가 .do 이며 생략해도 된다
      -->
      <a href="logout.do">로그아웃</a>
      <br>
      <br>
      <a href="update.do">회원정보수정</a>
      <br>
      <br>
      <a href="delete.do">탈퇴</a>
      <br>
      <br>
    </c:if>
    <c:if test="${null eq id}">
      <a href="join.do">회원가입</a>
      <br>
      <br>
      <a href="login.do">로그인</a>
      <br>
      <br>
    </c:if>
  </div>
    <hr />
    <br />
    <br />
    <br />
  <div align="center">
    <a href="apply.do">
      <img alt="입사지원하기" src="img/Image_2023-06-29 16_03_38.png" />
    </a>
  </div>
</body>
</html>
