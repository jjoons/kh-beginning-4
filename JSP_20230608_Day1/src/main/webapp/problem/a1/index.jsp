<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Problem 1</title>
</head>
<body>
<!--
2차 반복문을 이용해서 다음과 같이 출력하기

*
**
***
****
*****

123A
45BC
6DEF
-->

  <h2>별</h2>
  <%
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j <= i; j++) {
        out.println("*");
      }
      out.println("<br />");
    }
  %>
  
  <h2>문자</h2>
  <%
    // 1번
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 4; j++) {
        if (i == 0)
          out.println((j >= 0 && j <= 2) ? (j + 1) : j == 3 ? "A" : "");
        else if (i == 1)
          out.println((j >= 0 && j <= 1) ? (j + 4) : j == 2 ? "B" : j == 3 ? "C" : "");
        else if (i == 2)
          out.println(j == 0 ? 6 : j == 1 ? "D" : j == 2 ? "E" : j == 3 ? "F" : "");
      }
      out.println("<br />");
    }

    // 2번
    char[][] arr = {
        {'1', '2', '3', 'A'},
        {'4', '5', 'B', 'C'},
        {'6', 'D', 'E', 'F'},
    };
  
    for (char[] arr1 : arr) {
      for (char str : arr1) {
        out.println(str);
      }
      
      out.println("<br />");
    }
  %>
</body>
</html>
