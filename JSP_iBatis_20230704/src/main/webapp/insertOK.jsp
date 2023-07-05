<%@page import="com.kh.service.InsertService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Insert title here</title>
</head>
<body>
  <jsp:useBean id="vo" class="com.kh.vo.GuestbookVO">
    <jsp:setProperty property="*" name="vo" />
  </jsp:useBean>
  <%
    InsertService.getInstance().insert(vo);
  
    // 테이블 글 1건을 저장했으면 테이블에 저장된 글을
    // 브라우저에 출력하기 위해서 1페이지 분량의 글 목록을 얻어오는
    // 페이지 list.jsp로 넘겨준다
    response.sendRedirect("list.jsp");
  %>
</body>
</html>

<!--
  VO 클래스: 글 1건을 기억하는 클래스
  List 클래스: 한 페이지 분량의 글 목록과 페이징에 사용할 8개의 변수를 저장하는 클래스
  Service 클래스: SQL 명령을 실행 전에 전처리 작업을 수행하는 클래스
  DAO(Data Access Object): 데이터베이스에 접속해서 SQL 명령을 실행하는 클래스
-->

<!--
  insert.jsp 에서 넘어오는 데이터를 받는다
  이전 페이지에서 넘어오는 데이터가 VO 클래스의 필드로 존재하면
  useBean 액션 태그를 이용해서 받는 내용 작성
  전처리 작업을 하기 위해서 service 클래스로 넘겨서 DAO 클래스에서
  SQL 명령을 실행하기 전까지 ...
  
    InsertService.getInstance().insert(vo);
  list.jsp로 페이지 리다이렉트


  iBatis
    데이터베이스에서 자바 빈즈, VO 객체에 데이터를 쉽게 저장할 수 있도록 도와주는 라이브러리
    SQL 매퍼 + DAO 프레임워크
    
    4가지의 기본 파일로 구성되어있다
      - SqlMapConfig.xml: DB 연동을 위한 환경 설정 파일
      - MyAppSqlConfig.java: XML문과 실제 환경 설정 파일을 연결해 주는 역할
      - guestbook.xml: SQL문을 Mapping해 주는 파일
      - db.properties: 실제 데이터베이스의 접속 정보 (url, username, password)
-->
