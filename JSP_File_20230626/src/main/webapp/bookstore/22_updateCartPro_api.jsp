<%@page import="bookstore.CartDTO"%>
<%@page import="bookstore.CartDAO"%>
<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8" %>
<%
  boolean success = false;
  String message = null;

  String id = (String) session.getAttribute("id");

  String cart_idString = request.getParameter("cart_id");
  String new_countString = request.getParameter("new_count");
  
  int cart_id = -1;
  int new_count = -1;
  
  CartDAO dao = CartDAO.getInstance();
  CartDTO dto = null;
    
  if (id == null) {
    message = "로그인 후 이용할 수 있습니다.";
  }

  try {
    cart_id = Integer.parseInt(cart_idString);
    new_count = Integer.parseInt(new_countString);
  } catch (NumberFormatException e) {}

  if (request.getMethod().equals("POST") && cart_id > 0 && new_count > 0) {
    dto = dao.getCartItem(cart_id);
  } else {
    message = "오류가 발생했습니다. 다음 이유로 인해 오류가 발생했을 수도 있습니다." 
      + "\n\n- 요청한 메소드가 잘못됨\n- 파라미터가 없음\n-수량을 0 이하로 입력함";
    response.setStatus(400);
  }

  if (dto != null && dto.getBuy_count() != new_count) {
    dto.setBuy_count(new_count);
    success = dao.updateCartItem(dto);
  } else {
    message = "해당 카트가 없거나, 수량이 같습니다.";
    response.setStatus(400);
  }
%>
{
  "success": <%= success %>,
  "message": "<%= message %>"<% if (success) { %>,
  "new_count": <%= new_count %>
  <% } %>
}
