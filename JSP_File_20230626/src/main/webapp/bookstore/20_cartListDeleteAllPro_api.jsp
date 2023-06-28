<%@page import="bookstore.CartDTO"%>
<%@page import="bookstore.CartDAO"%>
<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8" %>
<%
  boolean success = false;
  String message = null;

  String id = (String) session.getAttribute("id");
  
  CartDAO dao = CartDAO.getInstance();
  CartDTO dto = null;
    
  if (id == null) {
    message = "로그인 후 이용할 수 있습니다.";
  }

  if (id != null && request.getMethod().equals("POST")) {
    success = dao.deleteAll(id);
  } else {
    message = "오류가 발생했습니다. 다음 이유로 인해 오류가 발생했을 수도 있습니다."
      + "\n\n-로그인되어 있지 않음\n- 요청한 메소드가 잘못됨";
    response.setStatus(400);
  }
%>
{
  "success": <%= success %>,
  "message": "<%= message %>"
}
