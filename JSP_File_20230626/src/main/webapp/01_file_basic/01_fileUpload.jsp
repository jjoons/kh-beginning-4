<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.multipart.FileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
    // 웹 어플리케이션 상의 경로
    String realFolder = "";
  
    // 파일이 업로드되는 폴더를 지정한다
    String saveFolder = "01_file_basic/filesave";
    
    // 인코딩 타입
    String encType = "utf-8";

    // 최대 업로드 크기
    int maxSize = 1024 * 1024 * 5; // 5MB
    
    // 현재 JSP 페이지의 웹 어플리케이션 상의 경로를 구한다
    ServletContext context = getServletContext();
    realFolder = context.getRealPath(saveFolder);
    out.println("realPath: " + realFolder + "<br />");
    
    try {
      MultipartRequest multi = new MultipartRequest(
        // 1. form에서 가져온 인자값을 얻기 위새 request 객체를 전달한다
        //   전송할 파일명을 가지고 있는 객체
        request,
        
        // 2. 업로드될 파일의 위치를 입력한다
        //   웹 어플리케이션 상의 경로
        realFolder,
        
        // 3. 파일 업로드 최대 용량 크기. 용량을 초과할 경우 예외가 발생한다
        maxSize,
        
        // 4. 인코딩 타입
        encType,
        
        // 5. 같은 파일을 업로드할 경우 중복되지 않도록 파일 이름을 변환해 주는 기능
        new DefaultFileRenamePolicy() // 같은 이름이면 뒤에 (1), (2) 가 붙음
      );
    } catch (Exception e) {
      e.printStackTrace();
    }
  %>
</body>
</html>
