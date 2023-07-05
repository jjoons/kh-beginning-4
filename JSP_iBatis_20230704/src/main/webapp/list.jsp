<%@page import="com.kh.service.SelectService"%>
<%@page import="com.kh.vo.GuestbookList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Insert title here</title>
</head>
<body>
  <!--

  -->
  <%
    // 이전 페이지에서 넘어오는 화면에 표시할 페이지 번호(currentPage)를 받는다
    // 게시판이 최초로 실행될 때는 insertOK.jsp에서 호출될 때 list.jsp로
    // currentPage가 넘어오지 않기 때문에 null이며 페이지 번호를 숫자로 변경하는 과정에서
    // 예외가 발생할 수 있기 때문에 예외 처리를 해야된다
    
    int currentPage = 1;
  
    try {
      currentPage = Integer.parseInt(request.getParameter("currentPage"));
    } catch (NumberFormatException e) {
      System.err.println(e);
    }
    
    // 브라우저 화면에 표시할 한 페이지 분량의 글 목록을 얻어온다
    GuestbookList guestbookList = SelectService.getInstance().selectList(currentPage);
    
    // 페이징 정보와 글 목록을 다음 페이지로 데이터 유지해서 이동시켜야 한다
    request.setAttribute("guestbookList", guestbookList);
    
    // 글을 입력할 때 엔터를 눌러 줄을 바꾼경우 <br /> 태그로
    // 변경해서 출력하기 위해 request 영역에 "\n"
    request.setAttribute("enter", "\r\n");
    
    // request 영역에 저장된 글 목록으로 브라우저에 출력하는 페이지 (listView.jsp)로 넘겨준다
    pageContext.forward("listView.jsp");
  %>
</body>
</html>
