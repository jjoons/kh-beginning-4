<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%!
  public class Player {
    Integer number;
    String name;
    String position;

    // 생성자
    public Player(Integer number, String name, String position) {
      this.number = number;
      this.name = name;
      this.position = position;
    }
  }
%>

<%!
  int[] numbers = {1, 2, 3, 4, 5, 6};
  String[] name = {"이", "김", "홍", "박", "ㅁㄴㅇ", "ㄴㅇㄹ"};
  String[] positions = {"a", "b", "c", "d", "e", "f"};
  
  Player[] players = new Player[numbers.length];
%>

<%
  for (int i = 0; i < numbers.length; i++) {
    players[i] = new Player(numbers[i], name[i], positions[i]);
  }
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Scriptlet3</title>
</head>
<body>
  <table border="1" style="border-collapse: collapse;">
    <thead>
    	<tr>
    		<th>번호</th>
    		<th>이름</th>
    		<th>포지션</th>
    	</tr>
    </thead>
    <tbody>
      <% for (Player player : players) { %>
        <tr>
          <td><%= player.number %></td>
          <td><%= player.name %></td>
          <td><%= player.position %></td>
        </tr>
      <% } %>
    </tbody>
  </table>
</body>
</html>

<%--
  선언부, 표현식, 스크립트릿을 꼭 body 안에 넣을 필요가 없다
  변수와 메소드를 선언하면 해당 파일 내 어디서나 사용할 수 있다
  <%! ~ %> 를 이용해서 클래스도 안에 정의할 수 있다

--%>
