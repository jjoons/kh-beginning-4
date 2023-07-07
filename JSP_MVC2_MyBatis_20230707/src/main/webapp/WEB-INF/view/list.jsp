<%@page import="java.awt.event.ItemEvent"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Insert title here</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
    crossorigin="anonymous"
  >
</head>
<body>
  <div class="mx-auto" style="max-width: 64rem;">
    <div class="bg-primary-subtle text-center">
      <h2 class="fw-bold py-2">게시판 보기</h2>
    </div>
    <div>
      <table class="table table-hover">
        <colgroup>
          <col />
          <col />
          <col />
          <col />
          <col />
        </colgroup>
        <thead class="table-success text-center">
          <tr>
            <th>글번호</th>
            <th>제목</th>
            <th>이름</th>
            <th>작성일</th>
            <th>조회수</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="item" items="${ items }">
            <tr>
              <td class="text-center">${ item.idx }</td>
              <td>
                <a href="content_view.do?id=${ item.idx }">${ item.subject }</a>
              </td>
              <td class="text-center">${ item.name }</td>
              <td class="text-center">${ item.writeDate }</td>
              <td class="text-center">${ item.hit }</td>
            </tr>
          </c:forEach>
        </tbody>
        <tfoot>
          <tr>
            <td colspan="5" class="text-center">

            </td>
          </tr>
          <tr>
            <td colspan="5" class="text-end bg-secondary-subtle">
              <button class="btn btn-outline-primary">글쓰기</button>
            </td>
          </tr>
        </tfoot>
      </table>
    </div>
  </div>
  <script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
    crossorigin="anonymous"
  ></script>
</body>
</html>
