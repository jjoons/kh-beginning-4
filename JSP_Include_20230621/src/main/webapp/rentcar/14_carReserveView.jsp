<%@page import="com.rentcar.RentCar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.rentcar.RentCarDAO"%>
<%@page import="com.rentcar.CarReserve"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  String id = (String) session.getAttribute("id");

  if (id == null) {
%>
    <script>
      alert('로그인 후 이용 가능합니다');
      location.href = '01_main.jsp?center=05_memberLogin.jsp'
    </script>
<%
  }
  
  RentCarDAO dao = RentCarDAO.getInstance();
  ArrayList<CarReserve> beans = (ArrayList<CarReserve>) dao.getReservation(id);
%>

<table style="">
	<tr height="100">
    <td align="center">
      <font size="6" color="gray">예약 정보</font>
    </td>
  </tr>
  <tr>
  	<td align="center">
      <table border="1">
      	<tr>
      		<td align="center">이미지</td>
      		<td align="center">이름</td>
      		<td align="center">대여일</td>
      		<td align="center">대여기간</td>
      		<td align="center">금액</td>
      		<td align="center">수량</td>
      		<td align="center">보험</td>
      		<td align="center">wifi</td>
      		<td align="center">베이비시트</td>
      		<td align="center">네비게이션</td>
      		<td align="center">삭제</td>
      	</tr>
        <%
          for (CarReserve reserve : beans) {
            RentCar car = dao.getOneCar(reserve.getNo());
            int totalPrice = reserve.getQty() * reserve.getDday() * (
                reserve.getUsein() + reserve.getUsewifi() + reserve.getUseseat()
            );
        %>
            <tr>
            	<td>
                <img alt="" src="imgCar/<%= car.getImg() %>" width="100" height="50" />
              </td>
            	<td align="center"><%= car.getName() %></td>
            	<td align="center"><%= reserve.getRday() %></td>
            	<td align="center"><%= reserve.getDday() %></td>
            	<td align="center"><%= totalPrice %></td>
            	<td align="center"><%= reserve.getQty() %></td>
            	<td align="center"><%= reserve.getUsein() %></td>
            	<td align="center"><%= reserve.getUsewifi() %></td>
            	<td align="center"><%= reserve.getUseseat() %></td>
            	<td align="center"><%= reserve.getUsenavi() %></td>
            	<td align="center">
                <input type="button" value="삭제" onclick="removeReservation(<%= reserve.getReserve_seq() %>)" />
              </td>
            </tr>
        <% } %>
      </table>
    </td>
  </tr>
</table>
<script>
  function removeReservation(reserve_seq) {
    if (confirm('해당 예약 정보를 삭제하시겠습니까?')) {
      fetch('a_remove_reservation.jsp?reserve_seq=' + reserve_seq)
        .then(v => v.json())
        .then(v => {
          if (v.success) {
            alert('예약 목록을 삭제했습니다.')
            location.reload()
          } else {
            alert('예약 목록 삭제에 실패했습니다.')
          }
        })
    }
  }
</script>
