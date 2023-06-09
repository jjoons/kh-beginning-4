<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Scriptlet</title>
</head>
<body>
  <!--
    정적 웹 페이지
      - 언제 접속해도 같은 으압을 보내준다.
      - HTML, CSS, JavaScript 등이 업로드되면 개발자가 수정하기 전까지 매 번 같은 파일을 브라우저가 건네준다
        즉, 정적 웹 페이지에 대한 요청을 받은 경우 서버는 추가적인 처리 과정 없이 클라이언트에게 응답을 보낸다
    
    동적 웹 페이지
      - 웹 서버가 동적 웹 페이지에 대한 요청을 받은 경우 서버는 추가적인 처리과정 이후 클라이언트에게 응답을 보낸다.
      - 동적 페이지는 방문자와 상호 작용하기 때문에 페이지 내용은 그때 그때 다르다.
      - 댓글, 날씨 주가 정보 등 같이 정보 변경이 잦은 곳에 많이 사용된다.
  -->
  
  <h2>1. 출력</h2>
  <%
    String name = "김철수";
    // 콘솔에 출력
    System.out.println(name);
    // HTML에서 데이터를 출력하는 Java 메소드
    out.println(name);
  %>
  
  <!-- HTML -->
  출력 결과: name
  
  <br />
  
  <!-- HTML 코드 뒤에 JSP 문법으로 출력 -->
  출력 결과: <%= name %>
  
  <h2>조건문</h2>
  <%
    String name2 = "이만수";
  %>
  <br />
  <%
    if (name2.equals("이만수")) {
  %>
      <!-- 이렇게 쓰면 불편하니 out.println()을 사용함 -->
      이만수입니다
  <%
    } else {
  %>
      이만수가 아닙니다
  <%
    }
  %>
  
  <h2>import 속성</h2>
  <%
    Random ran = new Random();

    // 배열의 초기화 블럭을 사용하면 배열의 선언, 메모리 할당, 초기값 설정을 한 번에 할 수 있다
    String[] str = {"JSP", "Java", "Spring", "HTML5"};
    
    int i = ran.nextInt(4);
    out.println(str[i]);
  %>
  
  <br />
  <%= str[i] %>이(가) 재밌다
  
  <%
    // java.sql.Timestamp
    //   SQL의 timestamp 타입에 대응하기 위해 만들어졌다
    //   Timestamp 클래스로 날짜, 시간과 관련된 데이터를 조작을 하는 경우에 이용한다
    //
    //   생성자의 매개 변수로 밀리초의 시간 값을 지정한다
    //   System 클래스의 currentTimeMillis 메소드를 사용하면 밀리세컨드로 표현되는 현재 시간을 돌려준다
    Timestamp now = new Timestamp(System.currentTimeMillis());
    // out.println(now.getHours() + "시");
    
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    String strDate = format.format(now);
    
    out.println(strDate);
    
    Timestamp cur = new Timestamp(System.currentTimeMillis());
    out.println(cur);
  %>
  
  현재는 <%= now.getMinutes() %> 분입니다
  
  <h2>반복문</h2>
  <%
    int i2 = 0;
    
    while (i2 < 10) {
      out.println(i2);
      i2++;
    }
  %>
</body>
</html>
