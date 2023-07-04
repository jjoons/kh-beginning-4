<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Insert title here</title>
</head>
<body>
  
</body>
</html>

<!--
  insert.jsp 에서 넘어오는 데이터를 받는다
  이전 페이지에서 넘어오는 데이터가 VO 클래스의 필드로 존재하면
  useBean 액션 태그를 이용해서 받는 내용 작성
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
