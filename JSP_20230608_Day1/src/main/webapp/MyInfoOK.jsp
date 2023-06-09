<%@page import="java.util.Arrays"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form에서 넘어온 데이터를 JSP로 처리하는 내용</title>
</head>
<body>
  <%
    // form에서 입력된 한글 데이터가 POST 방식으로 전송될 때 깨지는 현상을 방지한다
    // submit 클릭을 하면 request 객체에 form이 가지고 있는 정보가 모두 담겨 객체로 반환된다
    // getParameter() 메소드가 실행되기 전(맨 처음)에 인코딩 내용을 작성한다
    request.setCharacterEncoding("UTF-8");
  
    // getParameter(): 모든 정보가 문자열 형태로 반환된다
    String name = request.getParameter("name");
    out.println(name + "님 안녕하세요 <br />");
    
    String id = request.getParameter("id");
    out.println(name + "님 id: " + id + " 입니다<br />");

    String password = request.getParameter("password");
    out.println(name + "님 비밀번호: " + password + " 입니다<br />");

    try {
      int age = Integer.parseInt(request.getParameter("age"));

      out.println(name + "님 올해 나이는 " + age + "살입니다 <br />");
      out.println(name + "님 내년 나이는 " + (age + 1) + "살입니다 <br />");
    } catch (NumberFormatException e) {
      out.println("잘못된 나이가 입력되었습니다");
      out.println("<script>alert('잘못된 나이가 입력되었습니다')</script>");
    }

    // out.println(): 웹 페이지에 출력
    // System.out.println(): Eclipse 콘솔에 출력

    // 현재 나이는 20살이며 내년에는 21살입니다


    // 성별을 구분하기 위해 request 객체 이용
    // Boolean Wrapper 클래스를 이용해서 객체로 생성한 뒤 auto unboxing을 이용해서 기본 자료형으로 저장
    boolean gender = Boolean.getBoolean(request.getParameter("gender"));
    
    out.println(name + "님 " + (gender ? "남자" : "여자") + "입니다");
    
    // 체크박스에 있는 값들을 가지고 오기
    // getParameter(name): 넘어온 데이터를 받으면 맨 처음 선택한 값 1개만 받을 수 있다
    // getParameterValues(): 배열로 반환한다
    String[] hobbies = request.getParameterValues("hobbies");
    out.println(name + "님의 취미는 " + hobbies + " 입니다 <br />");
    out.println(name + "님의 취미는 " + Arrays.toString(hobbies) + " 입니다 <br />");
    
    out.println(name + "님의 취미는 ");
    
    // 만약 아무런 데이터를 선택하지 않았으면 오류 발생
    // 예외 처리를 해야한다

    try {
      for (int i = 0; i < hobbies.length; i++) {
        out.println(hobbies[i] + " ");
      }
      
      out.println("입니다 <br />");
    } catch (NullPointerException e) {
      out.println("없습니다 <br />");
    }

    // 콤보 박스, 목록 상자 내용 확인
    String trip = request.getParameter("trip");
    out.println(name + "님은 " + trip + "에 가고 싶습니다 <br />");
    
    String[] travel = request.getParameterValues("travel");
    out.println(name + "님은 " + travel + "에 가고 싶습니다 <br />");
    out.println(name + "님은 " + Arrays.toString(travel) + "에 가고 싶습니다 <br />");

    try {
      for (int i = 0; i < travel.length; i++) {
        out.println(travel[i] + " ");
      }

      out.println(" 입니다 <br />");
    } catch (NullPointerException e) {
      out.println(" 가고 싶은 곳이 없습니다 <br />");
    }
    
    // 메모 (textarea)
    String content = request.getParameter("content");
    out.println(name + "님이 남긴 글: " + content);
    
    // 태그 사용 가능, 줄 바꿈 기능
    out.println(name + "님이 남긴 글: " + content.replace("\r\n", "<br />") + "<br />");
  %>
</body>
</html>
