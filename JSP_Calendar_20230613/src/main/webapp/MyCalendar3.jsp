<%@page import="com.kh.MyCalendarTen"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>만년달력</title>
  <link rel="stylesheet" href="mycalendar_style.css" media="all" />
</head>
<body>
  <%
    // 캘린더 클래스 객체 생성한 다음 현재 년과 월을 가져오기
    Calendar calendar = Calendar.getInstance();
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH) + 1;

    // 이전 달, 다음 달 하이퍼링크 또는 버튼이 클릭되면
    // GET 방식으로 넘어오는 달력을 출력할 년, 월을 받는다
    try {
      year = Integer.parseInt(request.getParameter("year"));
      month = Integer.parseInt(request.getParameter("month"));

      // 마이너스가 나오거나 12를 초과하면 안 된다
      // 1월달에서 이전을 누르면 12월로 이동
      // 12월달에서 다음을 누르면 1월로 이동
      if (month > 12) {
        year++;
        month = 1;
      } else if (month < 1) {
        year--;
        month = 12;
      }
    } catch (NumberFormatException e) {}
  %>
  <table width="700" border="1" align="center" cellpadding="5" cellspacing="0">
    <tr>
      <!--
        a 태그 href 속성에 지정된 곳으로 이동한다
        href 속성 # 뒤에 id(해시)를 지정하면 현재 문서에서 id가 지정된 요소로 이동(책갈피)하고
        url(주소)이 지정되면 url 페이지로 이동한다

        "?" 뒤에 이동하는 페이지로 전달할 데이터를 넘겨주는데
        넘겨줄 데이터 2건 이상 데이터와 구분할 때 "&"를 넣어서 구별한다

        "?" 뒤에는 절대로 띄어쓰기를 하면 안 된다
      -->
      <th>
        <input
          type="button"
          class="button button1"
          value="이전달"
          onclick="location.href = '?year=<%= year %>&month=<%= month - 1 %>'"
        />
      </th>
      <th id="title" colspan="5"><%= year %>년 <%= month %>월</th>
      <th>
        <input
          type="button"
          class="button button1"
          value="다음달"
          onclick="location.href = '?year=<%= year %>&month=<%= month + 1 %>'"
        />
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
    <!-- 달력에 날짜를 출력한다 -->
    <tr>
      <!-- 달력을 출력할 달 1일의 요일을 계산한다 -->
      <%
        int week = MyCalendarTen.weekDay(year, month, 1);

        // 빈 칸에 출력할 전달 날짜의 시작일을 계산한다
        int start = 0;

        if (month == 1) {
          // 1월
          start = MyCalendarTen.lastDay(year - 1, 12) - week;
        } else {
          // 2월 ~ 12월
          start = MyCalendarTen.lastDay(year, month - 1) - week;
        }
        
//      다음달 1일의 요일을 계산한다.
        if (month == 12) {
          week = MyCalendarTen.weekDay(year + 1, 1, 1); // 12월
        } else {
          week = MyCalendarTen.weekDay(year, month + 1, 1); // 1 ~ 11월
        }

