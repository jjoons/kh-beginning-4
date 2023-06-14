<%@page import="com.kh.PollRead"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>PollRead</title>
  <link rel="stylesheet" href="poll-common.css" />
</head>
<body>
  <!-- 투표 항목이 저장된 텍스트 파일의 데이터를 읽어서 웹 브라우저에 출력한다 -->
  
  <%
    // 이클립스에서 프로젝트를 실행하면 이클립스 내부적으로 사용하는 웹 서버에 복사하고 실행된다
    // "/" web root(홈페이지 최초 진입 경로)를 의미한다
    // real(실제) path(경로)
    String filePath = application.getRealPath("/") + "poll.txt";
  
    // 경로를 넘겨주고 파일의 데이터를 저장해서 ArrayList 객체를 생성해서 poll에 저장한다
    ArrayList<String> poll = PollRead.pollRead(filePath);

    // 투표 항목의 개수
    int itemCount = (poll.size() - 1) / 2;
    
  %>
  <div id="wrap">
    <form action="PollWrite.jsp" method="post">
      <table id="voting_table">
        <thead>
          <tr>
            <th colspan="2">수료 후 가고싶은 여행지는?</th>
          </tr>
        </thead>
        <!-- <tbody> -->
          <% for (int i = 1; i <= itemCount; i++) { %>
            <tr>
              <%-- 첫번째 줄 제외하고 나머지 구성하는 칸 --%>
            	<td>
                <input type="radio" name="poll" id="travel_1" value="<%= i %>" />
                <%= poll.get(i) %>
              </td>
            </tr>
          <% } %>

          <!-- <tr>
            <td>
              <input type="radio" name="travel" id="travel_1">
              <label for="travel_1">괌</label>
            </td>
          </tr>
          <tr>
            <td>
              <input type="radio" name="travel" id="travel_2">
              <label for="travel_2">코타키나발루</label>
            </td>
          </tr>
          <tr>
            <td>
              <input type="radio" name="travel" id="travel_3">
              <label for="travel_3">다낭</label>
            </td>
          </tr>
          <tr>
            <td>
              <input type="radio" name="travel" id="travel_4">
              <label for="travel_4">나트랑</label>
            </td>
          </tr>
          <tr>
            <td>
              <input type="radio" name="travel" id="travel_5">
              <label for="travel_5">대만</label>
            </td>
          </tr>
          <tr>
            <td>
              <input type="radio" name="travel" id="travel_6">
              <label for="travel_6">보라카이</label>
            </td>
          </tr>
          <tr>
            <td>
              <input type="radio" name="travel" id="travel_7">
              <label for="travel_7">푸꾸옥</label>
            </td>
          </tr>
        </tbody>-->
        <!-- <tfoot>
          <tr>
            <td class="voting_footer_button">
              <button type="submit">투표하기</button>
              <button type="button">결과보기</button>
            </td>
          </tr> 
        </tfoot> -->

        <tr>
          <td align="center">
            <input type="submit" value="투표하기">
            <input type="button" value="결과보기" onclick="location.href = 'PollResult.jsp'">
          </td>
        </tr>
      </table>
    </form>
  </div>
</body>
</html>
