<%@page import="java.util.List"%>
<%@page import="bookstore.CartDTO"%>
<%@page import="bookstore.BuyDTO"%>
<%@page import="bookstore.CartDAO"%>
<%@page import="bookstore.BuyDAO"%>
<%@page import="bookstore.CustomerDAO"%>
<%@page import="bookstore.CustomerDTO"%>
<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8" %>
<%
  boolean mSuccess = false;
  boolean success = false;
  String message = "";

  if (!(mSuccess = request.getMethod().equals("POST"))) {
    message = "해당 HTTP 메소드는 허용되지 않습니다.";
  }

  String id = (String) session.getAttribute("id");
  CustomerDTO member = null;
  CartDTO cartDTO = null;
  
  CustomerDAO customerDAO = CustomerDAO.getInstance();
  BuyDAO buyDAO = BuyDAO.getInstance();
  CartDAO cartDAO = CartDAO.getInstance();
  BuyDTO buyDTO = null;

  if (mSuccess && !(mSuccess = id != null)) {
    message = "로그인한 상태가 아닙니다.";
  } else {
    member = customerDAO.getMember(id); 
  }

  String account = null;
  String deliveryName = null;
  String deliveryTel = null;
  String deliveryAddress = null;

  if (mSuccess && !(mSuccess = member != null)) {
    message = "해당 사용자가 없습니다.";
  } else {
    account = request.getParameter("account");
    deliveryName = request.getParameter("deliveryName");
    deliveryTel = request.getParameter("deliveryTel");
    deliveryAddress = request.getParameter("deliveryAddress");
  }

  List<CartDTO> carts = null;

  if (mSuccess && (mSuccess = account != null && deliveryName != null && deliveryTel != null && deliveryAddress != null)) {
    buyDTO = new BuyDTO();
    carts = cartDAO.getCart(id);
  } else {
    message = "일부 파라미터가 누락되었습니다.";
  }
  
  if (mSuccess && !(mSuccess = carts.size() > 0)) {
    message = "장바구니에 아이템이 없습니다.";
  }
  
  if (!success) {
    response.setStatus(400);
  }
%>
{
  "success": <%= success %>,
  "message": "<%= message %>"
}