//        다음달 1일이 일요일이면 다음달 날짜를 출력할 필요없다.
        if (week != 0) {
          // 날짜를 다 출력하고 남은 빈 칸에 다음달 날짜를 다음달 1일의 요일부터 토요일까지 반복하며 
          // 출력한다.
          start = 0;
          for (int i=week; i<=6; i++) {
            if (i == 6) {
              out.println("<td id='aftersat'>" + (month == 12 ? 1 : month + 1) + "/" + ++start + "</td>");
            } else {
              out.println("<td class='after'>" + (month == 12 ? 1 : month + 1) + "/" + ++start + "</td>");
            }
          }
        }

        // 1일이 출력될 위치(요일)를 맞추기 위해 달력을 출력할 1일의 요일만큼 반복하며 전달 날짜를 출력한다
        // 빈 칸에 데이터를 출력하는 부분 (5/28)
        for (int i = 0; i < MyCalendarTen.weekDay(year, month, 1); i++) {
          if (i == 0) {
            out.println("<td id=\"beforeSun\">" + (month == 1 ? 12 : month - 1) + "/" + ++start + "</td>");
          } else {
            out.println("<td id=\"before\">" + (month == 1 ? 12 : month - 1) + "/" + ++start + "</td>");
          }
        }
        
        for (int i = 1; i <= MyCalendarTen.lastDay(year, month); i++) {
          // 공휴일(삼일절, 어린이날, 광복절, ...) 또는 대체 공휴일
          // 공휴일이 토요일하고 일요일과 겹치면 대체 공휴일로 지정됨
          
          boolean flag0301 = false;
          int subHoliday0301 = 0;
          if (MyCalendarTen.weekDay(year, 3, 1) == 6) {
            flag0301 = true;
            subHoliday0301 = 3;
          } else if (MyCalendarTen.weekDay(year, 3, 1) == 0) {
            flag0301 = true;
            subHoliday0301 = 2;
          }
          
          boolean flag0505 = false;
          int subHoliday0505 = 0;
          if (MyCalendarTen.weekDay(year, 5, 5) == 6) {
            flag0505 = true;
            subHoliday0505 = 7;
          } else if (MyCalendarTen.weekDay(year, 5, 5) == 0) {
            flag0505 = true;
            subHoliday0505 = 6;
          }
          
          boolean flag0815 = false;
          int subHoliday0815 = 0;
          if (MyCalendarTen.weekDay(year, 8, 15) == 6) {
            flag0815 = true;
            subHoliday0815 = 17;
          } else if (MyCalendarTen.weekDay(year, 8, 15) == 0) {
            flag0815 = true;
            subHoliday0815 = 16;
          }
          
          boolean flag1003 = false;
          int subHoliday1003 = 0;
          if (MyCalendarTen.weekDay(year, 10, 3) == 6) {
            flag1003 = true;
            subHoliday1003 = 5;
          } else if (MyCalendarTen.weekDay(year, 10, 3) == 0) {
            flag1003 = true;
            subHoliday1003 = 4;
          }
          
          boolean flag1009 = false;
          int subHoliday1009 = 0;
          if (MyCalendarTen.weekDay(year, 10, 9) == 6) {
            flag1009 = true;
            subHoliday1009 = 11;
          } else if (MyCalendarTen.weekDay(year, 10, 9) == 0) {
            flag1009 = true;
            subHoliday1009 = 10;
          }
          
          
          if (month == 1 && i == 1) {
            out.println("<td class='holiday'>" + i + "<br><span>신정</span></td>");
          } else if (month == 3 && i == 1) {
            out.println("<td class='holiday'>" + i + "<br><span>삼일절</span></td>");
          } else if (month == 5 && i == 1) {
            out.println("<td class='holiday'>" + i + "<br><span>근로자의날</span></td>");
          } else if (month == 5 && i == 5) {
            out.println("<td class='holiday'>" + i + "<br><span>어린이날</span></td>");
          } else if (month == 6 && i == 6) {
            out.println("<td class='holiday'>" + i + "<br><span>현충일</span></td>");
          } else if (month == 8 && i == 15) {
            out.println("<td class='holiday'>" + i + "<br><span>광복절</span></td>");
          } else if (month == 10 && i == 3) {
            out.println("<td class='holiday'>" + i + "<br><span>개천절</span></td>");
          } else if (month == 10 && i == 9) {
            out.println("<td class='holiday'>" + i + "<br><span>한글날</span></td>");
          } else if (month == 12 && i == 25) {
            out.println("<td class='holiday'>" + i + "<br><span>크리스마스</span></td>");
          }


          // 대체 공휴일
          else if (flag0301 && month == 3 && i == subHoliday0301) {
            out.println("<td class='holiday'>" + i + "<br><span>대체공휴일</span></td>");
          } else if (flag0505 && month == 5 && i == subHoliday0505) {
            out.println("<td class='holiday'>" + i + "<br><span>대체공휴일</span></td>");
          } else if (flag0815 && month == 8 && i == subHoliday0815) {
            out.println("<td class='holiday'>" + i + "<br><span>대체공휴일</span></td>");
          } else if (flag1003 && month == 10 && i == subHoliday1003) {
            out.println("<td class='holiday'>" + i + "<br><span>대체공휴일</span></td>");
          } else if (flag1009 && month == 10 && i == subHoliday1009) {
            out.println("<td class='holiday'>" + i + "<br><span>대체공휴일</span></td>");
          }
          
          
          else {
            // 토요일이면 파란색, 일요일이면 빨간색
            switch (MyCalendarTen.weekDay(year, month, i)) {
              case 0:
                out.println("<td class=\"sun\">" + i + "</td>");
                break;
              case 6:
                out.println("<td class=\"sat\">" + i + "</td>");
                break;
              default:
                out.println("<td>" + i + "</td>");
                break;
            }
          }

          // 출력한 날짜가 토요일이고 그 달의 마지막 날짜가 아니면 줄을 바꾼다
          if (MyCalendarTen.weekDay(year, month, i) == 6 && MyCalendarTen.lastDay(year, month) != i) {
            out.println("</tr></tr>");
          }
        }
      %>
      <td></td>
    </tr>

    <!--  년, 월을 선택하고 보기 버튼을 클릭하면 선택된 달의 달력으로 한 번에 넘어가게 한다 -->
    <tr>
      <td id="choice" colspan="7">
        <form action="?" method="POST">
          <fieldset>
            <legend>년</legend>
            <select name="year" id="" class="select">
              <%
                for (int i = 1900; i <= 2100; i++) {
                  if (i == calendar.get(Calendar.YEAR)) {
                    out.println("<option selected=\"selected\">" + i + "</option>");
                  } else {
                    out.println("<option>" + i + "</option>");
                  }
                }
              %>
            </select>
          </fieldset>


          <fieldset>
            <legend>월</legend>
            <select class="select" name="month"> <!-- 1 ~ 12 -->
            
            <%
              for (int i=1; i<=12; i++) {
                if (i == calendar.get(Calendar.MONTH) + 1) {
                  out.println("<option selected='selected'>" + i + "</option>");
                } else {
                  out.println("<option>" + i + "</option>");
                }
              }
             %>
            
            </select>
          </fieldset>

          <input class="select" type="submit" value="보기">
        </form>
      </td>
    </tr>
  </table>
</body>
</html>
