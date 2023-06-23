<%@page import="java.util.ArrayList"%>
<%@page import="com.rentcar.RentCar"%>
<%@page import="java.util.Vector"%>
<%@page import="com.rentcar.RentCarDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>전체 렌트카 보기</title>
</head>
<body>
  <div align="center">
    <table>
      <tr height="60">
        <td align="center" colspan="3">
          <font size="6" color="gray">전체 렌트카 보기</font>
        </td>
      </tr>
    </table>
    <%
      RentCarDAO rdao = RentCarDAO.getInstance();
      ArrayList<RentCar> v = rdao.getAllCar();
      
      for (int i = 0, j = 0; i < v.size(); i++) {
        if (j % 3 == 0) {
    %>
          <tr height="220">
    <%  } %>
        <td width="333" align="center">
          <a href="01_main.jsp?center=10_carReserveInfo.jsp%3Fno%3D<%= v.get(i).getNo() %>">
            <img src="imgCar/<%= v.get(i).getImg() %>" alt="" />
          </a>
          <font size="3" color="gray">차량명 | <%= v.get(i).getName() %></font>
        </td>
      <%
          j++;
        }
      %>
    </tr>
  </div>
</body>
</html>
