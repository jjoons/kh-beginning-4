<%@page import="com.rentcar.RentCar"%>
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
<!--
  대여 기간 1일~7일
  대여일 
  보험적용 적용(1일 만원) / 비적용
  wifi 적용 적용(1일 만원) / 비적용
  네비게이션 적용 적용(무료) / 비적용
  베이비시트 적용 적용(1일 만원) / 비적용
-->
  <%
    RentCarDAO dao = RentCarDAO.getInstance();
  
    String img = null;
    int no = -1;
  
    try {
      no = Integer.parseInt(request.getParameter("no"));
      img = request.getParameter("img");
    } catch (NumberFormatException e) {}
    
    RentCar bean = dao.getOneCar(no);
  %>
  <div align="center">
    <form action="" method="post">
      <table>
        <tr height="100">
          <td align="center" colspan="3">
            <font size="6" color="gray">옵션 선택</font>
          </td>
        </tr>
        <tr>
          <td rowspan="7" width="500" align="center">
            <img src="imgCar/<%= img %>" alt="" width="450">
          </td>
          <td width="250" align="center">대여기간</td>
          <td width="250" align="center">
            <select name="rent_days">
              <option value="1">1일</option>
              <option value="2">2일</option>
              <option value="3">3일</option>
              <option value="4">4일</option>
              <option value="5">5일</option>
              <option value="6">6일</option>
              <option value="7">7일</option>
            </select>
          </td>
        </tr>
        <tr>
          <td width="250" align="center">대여일</td>
          <td width="250" align="center">
            <input type="date" name="rent_date" />
          </td>
        </tr>
        <tr>
          <td width="250" align="center">보험적용</td>
          <td width="250" align="center">
            <select name="apply_care">
              <option value="true">적용(1일 만원)</option>
              <option value="false">비적용</option>
            </select>
          </td>
        </tr>
        <tr>
          <td width="250" align="center">Wifi 적용</td>
          <td width="250" align="center">
            <select name="apply_wifi">
              <option value="true">적용(1일 만원)</option>
              <option value="false">비적용</option>
            </select>
          </td>
        </tr>
        <tr>
          <td width="250" align="center">네비게이션 적용</td>
          <td width="250" align="center">
            <select name="apply_wifi">
              <option value="true">무료</option>
              <option value="false">비적용</option>
            </select>
          </td>
        </tr>
        <tr>
          <td width="250" align="center">베이비시트 적용</td>
          <td width="250" align="center">
            <select name="apply_wifi">
              <option value="true">적용(1일 만원)</option>
              <option value="false">비적용</option>
            </select>
          </td>
        </tr>
        <tr>
          <td width="250" align="center" colspan="2">
            <input type="hidden" name="no" value="<%= bean.getNo() %>" />
            <input type="hidden" name="img" value="<%= bean.getImg() %>" />
            <input type="submit" value="차량예약하기" />
          </td>
        </tr>
      </table>
    </form>
  </div>
</body>
</html>
