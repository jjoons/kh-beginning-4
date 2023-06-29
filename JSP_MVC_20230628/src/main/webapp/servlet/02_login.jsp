<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
  <div align="center">  
    <h2> 로그인 </h2>
    <form action="../loginAction" method="post">
      <table border="1">
        <tr height="40">
          <td width="120"> 아이디 </td>
          <td width="180"> <input type="text" name="id" /> </td>
        </tr>
        <tr height="40">
          <td width="120"> 패스워드 </td>
          <td width="180"> <input type="password" name="pw" /> </td>
        </tr>
        <tr height="40">
          <td colspan="2" align="center">
            <input type="submit" value="로그인" />
          </td>         
        </tr>
      </table>
    </form>

  </div>
</body>
</html>

<!--
  프로젝트 실행 순서
    1. 웹 서버에게 내가 만든 02_login.jsp을 요청한다
    2. 로그인 창에 입력하고 확인을 누르면 처리하는 자바 코드로 보내진다
      연결을 시켜주는 것이 @WebServlet()
      URL을 확인해서 해당하는 클래스 파일의 객체를 생성한다
    3. 서비스 함수에서 실행한다
    4. 요청한 메소드 종류에 따라서 하나의 메소드를 실행한다. doGet(), doPost(), ...
    5. 자바 로직 코드를 실행해서 저장, 조건, 반복 객체 생성 처리된 결과를 가지고
      보여지는 view 부분으로 넘어가야하는데 URL을 모른다
      경로를 설정해서 가지고 있는 데이터를 유지하면서 뷰 페이지로 넘어간다
-->
