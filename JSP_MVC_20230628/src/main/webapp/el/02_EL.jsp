<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
  <%
    int number = 3;
    out.print("number: " + number + "<br />");
  %>
  result: <%= number > 4 %><br />
  
  <%
    request.setAttribute("age", 10);
    // request.getAttribute("age");
  %>
  age: ${age}<br />
</body>
</html>
