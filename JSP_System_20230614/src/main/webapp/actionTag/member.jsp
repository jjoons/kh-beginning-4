<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>회원가입</title>
  <style type="text/css">
    .input {
      width: 96%;
      background-color: hotpink;
      padding: 5px;
    }
  </style>
</head>
<body>
  <!--
    onsubmit: form의 submit 버튼이 클릭되면 실행되는 이벤트
      form check는 submit 버튼이 클릭되면 실행되는 onsubmit 이벤트에서
      JavaScript 함수를 실행해서 form에 입력된 데이터가 정상적인지 유효성을 검사해서
      정상이면 true, 아니면 false 반환
      
      true 값이 오면 action 속성으로 지정한 페이지를 넘겨주고
      false는 현재 페이지에 그대로 머물게 한다
  -->

  <form action="memberPro.jsp" method="post" onsubmit="return passwordCheck(this)">
    <table width="500" border="1" align="center" cellpadding="5" cellspacing="0">
    
      <tr>
        <th colspan="2">회원 가입</th>
      </tr>
    
      <tr>
        <th width="150">아이디</th>
        <td width="350">
          <input class="input" type="text" name="id" placeholder="아이디를 입력하세요"/>
        </td>
      </tr>
    
      <tr>
        <th>이름</th>
        <td>
          <input class="input" type="text" name="name" placeholder="이름을 입력하세요"/>
        </td>
      </tr>
    
      <tr>
        <th>비밀번호</th>
        <td>
          <input class="input" type="text" name="password" placeholder="비밀번호를 입력하세요"/>
        </td>
      </tr>
    
      <tr>
        <th>비밀번호 확인</th>
        <td>
          <input class="input" type="password" name="repassword" placeholder="비밀번호를 한번더 입력하세요"/>
        </td>
      </tr>
    
      <tr>
        <th>나이</th>
        <td>
          <input class="input" type="text" name="age" placeholder="나이를 입력하세요"/>
        </td>
      </tr>
    
      <tr>
        <th>성별</th>
        <td>
          <input type="radio" name="gender" value="true" checked="checked"/>남자
          <input type="radio" name="gender" value="false"/>여자
        </td>
      </tr>
    
      <tr>
        <td colspan="2" align="center">
          <input type="submit" value="회원가입"/>
          <input type="reset" value="다시쓰기"/>
        </td>
      </tr>
    
    </table>
    
    <!-- request.getRemoteAddr(): 접속자 IP 주소를 얻어올 수 있다 -->
    <input type="hidden" name="ip" value="<%=request.getRemoteAddr()%>"/>
  </form>
</body>
</html>
