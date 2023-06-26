<%@page import="bookstore.BookDAO"%>
<%@page import="bookstore.BookDTO"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.io.IOException"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
  <%
    request.setCharacterEncoding("utf-8");
  %>
  <%
    // 웹 서버 공간에 이미지를 업로드해서 사용하는 내용
    String realFolder = ""; // 웹 어플리케이션 상의 절대 경로
    String fileName = "";
    MultipartRequest multi = null;
    
    // 파일이 업로드되는 폴더 지정
    String saveFolder = "bookstore/imageFileSave";
    String encType = "utf-8";
    int maxSize = 1024 * 1024 * 5;
    
    // 실제 웹 서버에 저장되는 내부 폴더 경로 가져오기
    ServletContext context = getServletContext();
    realFolder = context.getRealPath(saveFolder);
    System.out.println("realFolder: " + realFolder);
    
    try {
      // 전송을 담당할 컴포넌트를 생성하고 파일 전송
      // 전송할 파일명 = 가지고 있는 객체, 서버 상의 절대 경로, 업로드될 파일 크기, 인코딩 타입, 기본 보안 적용
      multi = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
      
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
    dao.insertBook(dto);
    
    response.sendRedirect("10_bookList.jsp?book_kind=" + book_kind);
  %>
</body>
</html>
