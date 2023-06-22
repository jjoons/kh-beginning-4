<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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

  <!-- CarReserve 객체를 생성한다 -->
  <jsp:useBean id="rbean" class="com.rentcar.CarReserve">
    <jsp:setProperty property="*" name="rbean" />
  </jsp:useBean>
  <%
    String id = (String) session.getAttribute("id");
    if (id == null) {
  %>
      <script>
        alert('로그인 후 예약이 가능합니다')
        location.href = '01_main.jsp?center=05_memberLogin.jsp'
      </script>
  <% } %>
  
  <!-- 날짜 비교 -->
  <%
    Date d1 = new Date();
    Date d2 = new Date();
  
    // 포맷 이용해서 저장하는 방식
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    d1 = sdf.parse(rbean.getRday());
    d2 = sdf.parse(sdf.format(d2));
    
    // 날짜 비교하는 메소드 이용
    int compare = d1.compareTo(d2);
    
    // 예약하려는 날짜가 현재 날짜보다 이전이라면 "-1"
    // 예약하려는 날짜와 현재 날짜와 같으면 "0"
    // 예약하려는 날짜와 현재 날짜보다 이후라면 "1" 리턴
    
    boolean isAdd = false;
    
    if (compare < 0) {
      // 오늘보다 이전 날짜를 선택했으니 예외 상황이라고 고객에게 알려준다
    %>
      <script>
        alert('현재 시스템 날짜보다 이전 날짜는 선택할 수 없습니다');
        history.go(-1);
      </script>
    <%
    } else isAdd = true;
    
    // 결과적으로 아무런 문제가 없다면 데이터를 저장한 후 결과를 페이지에 보여주기
    // 아이디 값이 빈 클래스에 없기에
    String id1 = (String) session.getAttribute("id");
    rbean.setId(id1);
    
    // 데이터베이스에 빈 클래스 저장
    if (isAdd) RentCarDAO.instance.setReserveCar(rbean);

    // 차량 정보를 얻어오는 메소드
    RentCar cbean = RentCarDAO.instance.getOneCar(rbean.getNo());

    // 차량 총 금액
    //   선택한 차량의 수량, 가격하고 며칠 빌릴지 계산

    // 옵션 금액
    int usein = 0;
    int usewifi = 0;
    int useseat = 0;

    if (rbean.getUsein() == 1) {
      usein = 10000;
    }
    if (rbean.getUsewifi() == 1) {
      usewifi = 10000;
    }
    if (rbean.getUseseat() == 1) {
      useseat = 10000;
    }
    
    // 기본 가격이 있는데 그 이후에 옵션이 추가되서 계산되는 명령문
    int totalOption = (rbean.getQty() * rbean.getDday() * (usein + usewifi + useseat));
    
    int totalCar = rbean.getQty() * rbean.getDday() * cbean.getPrice();
  %>
  <!-- 옵션 선택하면 만원씩 추가하기 -->
  
  <div align="center">
    <table>
      <tr height="100">
        <td align="center"> 
          <font size="6" color="gray"> 차량 예약 완료 화면 </font> 
        </td>
      </tr>
      <tr height="100">
        <td align="center"> 
          <img src="imgCar/<%= cbean.getImg() %>" width="470" />
        </td>
      </tr> 
      <tr height="50">
        <td align="center">
          <font size="5" color="red"> 차량 총예약 금액 <%= totalCar %> 원 </font>
        </td>
      </tr>
      <tr height="50">
        <td align="center">
          <font size="5" color="red"> 차량 총옵션 금액 <%= totalOption %> 원 </font>
        </td>
      </tr>     
      <tr height="50">
        <td align="center">
          <font size="5" color="red"> 차량 총 금액 <%= totalOption + totalCar %> 원 </font>
        </td>
      </tr> 
    </table>
  </div>
</body>
</html>
