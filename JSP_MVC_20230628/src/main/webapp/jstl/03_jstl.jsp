<%@page import="java.util.ArrayList"%>
<%@page import="_03_jstl.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  MemberBean bean1 = new MemberBean("qwer", "1111", "홍길동", "qwer@naver.com", "스포츠");
  MemberBean bean2 = new MemberBean("poiu", "2222", "박민철", "poiu@naver.com", "바둑");
  MemberBean bean3 = new MemberBean("mlko", "3333", "김상수", "mlko@naver.com", "영화");
  
  ArrayList<MemberBean> list = new ArrayList<>();
  list.add(bean1);
  list.add(bean2);
  list.add(bean3);
  
  request.setAttribute("memberList", list);
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>JSTL 태그</title>
  </head>
  <body>
  <table border="1">
    <tr>
      <th>아이디</th>
      <th>패스워드</th>
      <th>이름</th>
      <th>이메일</th>
      <th>취미</th>
    </tr>
    <%-- 확장for문과 기능이 똑같다. --%>
    <c:forEach var="bean" items="${ memberList }">
      <tr>
        <td>${ bean.id }</td>
        <td>${ bean.pw }</td>
        <td>${ bean.name }</td>
        <td>${ bean.email }</td>
        <td>${ bean.hobby }</td>
      </tr>
    </c:forEach>
  </table>

  </body>
</html>
