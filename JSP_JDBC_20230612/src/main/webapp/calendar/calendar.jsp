<%@page import="com.kh.calendar.MyCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link rel="stylesheet" href="style.css" />
</head>
<body>
<%
  // 달력 메소드 테스트
  Date date = new Date();
  // out.println(date);
  
  Calendar calendar = Calendar.getInstance();
  int year = calendar.get(Calendar.YEAR);
  
  // 월을 나타내지만 이 때 1월을 상수 0으로 표현
  int month = calendar.get(Calendar.MONTH) + 1;
  
  int day = calendar.get(Calendar.DAY_OF_WEEK);
  
  // out.println(year + "년 " + (month + 1) + "월");
%>
<%--  <%= year %>년 <%= month + 1 %>월--%>
<%--= MyCalendar.isLeapYear(2022) --%>
  <table width="700" border="1" align="center" cellpadding="5" cellspacing="0">
  
    <tr>
      <th id="title" colspan="7">
        <%= year %>년 <%= month %>월
      </th>
    </tr>
    
    <tr>
      <th id="sunday">일</th>
      <th>월</th>
      <th>화</th>
      <th>수</th>
      <th>목</th>
      <th>금</th>
      <th id="saturday">토</th>
    </tr>
  
    <!-- 달력에 날짜를 출력한다. -->
    
    <tr>
      <%
        // 달력을 출력할 달 1일의 요일을 계산해 둔다
        int week = MyCalendar.weekDay(year, month, day);

        // 1일이 출력될 위치(요일)를 맞추기 위해 달력을 출력할 달 1일의 요일만큼 반복하여 빈 칸을 출력한다
        /*for (int i = 0; i < week; i++) {
          out.println("<td></td>");
        }*/
        
        // 빈 칸에 출력할 전달 날짜의 시작일을 계산한다
        int start = 0;

        if (month == 1) {
          // 1월
          start = MyCalendar.lastDay(year - 1, 12) - week;
        } else {
          // 2월 ~ 12월
          start = MyCalendar.lastDay(year, month - 1) - week;
        }

        // 1일이 출력될 위치(요일)를 맞추기 위해 달력을 출력할 달 1일의 요일만큼 반복하여 전달 날짜를 출력한다
        for (int i = 0; i < MyCalendar.weekDay(year, month, 1); i++) {
          if (i == 0) {
            out.println("<td class=\"beforeSun\">" + (month == 1 ? 12 : month - 1) + "/" + (++start) + "</td>");
          } else {
            out.println("<td class=\"before\">" + (month == 1 ? 12 : month - 1) + "/" + (++start) + "</td>");
          }
        }
        
        // 1일부터 달력을 출력할 달의 마지막 날짜까지 반복하며 날짜를 출력한다
        for (int i = 1; i <= MyCalendar.lastDay(year, month); i++) {
          // td 태그 요일에 따른 클래스 속성을 지정한다
          switch (MyCalendar.weekDay(year, month, i)) {
            // 일요일
            case 0:
              out.println("<td class=\"sun\">" + i + "</td>");
              break;

            // 토요일
            case 6:
              out.println("<td class=\"sat\">" + i + "</td>");
              break;

            default:
              out.println("<td>" + i + "</td>");
              break;
          }

          // 출력한 날짜가 토요일이고 그 달의 마지막 날짜가 아니면 줄을 바꾼다
          if (MyCalendar.weekDay(year, month, i) == 6 && i != MyCalendar.lastDay(year, month)) {
            out.println("</tr><tr>");
          }
        }

        // 다음 달 1일의 요일을 계산한다
        if (month == 12) {
          // 12월
          week = MyCalendar.weekDay(year + 1, 1, 1);
        } else {
          // 1월 ~ 11월
          week = MyCalendar.weekDay(year, month + 1, 1);
        }

        // 다음 달 1일이 일요일이면 다음 달 날짜를 출력할 필요가 없다
        if (week != 0) {
          // 날짜를 다 출력하고 남은 빈 칸에 다음 달 날짜를 1일의 요일부터 토요일까지 반복하여 출력한다
          start = 0;

          for (int i = week; i < 6; i++) {
            if (i == 6) {
              out.println("<td class=\"afterSat\">" + (month == 12 ? 1 : month + 1) + "/" + (++start) + "</td>");
            } else {
              out.println("<td class=\"after\">" + (month == 12 ? 1 : month + 1) + "/" + (++start) + "</td>");
            }
          }
        }
      %>
    </tr>
  </table>
</body>
</html>
