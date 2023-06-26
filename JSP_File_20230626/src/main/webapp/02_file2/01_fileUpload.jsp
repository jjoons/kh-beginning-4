<%@page import="java.io.File"%>
<%@page import="java.util.Enumeration"%>
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
    String saveFolder = "02_file2/filesave";
    
    // 인코딩 타입
    String encType = "utf-8";

    // 최대 업로드 크기
    int maxSize = 1024 * 1024 * 5; // 5MB
    
    // 현재 JSP 페이지의 웹 어플리케이션 상의 경로를 구한다
    ServletContext context = getServletContext();
    realFolder = context.getRealPath(saveFolder);
    out.println("realPath: " + realFolder + "<br />");
    
    MultipartRequest multi = null;
    
    try {
      multi = new MultipartRequest(
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
      
      // 파일을 업로드하면 request를 통해 넘어온 데이터를 저장할 수 없다
      // 위에서 생성한 multi 객체를 통해서 데이터를 가져올 수 있다
      // multi.getParameter() 메소드를 통해서 userName을 가져올 수 있다
      
      // form 태그 안에 담겨있는 데이터들의 name 값을 저장한다
      Enumeration<?> keyList = multi.getParameterNames();
      
      // 꺼내올 다음 데이터가 있으면
      while (keyList.hasMoreElements()) {
        // 전송된 이름(name)
        String key = (String) keyList.nextElement();
        
        // 전송된 값(value)
        String value = multi.getParameter(key);

        out.println(key + "=" + value + "<br />");
      }

      out.println("==========");
      
      // 전송된 파일의 정보를 가져와서 출력한다
      Enumeration<?> fileKeyList = multi.getFileNames();
      
      // 파일이 정보를 가지고 있다면
      while (fileKeyList.hasMoreElements()) {
        // input 태그의 속성이 file인 태그의 name
        String key = (String) fileKeyList.nextElement();
        
        // 해당 경로에 저장된 파일 이름
        String fileName = multi.getFilesystemName(key);
        
        // 전송 전 원래 파일 이름
        String original = multi.getOriginalFileName(key);
        
        // 전송된 파일의 내용 타입
        String type = multi.getContentType(key);
        
        // 전송된 파일의 속성이 file인 태그의 name 속성값을 이용해 파일의 객체를 생성한다
        File file = multi.getFile(key);
        
        out.println("파라미터 이름: " + key + "<br />");
        out.println("실제 파일 이름: " + original + "<br />");
        out.println("저장된 파일 이름: " + fileName + "<br />");
        out.println("파일 타입: " + type + "<br />");
        
        if (file != null) {
          out.println("크기: " + file.length() + "<br />");
        }
        
        out.println("=============");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  %>
</body>
</html>
