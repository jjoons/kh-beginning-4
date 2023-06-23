<%@page import="enrolment.SubjectDTO"%>
<%@page import="enrolment.SubjectDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  String hakbun = (String) session.getAttribute("hakbun");

  // 학번이 들어오면 공지사항을 띄우고 아니면 로그인 창으로 이동한다
  if (hakbun == null) {
    response.sendRedirect("00_login.jsp");
  } else {
%>
  <!DOCTYPE html>
  <html>
  <head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
  </head>
  <body>
  <%
    // subjectNum 변수에서 값을 추출한다
    int subjectNum = -1;
    try {
      subjectNum = Integer.parseInt(request.getParameter("subjectNum"));
    } catch (NumberFormatException e) {
      e.printStackTrace();
    }

    // DAO에 접근해 메소드를 호출한 다음, subjectDTO 객체를 반환받는다
    SubjectDAO sdo = SubjectDAO.getInstance();
    SubjectDTO sto = sdo.getOneSubject(subjectNum);
  %>
    <h2>강의계획서</h2>
    <br />
    <table border="1">
      <tr height="30">
        <td colspan="2" width="30"><b>강의명</b></td>
        <td colspan="2" width="200"><%=sto.getSubjectName() %></td>
      </tr>
      <tr height="30">
        <td colspan="2" width="50"><b>교수명</b></td>
        <td colspan="2" width="200"><%=sto.getProfessorName() %></td>
      </tr>
      <tr height="30">
        <td width="20"><b>학점</b></td>
        <td width="30"><%=sto.getHakjom() %></td>
        <td width="50"><b>강의실</b></td>
        <td width="150"><%=sto.getRoom() %></td>
      </tr>
      <tr height="30">
        <td colspan="1" width="50"><b>전공</b></td>
        <td colspan="3" width="200"><%if(sto.getMajor().equals("1")){%>
            컴퓨터공학
          <% }else if(sto.getMajor().equals("2")){%>
            전자공학
          <%}else if(sto.getMajor().equals("3")){%>
            응용수학
          <%}else if(sto.getMajor().equals("4")){%>
            교양
          <%} %></td>
      </tr>
      <tr height="30">
        <td width="50"><b>목적</b></td>
        <td colspan="3" width="200"><%=sto.getSubjectPurpos() %></td>
      </tr>
      <tr height="30">
        <td width="50"><b>목표</b></td>
        <td colspan="3" width="200"><%=sto.getSubjectGoal() %></td>
      </tr>
      <tr height="30">
        <td width="50"><b>학년</b></td>
        <td width="200"><%=sto.getGrade() %></td>
        <td width="50"><b>평가방법</b></td>
        <td width="200"><%=sto.getSubjectTest() %></td>
      </tr>
    </table>
  </body>
  </html>
<% } %>
