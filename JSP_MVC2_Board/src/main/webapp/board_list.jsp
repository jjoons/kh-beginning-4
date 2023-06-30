<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>전체 게시글 보기</title>
</head>
<body>
  <h2>전체 게시글 보기</h2>
  <table border="1">
  	<thead>
  		<tr>
        <th colspan="5">
          <button type="button">글 쓰기</button>
        </th>
      </tr>
      <tr>
      	<th>번호</th>
      	<th>제목</th>
      	<th>작성자</th>
      	<th>작성일</th>
      	<th>조회수</th>
      </tr>
  	</thead>
    <tbody>
      <c:forEach var="item" items="">
        <tr>
        	<td></td>
        	<td></td>
        	<td></td>
        	<td></td>
        	<td></td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</body>
</html>
