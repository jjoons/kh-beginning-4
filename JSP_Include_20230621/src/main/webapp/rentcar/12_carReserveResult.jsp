<%@page import="com.rentcar.RentCar"%>
<%@page import="java.awt.RadialGradientPaint"%>
<%@page import="com.rentcar.RentCarDAO"%>
<%@page import="com.rentcar.CarReserve"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
  <!--
    로그인이 안 되어있으면 "로그인 후 예약이 가능합니다"
    메시지 출력 후 "05_"로 시작하는 파일로 리다이렉트한다
  -->

  <!-- 옵션 선택하면 만원씩 추가하기 -->

  <!-- CarReserve 객체를 생성한다 -->
  <jsp:useBean id="reserve" class="com.rentcar.CarReserve">
    <jsp:setProperty property="*" name="reserve" />
  </jsp:useBean>
  <%
    String id = (String) session.getAttribute("id");
  
    if (id == null) {
  %>
      <script>
        alert('로그인 후 예약이 가능합니다')
        location.href = '05_memberLogin.jsp'
      </script>
  <%
    }

    RentCarDAO dao = RentCarDAO.getInstance();
    RentCar bean = dao.getOneCar(reserve.getNo());

    int carReservationPrice = bean.getPrice() * reserve.getQty() * reserve.getDday();
    int optionPrice = 0;

    if (reserve.getUsein() == 1) optionPrice += 10000;
    if (reserve.getUsewifi() == 1) optionPrice += 10000;
    if (reserve.getUseseat() == 1) optionPrice += 10000;
    
    optionPrice = optionPrice * reserve.getQty() * reserve.getDday();
  %>

  <table>
    <tr height="100">
      <td align="center">
        <font size="6" color="gray">차량 예약 완료 화면</font>
      </td>
    </tr>
    <tr>
      <td align="center">
        <img src="imgCar/<%= bean.getImg() %>" alt="" />
      </td>
    </tr>
    <tr>
      <td align="center">
        <font size="4" color="red">
          차량 총 예약 금액 <%= carReservationPrice %> 원
        </font>
      </td>
    </tr>
    <tr>
      <td align="center">
        <font size="4" color="red">
          차량 총 옵션 금액 <%= optionPrice %> 원
        </font>
      </td>
    </tr>
    <tr>
      <td align="center">
        <font size="4" color="red">
          차량 총 금액 <%= carReservationPrice + optionPrice %> 원
        </font>
      </td>
    </tr>
  </table>
</body>
</html>
