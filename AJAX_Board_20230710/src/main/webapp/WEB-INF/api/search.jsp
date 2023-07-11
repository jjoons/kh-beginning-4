<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8" %>
{
  "success": <%= (boolean) request.getAttribute("success") %>,
  "message": <%= (String) request.getAttribute("message") != null ? "\"" + (String) request.getAttribute("message") + "\"" : null %>,
  "data": <%= (String) request.getAttribute("data") %>
}
