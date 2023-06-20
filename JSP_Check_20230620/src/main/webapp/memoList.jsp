<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="db.DBUtil"%>
<%@page import="java.sql.Connection"%>
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
    입력 화면 시작
    
    저장을 했는데 IP 주소가 이상하게 보인다.
    localhost가 기본적으로 IPv6로 설정되어 있어서 IPv4로 변경해야한다
    주소창에서 localhost 부분을 아래 명령어를 입력해서 나오는 IP 주소로 넣어준다
      cmd > ipconfig > IPv4
      http://192.168.20.102:8090/JSP_Check/memoList.jsp
  -->
  <form action="memoInsert.jsp" method="post">
    <table width="1000" align="center" border="1" cellpadding="5" cellspacing="0">
      <tr>
        <th colspan="3">아주 아주 많이 허접해보이는 출첵 게시판 Ver 0.01</th>
      </tr>
      <tr>
        <th width="100">이름</th>
        <th width="100">비밀번호</th>
        <th width="800">메모</th>
      </tr>
      <tr>
        <td align="center">
          <input type="text" name="name" style="width: 90%; height: 25px;"/>
        </td>
        <td align="center">
          <input type="password" name="password" style="width: 90%; height: 25px;"/>
        </td>
        <td align="center">
          <input type="text" name="memo" style="width: 92%; height: 25px;"/>
          <input type="submit" value="저장"/>
        </td>
      </tr>
    </table>
  </form>
  <br />
  <hr size="3" color="blue" />
  <!--
    테이블에 저장된 글 목록 전체를 글 번호(idx)의 내림차순(최신글부터)으로 얻어온다
  -->
  <%
    Connection conn = DBUtil.getMySQLConnection();
    String sql = "SELECT * FROM memolist1 ORDER BY idx DESC";

    PreparedStatement pstmt = conn.prepareStatement(sql);
    ResultSet rs = pstmt.executeQuery();
  %>
  <!-- 테이블에서 얻어온 글 목록을 출력한다 -->
  <table width="1200" align="center" border="1" cellpadding="5" cellspacing="0">
    <tr>
      <th width="80">글번호</th>
      <th width="80">이름</th>
      <th width="840">메모</th>
      <th width="80">ip</th>
    </tr>
    <%
      if (rs.next()) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        Date date = new Date();
        
        do {
    %>
          <tr>
          	<td align="center"><%= rs.getInt("idx") %></td>
          	<td align="center"><%= rs.getString("name") %></td>
          	<td align="center"><%= rs.getString("memo") %></td>
          	<td align="center"><%= rs.getString("ip") %></td>
          </tr>
    <%
        } while (rs.next());
      } else {
    %>
        <tr>
          <marquee>테이블에 저장된 글이 없습니다</marquee>
        </tr>
    <% } %>
  </table>
</body>
</html>
