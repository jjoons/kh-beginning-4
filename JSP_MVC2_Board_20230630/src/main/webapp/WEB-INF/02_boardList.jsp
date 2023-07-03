<%@page import="model.BoardBean"%>
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
  <div align="center">
    <h2>전체 게시글 보기</h2>
    <table border="1">
      <colgroup>
      	<col />
      	<col />
      	<col />
      	<col />
      	<col />
      </colgroup>
    	<thead>
        <tr height="40">
          <td colspan="5" align="right">
          <button onclick="location.href='BoardWriteAction'">글쓰기</button></td>
        </tr>
        <tr height="40" align="right">
          <td width="50" align="center"> 번호 </td>
          <td width="320" align="center"> 제목</td>
          <td width="100" align="center"> 작성자 </td>
          <td width="150" align="center"> 작성일 </td>
          <td width="80" align="center"> 조회수 </td>  
        </tr>
    	</thead>
      <tbody>
        <c:forEach var="item" items="${ boardList }">
          <tr height="40">
          	<td width="50" align="center">${ item.getNum() }</td>
          	<td width="320" align="center">
              <!-- 답글이 달렸을 때 -->
              <a href="InfoAction?num=${ item.getNum() }">${ item.getSubject() }</a>
            </td>
          	<td width="100" align="center">${ item.getWriter() }</td>
          	<td width="150" align="center">${ item.getReg_date() }</td>
          	<td width="80" align="center">${ item.getReadcount() }</td>
          </tr>
        </c:forEach>
        <c:set var="number" value="${ number - 1 }" />
      </tbody>
    </table>
    
    <c:set var="count" value="0" />
    <c:if test="${ count > 0 }">
    <!-- 페이지 -->
    
    <!-- 화면에 보여질 페이지 숫자 표현 -->
    
      <!--  이전 링크를 갈지 파악 -->
      <c:if test="${startPage >10 }">
        <a href="BoardListAction?pageNum=${startPage-10 }">[이전]</a>
      </c:if>
       
       <!-- 페이징 처리 -->
       <c:forEach var="i" begin="${startPage }" end="${endPage}">
        <a href="BoardListAction?pageNum=${i }">[${i}]</a>
      </c:forEach> 
       
      <!-- 다음 -->
      <c:if test="${endPage < pageCount }">
        <a href="BoardListAction?pageNum=${startPage+10 }">[다음]</a>
      </c:if>
    </c:if>
    
  </div>
</body>
</html>
