<%@page import="enrolment.SubjectDAO"%>
<%@page import="enrolment.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
  <!--
    클릭을 했을 때
    
    로그인을 하지 않은 상태면 보여주지 않을 것
    DAO 주소값
    MySubjectDTO에 선택한 수강 과목 저장
    
    중복 수강을 막기 위해 학번, 수강번호를 DAO 안에 있는 subjectCheck() 메소드로 확인
    같은 수강 번호가 존재한다면 "중복 수강을 할 수 없습니다" 알림 띄움
    "0"이면 수강 신청 가능하고 "1"이면 중복되었다
  -->
  <%
    String hakbun = (String) session.getAttribute("hakbun");
    String subjectNumString = request.getParameter("subjectNum");
    int subjectNum = -1;
    
    try {
      subjectNum = Integer.parseInt(subjectNumString);
    } catch (NumberFormatException e) {
      
    }

    if (hakbun == null) {
      response.sendRedirect("00_login.jsp");
    }
    
    SubjectDAO sDao = SubjectDAO.getInstance();
    int result = sDao.subjectCheck(hakbun, subjectNum);
    
    if (result == 1) {
  %>
  <% } else if (result == 0) { %>
  <% } else { %>
  <% } %>
  %>
</body>
</html>
