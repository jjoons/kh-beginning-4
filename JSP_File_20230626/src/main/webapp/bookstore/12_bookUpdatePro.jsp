<%@page import="java.util.Enumeration"%>
<%@page import="bookstore.BookDAO"%>
<%@page import="bookstore.BookDTO"%>
<%@page import="java.io.IOException"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%
  request.setCharacterEncoding("utf-8");
%>
<%
  // 파일 업로드하는 명령문
  //   MultipartRequest 클래스 이용
  //   저장되는 폴더: bookstore/imageFileSave
  MultipartRequest multi = null;
  String fileName = "";
  
  ServletContext context = getServletContext();
  String realFolder = context.getRealPath("bookstore/imageFileSave");
  
  try {
    multi = new MultipartRequest(request, realFolder, 1024 * 1024 * 10, "utf-8", new DefaultFileRenamePolicy());
    
    // 전송한 파일의 정보를 가져와 출력
    Enumeration<?> files = multi.getFileNames();
    
    // 정보가 있다면
    while (files.hasMoreElements()) {
      String key = (String) files.nextElement();
      
      // 서버에 저장된 파일 이름
      fileName = multi.getFilesystemName(key);
    }
  } catch (IOException e) {
    e.printStackTrace();
  }
%>
<%
  // 업로드한 다음 MultipartRequest 클래스에서 데이터를 BookDTO에 저장
  int book_id = Integer.parseInt(multi.getParameter("book_id"));
  
  // 데이터베이스 수정하는 메소드: updateBoard(수정된 BookDTO 객체)
  // 수정하고 페이지 이동
  // 폼 태그에서 넘어오는 데이터를 BookDTO 객체에 저장
    // 데이터 꺼내오는 것은 아래 소스 참고
    String book_kind = multi.getParameter("book_kind");
    String book_title = multi.getParameter("book_title");
    String book_price = multi.getParameter("book_price");
    String book_count = multi.getParameter("book_count");
    String author = multi.getParameter("author");
    String publishing_com = multi.getParameter("publishing_com");
    String book_content = multi.getParameter("book_content");
    String discount_rate = multi.getParameter("discount_rate");
    String year = multi.getParameter("publishing_year");
    
    // BookDTO 객체에 저장
    BookDTO dto = new BookDTO();
    
    // 파일 이름이 서버에 등록되어있다면 파일 이름으로 book_img에 저장시키고
    // 만약 파일 이름이 없다면 (null 이면) nothing.jpg
    
    if (fileName != null) {
      // BookDTO에 저장
      dto.setBook_image(fileName);
    } else {
      dto.setBook_image("nothing.jpg");
    }
    
    BookDAO dao = BookDAO.getInstance();
    dao.updateBoard(dto, book_id);
    
    response.sendRedirect("10_bookList.jsp?book_kind=" + book_kind);
%>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
</body>
</html>
