<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
  <h2>Servlet</h2>
  <ul>
  	<li>웹 클라이언트의 요청을 처리할 수 있는 클래스</li>
    <li>자바를 사용해 웹을 만들기 위해서 필요한 기술</li>
  </ul>
  <br />
  <p>웹 브라우저와 웹 어플리케이션 통신을 할 때 ㅁㅁ을 도와 ㅁㅁ 컴파일된다</p>
  <br />
  <p>
    서블릿을 구현하기 위해서 기본적으로 HttpServlet을 상속해서 웹 클라이언트가 요청하고
    응답해서 처리할 수 있는 클래스를 만드는 것
  </p>
  <br />
  <ul>
  	<li>브라우저 요청을 하면 (login.jsp)</li>
    <li>
      요청받은 톰캣이 우리가 이클립스를 사용하고 있는 특정한 워크스페이스 공간에
      프로젝트를 서버에 복사해서 사용한다
    </li>
  </ul>
  <br />
  <p>
    자바 코드로 변환해서 컴파일되고 컴파일된 class 파일이 객체로 만들어진다.
    해당 객체가 가지고 있는 기능들을 서비스 함수를 통해서 브라우저에 응답할 수 있도록 도와주는 역할
  </p>
  <br />
  <hr />
  <br />
  <ul>
  	<li>요청이 들어오면 Servlet 클래스가 로딩되어 요청에 대한 Servlet 객체가 생성된다</li>
    <li>서버는 init() 메소드를 호출해서 초기화를 진행한다</li>
    <li>serive() 메소드가 호출되서 Servlet이 브라우저의 요청을 처리하도록 한다</li>
    <li>serive() 메소드는 특정 HTTP 요청(GET, POST)을 처리하는 메소드 doGet(), doPost() 를 호출한다</li>
    <li>서버는 destroy() 메소드를 호출해서 Servlet 객체(?)을 제거한다</li>
  </ul>
  <br />
  <p>Servlet의 선처리 init() 메소드 실행 전</p>
  <p>(선처리: 의존하는 객체를 설정한 이후 초기화 작업을 수행할 메소드에 적용한다)</p>
  <h2>어노테이션 @PostConstruct</h2>
  <br />
  <h3>Servlet 생명 주기 (라이프사이클)</h3>
  <pre>
    <code>
      서블릿 객체 생성 -> init() 호출 -> service(), doGet(), doPost() 호출
          최초 한번        최초 한번          요청할 때 마다
    </code>
  </pre>
</body>
</html>
