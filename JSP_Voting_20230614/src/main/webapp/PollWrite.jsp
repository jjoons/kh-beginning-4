<%@page import="com.kh.PollWrite"%>
<%@page import="com.kh.PollRead"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <!-- PollRead.jsp에서 넘어온 투표한 항목을 받아서 득표수를 증가시켜 텍스트 파일에 저장한다 -->
  <%
    request.setCharacterEncoding("UTF-8");

    String temp = request.getParameter("poll");
    out.println(temp);
    
    // 오류 확인
    //   투표 데이터가 넘어왔는지 확인 (null 또는 공백이 아닌지)
    //   반드시 검증하고 파일 저장
    if (temp != null && temp.trim().length() != 0) {
      try {
        // 파일을 읽어서 투표 항목의 개수를 반환한다
        String filePath = application.getRealPath("/") + "poll.txt";
        ArrayList<String> poll = PollRead.pollRead(filePath);
        int itemCount = (poll.size() - 1) / 2;
  
        int result = Integer.parseInt(temp);
        
        // 넘어온 투표 데이터가 숫자인 경우 정상적인 투표 범위의 데이터인지 검사한다
        if (result >= 1 && result <= itemCount) {
          // 여기까지 왔다면 정상적인 투표 데이터가 넘어온 상태이다
          // 투표한 항목의 득표수를 증가해 텍스트 파일에 저장
          // 득표수를 1씩 증가. 어디 위치에 증가할 지 확인한다
          int index = result + itemCount;
          // 1이 증가한 득표수를 다시 ArrayList에 index 번째 위치에 넣는다
          // 득표수를 1 증가시킨다. poll ArrayList index번째 데이터를 1을 증가시킨다
          result = Integer.parseInt(poll.get(index)) + 1;
          
          // poll.set(index, String.valueOf(result));
          // poll.set(index, String.format("%s", result));
          poll.set(index, result + "");
          
          // poll을 텍스트 파일에 저장할 수 있도록 메소드를 실행한다
          PollWrite.pollWrite(filePath, poll);
          
          // 투표 결과 보기 페이지로 넘겨준다
          response.sendRedirect("PollResult.jsp");
          
          // 리다이렉트 / 포워드
          
        } else {
          // 넘어온 투표 데이터가 정상적인 투표 범위가 아니거나 숫자가 아닌 경우
          // 오류 메시지를 출력하고 PollRead.jsp 페이지로 돌려보낸다
          
          out.println("<script>");
          out.println("alert('투표 데이터가 정상 투표 범위가 아닙니다')");
          out.println("location.href = 'PollRead.jsp'");
          out.println("</script>");
        }
        
      } catch (NumberFormatException e) {
        // 
        out.println("<script>");
        out.println("alert('투표 데이터가 숫자가 아닙니다')");
        out.println("location.href = 'PollRead.jsp'");
        out.println("</script>");
        e.printStackTrace();
      }
    } else {
      out.println("<script>");
      out.println("alert('투표해 주세요')");
      out.println("location.href = 'PollRead.jsp'");
      out.println("</script>");
    }
    
    // 하나의 JSP 파일에서 서버용 스크립트(JSP)와 클라이언트용(JavaScript)를 모두 사용한 경우
    // 코딩 순서와 무관하게 서버용 스크립트가 먼저 다 실행되고 난 후 클라이언트용 스크립트가 실행된다
  %>
</body>
</html>
