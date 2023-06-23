<%@page import="com.rentcar.RentCarDAO"%>
<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  String reserve_seqString = request.getParameter("reserve_seq");
  int reserve_seq = -1;

  boolean isSuccess = false;

  try {
    reserve_seq = Integer.parseInt(reserve_seqString);
    isSuccess = true;
  } catch (NumberFormatException e) {
    
  }

  RentCarDAO dao = RentCarDAO.getInstance();
  isSuccess =  dao.removeReservation(reserve_seq);
%>
{
  "success": <%= isSuccess %>
}
