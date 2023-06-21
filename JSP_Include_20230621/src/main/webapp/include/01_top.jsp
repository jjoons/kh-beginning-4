<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form method="post" action="#">
  아이디 : <input type="text" name="name" placeholder="아이디를 입력하세요.">
  비밀번호 : <input type="text" name="pageName" placeholder="비밀번호를 입력하세요.">
  <input type="submit" value="입력완료">
</form>

<!--
  액션 태그는 독립된 모듈을 구성할 때 사용한다
    컴파일 시 클래스 파일이 별도로 생성되며
    포함되는 페이지와 포함하는 페이지와는 별개로 취급한다
    JSP 페이지 내에서 어떤 동작을 하도록 지시하는 태그
  
  <%-- <jsp:___ > --%> 을 취하고 ___에 무엇이 오느냐에 따라서 그 역할이 달라진다
  <%-- <jsp:forward /> --%>: 현재 페이지를 다른 페이지로 전환할 때 사용한다
  <%-- <jsp:include /> --%>: JSP 페이지 내에 다른 페이지를 집어 넣는다
  
  파라미터를 넘길 때
    <%--
    <jsp:include page="01_top.jsp">
      <jsp:param name="변수이름" value="변수값" />
    </jsp:include>
    --%>
  
  디렉티브 JSP 페이지를 어떻게 처리할 것인지 설정하는 태그
    <%--@include file="***.jsp" --%>
    
  디렉티브는 코드를 복붙하는 기능이라고 볼 수 있다
    코드를 복사해서 include 위치에 코드를 복사하고 복사한 파일이랑 한꺼번에 컴파일을 실행한다
    클래스 파일을 별도로 생성하지 않고 포함되어있는 페이지에 텍스트 코드만 삽입되어 컴파일된다
    
  디렉티브와 액션 태그 차이점
    - 컴파일되는 시점, 포함되는 시점
    - 액션 태그 include: 레이아웃의 한 요소를 모듈화하기 위해서 사용된다
    - 디렉티브 include: JSP 내 변수나 메소드를 사용할 수 있기 때문에
      반복적으로 사용되는 변수나 메소드를 사용할 때 많이 사용함
-->
