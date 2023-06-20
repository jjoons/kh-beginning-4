<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
  String perPageString = request.getParameter("per_page");
  String pageString = request.getParameter("page");
  String totalString = request.getParameter("total");

  int perPage = -1;
  int pageA = -1;
  int total = -1;
  
  int totalPage = 0;
  int remain = 0;

  if (pageString != null) {
    try {
      pageA = Integer.parseInt(pageString);
    } catch (NumberFormatException e) {
      e.printStackTrace();
      pageA = -1;
    }
  }
  
  if (perPageString != null) {
    try {
      perPage = Integer.parseInt(perPageString);
    } catch (NumberFormatException e) {
      e.printStackTrace();
      perPage = -1;
    }
  }
  
  if (totalString != null) {
    try {
      total = Integer.parseInt(totalString);
    } catch (NumberFormatException e) {
      e.printStackTrace();
      total = -1;
    }
  }
%>

<%
  if (perPage > 0 && pageA > 0 && total > 0) {
    totalPage = total / perPage + ((total % perPage) > 0 ? 1 : 0);
%>
  <nav>
    <ul>
      <% for (int i = 1; i <= totalPage; i++) { %>
        <li><%= i %></li>
      <% } %>
    </ul>
  </nav>
<% } else { %>
  <nav>Pagination 오류</nav>
<% } %>
<div>
  totalPage: <%= totalPage %>, perPage: <%= perPage %>, page: <%= pageA %>
</div>
