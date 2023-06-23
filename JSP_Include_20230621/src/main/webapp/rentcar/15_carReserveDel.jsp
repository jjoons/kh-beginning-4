<%@page import="com.rentcar.RentCarDAO"%>
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
    // 예약 삭제 메소드 호출
    /* String id = (String) session.getAttribute("id");
    String rday = (String) session.getAttribute("rday"); */
    String id = request.getParameter("id");
    String rday = request.getParameter("rday");
    
    RentCarDAO.getInstance().carRemoveReserve(id, rday);
    response.sendRedirect("01_main.jsp");
  %>
</body>
</html>
