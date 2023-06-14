<%@page import="common.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
  <!--
    내장 객체 영역
    각 객체가 저장되는 메모리의 유효 기간

    4가지 영역으로 나뉜다
      pageContext => 현재 보고있는 페이지
      request => 현재 보고있는 페이지와 현재 보고있는 페이지의 다음 페이지 까지
      session => 브라우저가 실행되면 생성되고 브라우저가 종료되면 소멸되는 영역
      application => 서버가 실행되면 생성되고 서버가 종료되면 소멸되는 영역

    시스템 영역 변수 사용하기
      영역이름.setAttribute("영역 변수 이름", 저장할_데이터): 저장
      영역이름.getAttribute("영역 변수 이름"): 꺼내기
      영역이름.removeAttribute("영역 변수 이름"): 삭제
        - 영역 안에 없는 변수. 오류 발생 X

    영역 변수가 저장되는 기억 공간은 영역 변수 이름을 key로 하고
    영역 변수가 저장되는 데이터를 value로 한 Map<String, Object> 형태의 구조로
    value의 자료형을 Object로 저장함. (개발자가 어떤 타입의 데이터를 영역 변수에 저장할 지 모르기 때문에)

    데이터 전송 객체 (Data Transfer Object)
      - 데이터를 저장하거나 전송하는데 쓰이는 객체로 순수하게 데이터만 담고 있으며
        값 객체 (Value Object)

    자바 빈즈 (Java Beans)
      [ 자바빈즈 규약 ]
        1. 자바빈즈는 기본(default) 패키지 이외의 패키지에 속해야 함
        2. 멤버 변수(속성)의 접근 지정자는 private으로 선언
        3. 기본 생성자가 있어야 함
        4. 멤버 변수에 접근할 수 있는 게터(getter)/세터(setter) 메서드가 필요
        5. 게터/세터 메서드의 접근 지정자는 public으로 선언
  -->
  
  <%
    // 속성 저장
    pageContext.setAttribute("pageInteger", 1000);
    pageContext.setAttribute("pageString", "페이지 영역의 문자열");
    pageContext.setAttribute("pagePerson", new Person("이서희", 20));
    
    // 속성 읽기
    int pInteger = (int) pageContext.getAttribute("pageInteger");
    String pString = (String) pageContext.getAttribute("pageString");
    Person pPerson = (Person) pageContext.getAttribute("pagePerson");
  %>
  
  <ul>
    <li>integer 객체: <%= pInteger %></li>
    
    <!-- 저장한 객체가 문자열이거나 기본 타입의 래퍼 클래스라면 별도의 형 변환이 없다 -->
    <li>String 객체: <%= pString %></li>
    <li>Person 객체: <%= pPerson.getName() %>, <%= pPerson.getAge() %></li>
  </ul>
  
  <!-- include: 다른 JSP 파일 포함. 포함 관계이므로 같은 페이지로 인식 -->
  <h2>include 된 파일에서 page 영역 읽어오기</h2>
  <%@ include file="PageInclude.jsp" %>
  
  <!-- 페이지 이동 후 page 영역 읽어오기 -->
  <h2>href 페이지 이동 후 page 영역 읽어오기</h2>
  <a href="PageLocation.jsp">PageLocation.jsp 바로가기</a>

  <!--
    ## 내장 객체의 영역이란?

    - 각 객체가 저장되는 메모리의 유효기간

    → 웹 애플리케이션은 페이지 단위로 구성이 된다. 그래서 다른 페이지에서 선언한 변수에 접근하기 위해 접근할 수 있는 페이지 범위를 지정하는 것이 영역이다.

    - 스크립트릿 안에서만 사용 가능
    - 스크립트릿에 내장 객체와 같은 이름의 변수를 선언할 수 없음선언문에서는 사용 가능하나 가급적 사용하지 않는 것이 좋음
    - 서블릿 컨테이너가 해당 JSP 페이지 실행 시 자동으로 생성jsp가 변환된 fileName_jsp.java 파일을 열어보면_jspService() 메소드 내부에 선언되어 있음


    ## 내장 객체 영역

    > 웹 애플리케이션은 page, request, session, application 4개의 영역(scope)을 가짐
    > 
    > 
    > 내장 객체의 영역은 객체 유효기간이라고도 불리며
    > 
    > 객체를 누구와 공유할 것인가를 나타냄
    > 

    ---

    ### page 영역

    - 한 번의 웹 브라우저(클라이언트)의 요청에 대해 하나의 JSP 페이지가 호출됨
    - page 영역은 객체를 하나의 페이지 내에서만 공유
    - pageContext 내장 객체 사용
    - 페이지를 벗어나면 소멸됨

    ---

    ### request 영역

    - 한 번의 웹 브라우저의 요청에 대해 같은 요청을 공유하는 페이지가 대응됨
    - 같은 request 영역인 경우 두 개의 페이지가 같은 요청을 공유할 수 있음
    - 객체를 하나 또는 두 개의 페이지 내에서 공유 가능
    - include, forward 액션 태그 사용시 request 내장 객체를 공유하게 되며그에 따라 같은 request 영역이 됨
    - 주로 페이지 모듈화에 사용
    - request 내장 객체 사용

    하나의 HTTP 요청을 처리할 때 사용되는 영역

    → 호출된 페이지와 포워드(요청전달)된 페이지까지 공유됨

    ---

    ### session 영역

    - 하나의 웹 브라우저당 1개의 session 객체 생성
    - 같은 웹 브라우저 내에서 요청되는 페이지들은 같은 객체 공유
    - 주로 회원 관리(인증)에 사용되며 session 내장 객체 사용

    하나의 웹 브라우저에 관련된 영역

    → 클라이언트가 접속한 후, 웹 브라우저가 종료 될 때까지 공유됨

    ---

    ### application 영역

    - 하나의 웹 애플리케이션(프로젝트)당 1개의 application 객체 생성
    - 같은 웹 애플리케이션에 요청되는 페이지들은 같은 객체 공유/Project_Name 웹 애플리케이션에서는 같은 application 객체 공유
    - 애플리케이션 전체에서 공유하는 객체이므로메모리에 부담이 갈 수 있어서 자주 사용되지는 않음
    - application 내장 객체 사용
    - 

    하나의 웹 어플리케이션과 관련된 영역

    → 서버가 꺼질 때 까지 공유됨
  -->
</body>
</html>
