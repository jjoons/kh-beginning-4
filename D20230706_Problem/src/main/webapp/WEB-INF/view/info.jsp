<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>회원 정보</title>
</head>
<body>
  <div>
    <h3>회원 정보</h3>
    <table border="1">
    	<thead>
    		<tr>
    			<th>no</th>
          <th>id</th>
          <th>pw</th>
          <th>name</th>
          <th>age</th>
    		</tr>
    	</thead>
      <tbody>
      	<tr>
      		<td>${ dto.user_no }</td>
      		<td>${ dto.user_id }</td>
          <td>${ dto.user_pw }</td>
      		<td>${ dto.user_name }</td>
      		<td>${ dto.user_age }</td>
      	</tr>
      </tbody>
    </table>
    <a href="home">메인 페이지로 이동</a>
    <a href="logout">로그아웃</a>
  </div>
</body>
</html>
