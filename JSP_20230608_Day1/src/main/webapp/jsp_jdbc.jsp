<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp_jdbc</title>
</head>
<body>
  <%
    request.setCharacterEncoding("UTF-8");
  %>

  <%
    Connection con = null;
    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    String user = "kh";
    String password = "KH";

    PreparedStatement pstm = null;
    ResultSet rs = null;

    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      con = DriverManager.getConnection(url, user, password);
      
      if (con != null) {
        out.println("연결됨");
      }

      // 현재 데이터베이스를 선택해서 가져오기
      String sql = "SELECT * FROM CAFE20230607";
      pstm = con.prepareStatement(sql);
      rs = pstm.executeQuery();

      while (rs.next()) {
        out.println(rs.getString("cafeid") + "<br />");
      }
    } catch (Exception e) {
      out.println(e.toString());
    }
  %>
</body>
</html>
