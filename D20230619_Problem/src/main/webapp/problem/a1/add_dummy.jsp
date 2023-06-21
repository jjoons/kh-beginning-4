<%@page import="problem.a1.BoardDAO"%>
<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  boolean success = false;

  BoardDAO dao = BoardDAO.getInstance();
  String countString = request.getParameter("count");
  int count = -1;

  try {
    count = Integer.parseInt(countString);
  } catch (NumberFormatException e) {
    response.setStatus(400);
  }

  if (count > 0) {
    dao.addDummyArticles(count);
    success = true;
  }
%>
{
  "success": <%= success %>,
  "total_count": <%= dao.getTotalCount() + (count > 0 ? count : 0) %>
}
