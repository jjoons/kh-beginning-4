<%@page import="problem.a1_solution.BoardDAO"%>
<%@page import="problem.a1_solution.BoardDTO"%>
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
    int num = Integer.parseInt(request.getParameter("num"));
    BoardDTO board = BoardDAO.getInstance().getBoardOfInfo(num);
  %>
  <div align="center">
    <h2>게시글 내용</h2>
    <form method="post" action="14_boardReplyWritePro.jsp">
      <table border="1">
        <tr>
          <td>작성자</td>
          <td><input type="text" name="writer"></td>
        </tr>
        <tr>
          <td>제목</td>
          <td><input type="text" name="subject" value="답글 : "></td>
        </tr>
        <tr>
          <td>이메일</td>
          <td><input type="email" name="email"></td>
        </tr>
        <tr>
          <td>비밀번호</td>
          <td><input type="password" name="password"></td>
        </tr>
        <tr>
          <td>내용</td>
          <td><textarea rows="10" cols="20" name="content"></textarea></td>
        </tr>       
        <tr>
          <td colspan="2">
          
            <input type="hidden" name="num" value="<%= num %>">
          
            <input type="submit" value="등록하기">
            <input type="reset" value="다시 작성하기">
            <input type="button" value="목록으로" onclick="window.location.href='_04boardList.jsp'">
          </td>
        </tr>
      </table>
    </form>
  </div>
</body>
</html>
