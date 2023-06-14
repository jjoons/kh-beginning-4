<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kh.PollRead"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>PollResult</title>
  <link rel="stylesheet" href="poll-common.css" />
  <style>
    #voting_table .voting_count {
      text-align: right;
    }

    .voting_bar {
      width: 100%;
    }
  </style>
  <!-- 일정 시간이 지나면 특정 웹 사이트로 이동 -->
  <!-- <meta http-equiv="refresh" content="5; url='https://www.naver.com'"> -->
  <!-- 일정 시간이 경과되면 현재 페이지를 다시 호출한다. => 새로고침 한다. -->
  <!--
    http-equiv="refresh": 새로고침한다
    content="1; url='?'": 1초 뒤에 url 속성에 지정한 사이트로 이동한다
  -->
  <meta http-equiv="refresh" content="1; url='?'">
</head>
<body>
  <%
    String filePath = application.getRealPath("/") + "poll.txt";
    ArrayList<String> poll = PollRead.pollRead(filePath);
    
    // 몫이 8까지는 타이틀(제목)들
    // 그 이후부터는 투표수를 저장하는 항목들
    int itemCount = (poll.size() - 1) / 2;

    // 득표율을 계산하기 위해 전체 투표 수를 계산한다
    int sum = 0;

    for (int i = itemCount + 1; i < poll.size(); i++) {
      sum += Integer.parseInt(poll.get(i));
    }

    // 숫자 데이터 서식을 설정한다
    DecimalFormat df1 = new DecimalFormat("#,##0표"); // 득표수 서식
    DecimalFormat df2 = new DecimalFormat("0.00%"); // 득표율 서식
  %>
  <table width="500" border="1" align="center" cellpadding="5" cellspacing="0">
    <tr>
      <th colspan="2">
        <%= poll.get(0) %>
      </th>
    </tr>
    <tr>
      <th colspan="2" align="right">
        <%= df1.format(sum) %>
      </th>
    </tr>
    
    <!-- 득표수와 득표율을 게산하는 자바 코드 -->
    <%
      for (int i=1; i<=itemCount; i++) {
        int pyo = Integer.parseInt(poll.get(i + itemCount)); // 득표수
        double per = (double) pyo / sum; // 득표율
    %>
      <!--
        계산한 값을 이용해서 서식 및 테이블로 출력
        막대 그래프 색상
      -->
      <tr>
        <td width="150">
          <%=poll.get(i)%>(<%=df1.format(pyo)%>) <!-- 득표수 서식 지정 -->
          <%-- <%=poll.get(i)%>(<%=df2.format(per)%>) --%> <!-- 득표율 서식 지정 -->
        </td>
        <td width="350">
          <hr color="#12a2f6" size="10" width="<%=350 * per%>" align="left">
        </td>
      </tr>
    <% } %>

    <tr>
      <td colspan="2" align="center">
        <input
          type="button"
          value="투표하기로 가기"
          onclick="location.href = 'PollRead.jsp'"
        />
      </td>
    </tr>
  </table>

  <!-- <div id="wrap">
    <table id="voting_table">
      <colgroup>
        <col style="width: auto" />
        <col style="width: 60%" />
      </colgroup>
      <thead>
        <tr>
          <th colspan="2">수료 후 가고 싶은 여행지는?</th>
        </tr>
        <tr>
          <th colspan="2" class="voting_count">11표</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>괌 (3표)</td>
          <td>
            <meter value="3" max="11" class="voting_bar"></meter>
          </td>
        </tr>
        <tr>
          <td>코타키나발루 (1표)</td>
          <td>
            <meter value="3" max="11" class="voting_bar"></meter>
          </td>
        </tr>
        <tr>
          <td>다낭 (1표)</td>
          <td>
            <meter value="3" max="11" class="voting_bar"></meter>
          </td>
        </tr>
        <tr>
          <td>나트랑 (3표)</td>
          <td>
            <meter value="3" max="11" class="voting_bar"></meter>
          </td>
        </tr>
        <tr>
          <td>대만 (0표)</td>
          <td>
            <meter value="3" max="11" class="voting_bar"></meter>
          </td>
        </tr>
        <tr>
          <td>보라카이 (3표)</td>
          <td>
            <meter value="3" max="11" class="voting_bar"></meter>
          </td>
        </tr>
        <tr>
          <td>포꾸옥 (0표)</td>
          <td>
            <meter value="3" max="11" class="voting_bar"></meter>
          </td>
        </tr>
      </tbody>
      <tfoot>
        <tr>
          <td colspan="2" class="voting_footer_button">
            <button type="button" onclick="location.href = 'PollRead.jsp'">
              투표하기로 가기
            </button>
          </td>
        </tr>
      </tfoot>
    </table>
  </div> -->
</body>
</html>
