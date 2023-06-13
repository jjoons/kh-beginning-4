<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyCalendar2 한달 달력 출력</title>
</head>
<body>
  <%
    Calendar start = Calendar.getInstance();
    Calendar end = Calendar.getInstance();
    
    // 내가 원하는 날짜로 변경하기 위해서 set() 메소드 사용
    int year = 2019;
    int month = 6;

    // 2022년 6월 1일 
    start.set(year, month - 1, 1);
    
    // 7월 1일
    end.set(year, month, 1);

    // add() 함수를 이용해서 30, 31일 해당 월의 마지막 일을 구한다
    end.add(Calendar.DATE, -1);

    // roll(): 다른 필드에 영향을 주지 않는다
    
    // 지정된 요일 불러오기
    //   일요일부터 토요일까지
    int dayWeek = start.get(Calendar.DAY_OF_WEEK);

    System.out.println();
    System.out.println("===== " + month + "월 =====");
    System.out.println(" 일 월 화 수 목 금 토");
    
    // 1일이 일요일이면 앞에 공백없이 출력할 수 있지만
    // 월, 화, ..., 토요일같은 경우에는 앞 공간에 공백이 생길 수 있다
    for (int i = 1; i < dayWeek; i++) {
      System.out.print("   ");
    }
    
    // 실제 1일부터 30일 혹은 31일까지 출력
    for (int i = 1, n = dayWeek; i <= end.get(Calendar.DATE); i++, n++) {
      // n: 요일을 상수값으로 가지고 와서 목요일, 금요일 출력
      // i: 날짜

      // 이스케이프 시퀀스 문자(특수 문자): 문자열 안에서 포맷을 지정해서 정렬할 수 있다
      //   %d: 정수, %f: 실수, %c: 한문자 ' '. 한글 포함 X, %s: 문자 여러 개(문자열)
      System.out.printf("%3d", i);
      
      if (n % 7 == 0) {
        System.out.println();
      }
    }
  %>
</body>
</html>
