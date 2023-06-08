<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Hello world</title>
</head>
<body>
  <p>안녕하세요</p>
  <p>항상 저장을 해야 한다</p>
  <!--
    JSP: Java Server Pages
      HTML 코드에 Java 코드를 넣어 동적 웹 페이지를 생성하는 웹 어플리케이션 도구

      JSP가 실행되면 자바 서블릿(Servlet)으로 변환되며
      웹 어플리케이션 서버에서 동작하면서 필요한 기능을 수행한다

      생성된 데이터를 웹 페이지와 함께 클라이언트에 응답

    웹 어플리케이션
      - 웹에서 실행되는 응용 프로그램을 의미한다 (은행 업무, 인터넷 쇼핑, 그 외 여러 가지 서비스)
      - 사용자가 필요한 요청(request)을 하고
      - 서버에서는 이에 해당하는 요청을 수행하고 응답(response)을 해 준다

    웹 서버(Web Server)
      클라이언트로부터 요청받아 서버에 저장된 리소스를 클라이언트에게 전달하는 역할

    웹 어플리케이션 서버(Web Application Server, WAS)
      서버단에서 필요한 기능을 수행하고 그 결과를 웹 서버에 전달한다

    자바 서블릿(Java Servlet)
      - 웹 페이지를 동적으로 생성하기 위한 서버 측의 프로그램이다
  -->
  
  <%--
    \<%-- ~ --%\>: JSP 주석
    
    <%@ ~ %>: 디렉티브. 대부분 자동으로 입력된다. import 같이 설정에 관련된 정보들
    <%! ~ %>: 선언부. 프로그램에서 사용할 변수나 메소드를 정의하며 Java 파일로 뽑아내서 사용한다
    <%= ~ %>: 표현식. 변수에 저장된 결과나 연산 결과를 출력한다
      ${변수명}: EL 표현식. 대체해서 사용한다
    <% ~ %>: 스크립트릿. 일반적인 JSP 코드를 적는다. JSTL로 대체해서 사용한다
  --%>
</body>
</html>
