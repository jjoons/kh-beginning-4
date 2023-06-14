<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--
  일정관리 프로그램만들기(달력이용해서 표현하기)
  
  input창 파일이름:  scheduleMain.jsp
    새로운 이벤트 사진에서 표현하면 됨
    입력받아서 스케쥴러 창으로 넘기기
  
  스케쥴창
    파일명: schedulePro.jsp
    scheduleMain.jsp 파일에서 받아온 내용을 달력에 표시하기
  
    1. 일단 하루를 입력 받아서 테이블안에 내용 추가하기
    2. 하루입력하는 것이 완료 되었다면 2일 이상되는 날짜에 
       행을 합쳐서 글씨 입력하기 
  ---------------------------------------------------------------------------------------
  
  위에까지 되었는데 시간이 남는다면 하세요!!! 
  테이블을 생성해서 저장해보기 
  table명 : schedule
  
  할일:  work  varchar2(100),
  월 :   month number,
  일:    day     number
  시간:  time   timestamp  or date 이용가능
  
  테이블에 input창 파일이름:  scheduleMain.jsp
  저장해서 이클립스를 종료했다가 다시 시작해도 
  웹 페이지에 고대로! 표현 될 수있도록 하기
  
  다 되면 이야기 하기!
--%>
<%
  Calendar cal = Calendar.getInstance();

  int currentYear = cal.get(Calendar.YEAR);
  int currentMonth = cal.get(Calendar.MONTH) + 1;

  int year = currentYear;
  int month = currentMonth;

  String yearParam = request.getParameter("year");
  String monthParam = request.getParameter("month");

  if (yearParam != null && monthParam != null) {
    try {
      year = Integer.parseInt(yearParam);
      month = Integer.parseInt(monthParam);
      
      if (year > 2100 || year < 1900 || month > 12 || month < 1) {
        throw new NumberFormatException("지정된 조건과 일치하지 않습니다");
      }
    } catch (NumberFormatException e) {
      response.sendRedirect("?year=" + currentYear + "&month=" + currentMonth);
    }
  } else if (yearParam == null && monthParam == null);
  else {
    response.sendRedirect("?year=" + currentYear + "&month=" + currentMonth);
  }

  cal.set(year, month - 1, 1);

  int maxDayOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
  int firstDayWeek = cal.get(Calendar.DAY_OF_WEEK);
  int firstWeekDays = 8 - firstDayWeek;

%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>Calendar</title>
  <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
    crossorigin="anonymous"
  />
</head>
<body>
  <div id="wrap">
    <h2>Calendar</h2>
    <div><%= year %>년 <%= month %>월</div>
    <div>
      <table class="table">
        <colgroup></colgroup>
        <thead>
          <tr>
            <th>일</th>
            <th>월</th>
            <th>화</th>
            <th>수</th>
            <th>목</th>
            <th>금</th>
            <th>토</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <% for (int i = 1; i <= 7 - firstWeekDays; i++) { %>
              <td><%= i %></td>
            <% } %>
            <% for (int i = 1; i <= maxDayOfMonth; i++) { %>
              <% if (cal.get(Calendar.DAY_OF_WEEK) == 1) { %>
                </tr><tr>
              <% } %>
                <td><%= i %></td>
              <%
                cal.add(Calendar.DATE, 1);
              %>
            <% } %>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
  <script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
    crossorigin="anonymous"
  ></script>
</body>
</html>
