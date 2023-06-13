<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  // request.setCharacterEncoding("UTF-8");

  String method = request.getMethod();

  String yearString = request.getParameter("year");
  String monthString = request.getParameter("month");

  int year = 0;
  int month = 0;

  Calendar cal = Calendar.getInstance();
  cal.set(Calendar.DATE, 1);

  try {
    year = yearString == null ? cal.get(Calendar.YEAR) : Integer.parseInt(yearString); 
    month = monthString == null ? cal.get(Calendar.MONTH) : Integer.parseInt(monthString);
  } catch (NumberFormatException e) {
    System.out.println("포맷 오류");
    System.out.println(e);
  }
%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>Calendar</title>
  <%--@ include file="../common-head.jsp" --%>
  <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
    crossorigin="anonymous"
  />
  <link rel="stylesheet" href="common.css" />
</head>
<body>
  <div id="wrap">
    <div>
      <button class="btn btn-outline-primary">이전달</button>
      <div></div>
      <button class="btn btn-outline-primary">다음달</button>
    </div>
    <table class="table">
      <thead>
        <tr>
          <th class="text-center fs-5 sunday">일</th>
          <th class="text-center fs-5">월</th>
          <th class="text-center fs-5">화</th>
          <th class="text-center fs-5">수</th>
          <th class="text-center fs-5">목</th>
          <th class="text-center fs-5">금</th>
          <th class="text-center fs-5 saturday">토</th>
        </tr>
      </thead>
      <tbody>
        <%
          cal.getActualMaximum(Calendar.DATE);
          int firstDayWeek = cal.getFirstDayOfWeek();
          int lastDayWeek = cal.get(Calendar.DAY_OF_WEEK);
          
          out.println(lastDayWeek);
        %>
      </tbody>
    </table>
  </div>
  <%@ include file="../common-body-end.jsp" %>
</body>
</html>
