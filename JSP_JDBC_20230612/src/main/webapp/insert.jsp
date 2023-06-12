<%@page import="javax.print.attribute.standard.MediaSize.Other"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  request.setCharacterEncoding("UTF-8");

  Connection con = null;
  String url = "jdbc:oracle:thin:@localhost:1521:orcl";
  String user = "kh";
  String password = "KH";
  
  PreparedStatement ppst = null;
  ResultSet rs = null;

  try {
    Class.forName("oracle.jdbc.driver.OracleDriver");
    con = DriverManager.getConnection(url, user, password);

    if (con != null) {
      out.println("연결됨");
    }

    String sql = "INSERT INTO users VALUES(?, ?, ?, ?)"; 
    ppst = con.prepareStatement(sql);
    
    ppst.setInt(1, Integer.parseInt(request.getParameter("num")));
    ppst.setString(2, request.getParameter("name"));
    ppst.setInt(3, Integer.parseInt(request.getParameter("birth")));
    ppst.setString(4, request.getParameter("address"));
    
    rs = ppst.executeQuery();
  } catch (Exception e) {
    out.println(e.toString());
  }
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>insert.jsp</title>

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

  <!-- Optional JavaScript -->
  <!-- jQuery first, then Popper.js, then Bootstrap JS -->
  <Script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
  <Script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <Script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body class="container">
  <div class="jumbotron">
    <h1>User 정보</h1>
  </div>
  <table class="table table-striped">
    <thead class="thead-dark">
      <tr>
        <th>번호</th>
        <th>이름</th>
        <th>생년월일</th>
        <th>주소</th>
      </tr>
    </thead>
    <tbody>
      <%
        try {
          String sql = "SELECT * FROM users";
          ppst = con.prepareStatement(sql);
          rs = ppst.executeQuery();
        } catch (SQLException e) {
          System.err.println("SQL 오류");
          System.err.println(e);
        }
      %>
      <% while (rs.next()) { %>
        <tr>
        	<td><%= rs.getInt("num") %></td>
        	<td><%= rs.getString("name") %></td>
        	<td><%= rs.getInt("birth") %></td>
        	<td><%= rs.getString("address") %></td>
        </tr>
      <% } %>
    </tbody>
  </table> 
</body>
</html>
