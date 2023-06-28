<%@page import="bookstore.CartDTO"%>
<%@page import="bookstore.CartDAO"%>
<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8" %>
<%
  boolean success = false;
  String message = null;

  String id = (String) session.getAttribute("id");

  String cart_idString = request.getParameter("cart_id");
  
  int cart_id = -1;
  int new_count = -1;
  
  CartDAO dao = CartDAO.getInstance();
  CartDTO dto = null;
    
  if (id == null) {
    message = "로그인 후 이용할 수 있습니다.";
  }

  try {
    cart_id = Integer.parseInt(cart_idString);
  } catch (NumberFormatException e) {}

  if (id != null && request.getMethod().equals("POST") && cart_id > 0 ) {
    dto = dao.getCartItem(cart_id);
  } else {
    message = "오류가 발생했습니다. 다음 이유로 인해 오류가 발생했을 수도 있습니다."
      + "\n\n- 요청한 메소드가 잘못됨\n- 파라미터가 없거나 잘못 입력함\n- ID를 0 이하로 입력함";
    response.setStatus(400);
  }

  if (dto != null) {
    dto.setBuy_count(new_count);
    success = dao.deleteList(cart_id);
  } else {
    message = "해당 카트가 없습니다.";
    response.setStatus(400);
  }
%>
{
  "success": <%= success %>,
  "message": "<%= message %>"
}
