<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%
    // 일반 변수는 선언하지 않았으므로 오류가 발생한다
    //     out.println("일반 변수: " + var + "<br />");
  
    out.println("pageContext 영역 변수: " + pageContext.getAttribute("pageContextVar") + "<br/>");
    out.println("request 영역 변수: " + request.getAttribute("requestVar") + "<br/>");
    out.println("session 영역 변수: " + session.getAttribute("sessionVar") + "<br/>");
    out.println("application 영역 변수: " + application.getAttribute("applicationVar") + "<br/>");
  %>
  
  requestTest.jsp 파일의 pageContext 영역 변수(println() 메소드): 
    <%out.println(pageContext.getAttribute("pageContextVar") + "<br/>"); %>
  requestTest.jsp 파일의 pageContext 영역 변수(jsp 표현식): <%=pageContext.getAttribute("pageContextVar")%><br/>
  requestTest.jsp 파일의 pageContext 영역 변수(EL): ${pageContextScope.pageContextVar}<br/>
  requestTest.jsp 파일의 pageContext 영역 변수(EL): ${pageContextVar}<br/>
  
  <!--
    영역 변수에 저장된 데이터를 얻어올 때 영역 객체 이름을 사용하지 않고 영역 변수 이름만 사용하면
    EL은 pageContext > request > session > application 영역 순서대로 검사해서
    얻어오려는 변수가 존재할 경우 값을 얻어온다
  -->
</body>
</html>
