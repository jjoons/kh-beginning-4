
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Problem 1</title>
  </head>
  <body>
    <%
      int num = 1;
      char ch = 'A';
      
      for(int i = 0; i<4; i++){
        
        for(int j = 0; j < 4-i; j++){
          out.println(num++);
        }
        for(int z = 0; z < i+1; z++){
          out.println(ch++);
        }	
        out.println("<br>");
      }
      
      
      out.println("<br><br>");
      
      for(int i = 0; i < 5; i++){
        
        for(int j = 0; j <= i; j++){
          out.println("*");
        }
        out.println("<br>");
      }
    %>
  </body>
</html>




답안 입니다. 반복문!
