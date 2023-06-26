<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰 메인 화면</title>
</head>
<body>
  <table border="1">
    <tr>
      <td width="150">
        <img src="images/logo.png" width="160" height="50">
      </td>
      <td>
        <jsp:include page="01_top.jsp" />
      </td>
    </tr>
    <tr>
      <td width="150">
        <jsp:include page="03_left.jsp" />
      </td>
      <td width="700">
        <jsp:include page="04_introList.jsp" />
      </td>
    </tr>
    <tr>
      <td colspan="2" align="center" width="700">
        <jsp:include page="02_bottom.jsp" />
      </td>
    </tr>
  </table>
</body>
</html>
<!--
  데이터베이스
  
-->
