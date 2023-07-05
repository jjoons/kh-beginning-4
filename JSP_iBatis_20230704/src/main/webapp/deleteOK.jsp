<%@page import="com.kh.service.DeleteService"%>
<%@page import="com.kh.service.SelectService"%>
<%@page import="com.kh.vo.GuestbookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Insert title here</title>
</head>
<body>
  <%
    request.setCharacterEncoding("utf-8");
  
    // delete.jsp에서 넘어오는 데이터를 받는다
    int currentPage = Integer.parseInt(request.getParameter("currentPage"));
    
  %>
  <jsp:useBean id="vo" class="com.kh.vo.GuestbookVO">
    <jsp:setProperty property="*" name="vo" />
  </jsp:useBean>
  
  <%
    // 삭제할 글의 비밀번호와 삭제하기 위해 입력한 비밀번호가 맞는지 비교
    // 삭제할 글을 얻어온다
    GuestbookVO original = SelectService.getInstance().selectByIdx(vo.getIdx());
    
    // 오라클 필드 선언 시 대아토 터압울 char로 선언하면 필드의 크기보다
    // 입력한 문자의 크기가 작으면 남는 자리는 모두 공백으로 리턴한다
    // 테이블을 설계할 때 char 대신 varchar2로 선언한다
    // 이미 선언된 테이블이라면 trim() 메소드를 이용해 양쪽의 공백을 제거한 후 비교한다
    out.println("<script>");
    if (original.getPassword().trim().equals(vo.getPassword())) {
      // 비밀번호 일치
      DeleteService.getInstance().delete(original.getIdx());
    } else {
      out.println("  alert('비밀번호가 일치하지 않습니다.')");
    }
    out.println("  location.href = 'list.jsp?currentPage=" + currentPage + "'");
    out.println("</script>");
  %>
</body>
</html>
