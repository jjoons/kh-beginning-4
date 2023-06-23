<%@page import="java.util.ArrayList"%>
<%@page import="enrolment.SubjectDTO"%>
<%@page import="enrolment.SubjectDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--
  이번 문제들은 세션에 학번이 없으면 아예 실행하지 않고 바로 00_login.jsp로 넘기고
  아니면 화면 보여주기
  
  // 학년을 선택했을 때 여러 개가 저장될 수도 있고 하나만 있거나, 아예 없을 수도 있다
  // 저장하는 자료형은?
  
  // 학년과 전공을 꺼내서 getGradeMajorSubject(major, grade) 메소드로 받아오기
-->
<%
  String hakbun = (String) session.getAttribute("hakbun");

  // 학번이 들어오면 공지사항을 띄우고 아니면 로그인 창으로 이동한다
  if (hakbun == null) {
    response.sendRedirect("00_login.jsp");
  } else {
    SubjectDAO sdo = SubjectDAO.getInstance();

    String major = request.getParameter("major");
    int grade = -1;

    try {
      grade = Integer.parseInt(request.getParameter("grade")); 
    } catch (NumberFormatException e) {
      e.printStackTrace();
    }

    ArrayList<SubjectDTO> s = sdo.getSubjects2(major, grade);
%>
  <div align="right" style="border:1px solid">
    <form action="01_Main.jsp?center=08_subjectSelect.jsp" method="post">
      전공 : <select name="major">
          <option value="1" <%if(major.equals("1")){ %> selected<%}%>>컴퓨터공학</option>
          <option value="2" <%if(major.equals("2")){ %> selected<%}%>>전자공학</option>
          <option value="3" <%if(major.equals("3")){ %> selected<%}%>>응용수학</option>
          <option value="4" <%if(major.equals("4")){ %> selected<%}%>>교양</option>
      </select>&nbsp;
      학년 : <select name="grade">
          <option value="1" <%if(grade == 1){ %> selected<%}%>>1학년</option>
          <option value="2" <%if(grade == 2){ %> selected<%}%>>2학년</option>
          <option value="3" <%if(grade == 3){ %> selected<%}%>>3학년</option>
          <option value="4" <%if(grade == 4){ %> selected<%}%>>4학년</option>
          <option value="0" <%if(grade == 0){ %> selected<%}%>>0학년</option>
      </select>&nbsp;
      <input type="submit" value="조회">
    </form>
  </div>
  <table border="1">
    <tr>
      <td align="center" width="200">강의명</td>
      <td align="center" width="120">교수명</td>
      <td align="center" width="50">학점</td>
      <td align="center" width="150">전공</td>
      <td align="center" width="100">학년</td>
      <td align="center" width="150">강의계획서</td>
    </tr>
    <%for(int i=0; i<s.size(); i++){
      SubjectDTO sto = s.get(i);%>
    <tr>
      <td align="center"><%=sto.getSubjectName() %></td>
      <td align="center"><%=sto.getProfessorName() %></td>
      <td align="center"><%=sto.getHakjom() %></td>
      <td align="center"><%if(sto.getMajor().equals("1")){%>
          컴퓨터공학
        <% }else if(sto.getMajor().equals("2")){%>
          전자공학
        <%}else if(sto.getMajor().equals("3")){%>
          응용수학
        <%}else if(sto.getMajor().equals("4")){%>
          교양
        <%} %>
      </td>
      <td align="center"><%=sto.getGrade() %>학년</td>
      <td align="center">
        <input type="button" value="강의계획서" onclick="window.open('08_subjectSelectInfo.jsp?subjectNum=<%=sto.getSubjectNum()%>')">
      </td>
    </tr>
    <% }%>
  </table>
<% } %>
