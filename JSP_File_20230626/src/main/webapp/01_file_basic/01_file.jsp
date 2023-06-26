<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <!--
    파일을 업로드하고 다운로드할 때 사용하는 라이브러리며
    cos.jar 라이브러리를 WEB-INF/lib 폴더에 추가해야한다
    
    파일을 업로드할 때에는 enctype을 추가해야한다
    
    input 태그에서 파일을 웹 서버로 넘기게 되면 파일을 서버에 지정된 디렉터리에 저장된다
    실제 파일은 별도의 파일 서의 디렉터리에 저장하고
    DB에는 실제 파일을 저장하지않고 파일의 이름 및 관련 정보들만 저장한다
    
    파일을 업로드하고 다운로드할 때 사용하는 클래스
      [enctype=post] 방식에서만 존재하기 때문에 GET 방식으로는 파일을 전송할 수 없다
      
    파일 업로드
      1. 파일을 저장할 경로 지정: 웹 서비스의 접근 경로가 아닌 실제 경로를 적어준다
      2. 파일의 최대 용량 지정: 한번에 업로드할 최대 용량 지정
      3. MultipartRequest 클래스
  -->
  <form name="fileForm" action="01_fileUpload.jsp" method="POST" enctype="multipart/form-data">
    작성자: <input type="text" name="user" />
    <br />
    제목: <input type="text" name="title" />
    <br />
    파일1: <input type="file" name="uploadfile" />
    <br />
    파일2: <input type="file" name="uploadfile" />
    <br />
    <input type="submit" value="파일 업로드" />
  </form>
</body>
</html>
