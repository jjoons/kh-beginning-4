<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  Connection con = null;
  PreparedStatement ps = null;
  ResultSet res = null;

  try {
    con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "kh", "KH");
    
    ps = con.prepareStatement("SELECT userid, username, birthyear, addr FROM usertbl");
    res = ps.executeQuery();
  } catch (SQLException e) {
    out.println("SQL 오류 발생");
  }
%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Insert title here</title>
  <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
    crossorigin="anonymous"
  />
  <link rel="stylesheet" href="common.css" />
</head>
<body>
  <div id="wrap">
    <div class="bg-body-secondary _header">
      <h2>유저 정보</h2>
    </div>
    <div>
      <table style="border-collapse: collapse;" class="table table-striped">
        <thead class="table-dark">
          <tr>
            <th>ID</th>
            <th>이름</th>
            <th>태어난 연도</th>
            <th>주소</th>
          </tr>
        </thead>
        <tbody>
          <% while (res.next()) { %>
            <tr>
              <td><%= res.getString("userid") %></td>
              <td><%= res.getString("username") %></td>
              <td><%= res.getString("birthyear") %></td>
              <td><%= res.getString("addr") %></td>
            </tr>
          <% } %>
        </tbody>
      </table>
    </div>
  </div>
  <script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
    crossorigin="anonymous"
  ></script>
</body>
</html>
