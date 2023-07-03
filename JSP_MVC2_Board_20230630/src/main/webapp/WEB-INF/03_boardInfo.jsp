<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>게시글 보기</title>
</head>
<body>
  <div align="center">
    <c:if test="${ num <= 0 }">
      <div>해당 게시글이 존재하지 않습니다.</div>
    </c:if>
    <c:if test="${ num > 0 }">
      <h2>게시글 보기</h2>
      <table border="1">
      	<tbody>
      		<tr height="40">
      			<th align="center" width="120">글번호</th>
      			<td align="center" width="180">${ num }</td>
      			<th align="center" width="120">조회수</th>
      			<td align="center" width="180">${ readcount }</td>
      		</tr>
          <tr height="40">
            <th align="center" width="120">작성자</th>
            <td align="center" width="180">${ writer }</td>
            <th align="center" width="120">작성일</th>
            <td align="center" width="180">${ reg_date }</td>
          </tr>
          <tr height="40">
          	<th align="center" width="120">이메일</th>
          	<td align="center" colspan="3">${ email }</td>
          </tr>
          <tr height="40">
          	<th align="center" width="120">제목</th>
          	<td align="center" colspan="3">${ subject }</td>
          </tr>
          <tr height="40">
          	<th align="center" width="120">글 내용</th>
          	<td align="center" colspan="3">${ content }</td>
          </tr>
      	</tbody>
        <tfoot>
        	<td align="center" colspan="4">
            <button type="button">답글쓰기</button>
            <button type="button">수정하기</button>
            <button type="button">삭제하기</button>
            <button type="button">목록보기</button>
          </td>
        </tfoot>
      </table>
    </c:if>
  </div>
</body>
</html>
