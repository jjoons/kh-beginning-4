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
  <div align="center">
    <%
      // DAO 클래스에서 초기 설정 내용 호출하기
      RentCarDAO.instance.realPath = application.getRealPath("");
      RentCarDAO.instance.memberBasicSet();
      RentCarDAO.instance.rentCarBasicSet();
      
      // URL에 오는 변수값 꺼내기
      String center = request.getParameter("center");
      
      // 처음 실행 시에는 center 값이 넘어오지 않기 때문에 null 처리해 준다
      if (center == null) {
        center = "04_center.jsp";
      }
    %>
    <table>
      <!-- top 부분 -->
      <tr>
        <td>
          <jsp:include page="02_top.jsp" />
        </td>
      </tr>
  
      <!-- center 부분 -->
      <tr>
        <td>
          <jsp:include page="<%= center %>" />
        </td>
      </tr>
  
      <!-- bottom 부분 -->
      <tr>
        <td>
          <jsp:include page="03_bottom.jsp" />
        </td>
      </tr>
    </table>
  </div>
</body>
</html>
