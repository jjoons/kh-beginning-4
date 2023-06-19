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
    request.setCharacterEncoding("utf-8");
  %>

  <jsp:useBean id="date" class="java.util.Date" />
  ${date} <br />

  <!--
    useBean() 액션 태그로 new를 사용하지 않고 객체 만들기
      id 속성에는 만들려는 객체의 이름을 쓴다
      class 속성에는 만들려 하는 클래스의 이름을 반드시 풀 패키지 이름과 같이 써야한다
      액션 태그는 XML 문법이 따르기 때문에 <tag></tag> 사이에 아무런 내용이 없으면
        끝 부분 (</tag>)를 생략할 수 있는데 그냥 지우면 오류가 발생하니 <tag /> 처럼 작성하면 된다
  -->
  
  <!-- MemberVO vo = new MemberVO() -->
  <jsp:useBean id="vo" class="members.MemberVO">
    <!--
      setProperty 액션 속성: 지정한 필드의 setter 메소드를 호출한다
      Property 속성: setter 메소드를 실행할 필드 이름을 쓴다
      name 속성: setter 메소드를 실행할 필드가 정의된 객체 이름을 쓴다
      
      form에서 전송되는 request 객체에서 꺼내는 작업을 하지 않아도 자동으로 처리해 준다
    -->
    <%--
    <jsp:setProperty property="id" name="vo" />
    <jsp:setProperty property="name" name="vo" />
    <jsp:setProperty property="password" name="vo" />
    <jsp:setProperty property="age" name="vo" />
    <jsp:setProperty property="gender" name="vo" />
    <jsp:setProperty property="ip" name="vo" />
    --%>
    
    <!--
      모든 필드의 setter 메소드가 실행된다
      단 form에서 넘어온 name 속성과 필드의 이름이 같은 것만 setter 메소드가 실행된다
    -->
    <jsp:setProperty property="*" name="vo"></jsp:setProperty>
  </jsp:useBean>
  
  ${vo}
</body>
</html>
