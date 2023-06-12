package com.kh.calendar;

public class MyCalendar {
  // 달력 작업에 필요한 메소드를 모아놓은 클래스

  // 윤년인지 평년인지 판단. true / false로 판단
  //   윤년 true, 평년 false
  //   논리값을 기억하는 변수나 논리값을 반환하는 메소드들은 "is"로 시작하는 것이 관행임
  public static boolean isLeapYear(int year) {
    return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
  }

  // 연월을 인수로 넘겨받아 그 달의 마지막 날짜를 리턴하는 메소드
  public static int lastDay(int year, int month) {
    int[] m = {31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    m[1] = isLeapYear(year) ? 29 : 28;

    return m[month - 1];
  }

  // 년, 월, 일을 인수로 넘겨받아서 1년 1월 1일부터 지난 날짜를 계산하는 리턴 메소드
  public static int totalDay(int year, int month, int day) {
    int sum = (year - 1) * 365 + (year - 1) / 4 - (year - 1) / 100 + (year - 1) / 400;

    for (int i = 1; i < month; i++) {
      sum += lastDay(year, month);
    }

    return sum + day;
  }

  // 년, 월, 일을 인수로 넘겨받아서 요일을 숫자로 계산해서 리턴하는 메소드
  // 일요일: 0, 월: 1, 화: 2, 수: 3, ..., 토: 6
  public static int weekDay(int year, int month, int day) {
    return totalDay(year, month, day) % 7;
  }
}
