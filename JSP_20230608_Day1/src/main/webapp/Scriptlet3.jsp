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
  String[] positions = {"GK", "DF", "DF", "MF", "MF", "MF"};
  String[] name = {"슈테겐", "세메두", "피케", "라키티치", "부스케츠", "수아레스"};
  
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
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body>
  <!-- 스트라이프 행 줄무늬 -->
  <table class="table table-striped">
    <thead class="thead-dark">
    	<tr>
    		<th>번호</th>
    		<th>포지션</th>
    		<th>이름</th>
    	</tr>
    </thead>
    <tbody>
      <% for (Player player : players) { %>
        <tr>
          <td><%= player.number %></td>
          <td><%= player.position %></td>
          <td><%= player.name %></td>
        </tr>
      <% } %>
    </tbody>
  </table>
  <!-- Optional JavaScript -->
  <!-- jQuery first, then Popper.js, then Bootstrap JS -->
  <Script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
  <Script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <Script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>

<%--
  선언부, 표현식, 스크립트릿을 꼭 body 안에 넣을 필요가 없다
  변수와 메소드를 선언하면 해당 파일 내 어디서나 사용할 수 있다
  <%! ~ %> 를 이용해서 클래스도 안에 정의할 수 있다

--%>
