package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import service.AccountService;
import service.ServiceResponseCode;

@WebServlet("/register_api/validate_password")
public class RegisterAPIValidatePasswordController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    Map<String, Object> jsonMap = new HashMap<>();

    String password = req.getParameter("password");
    String password_re = req.getParameter("password_re");

    jsonMap.put("isValid", false);

    int validResult = AccountService.checkValidPassword(password, password_re);

    if (validResult == ServiceResponseCode.PASSWORD_VALID.value()) {
      jsonMap.replace("isValid", true);
    } else {
      resp.setStatus(400);
      String message = ServiceResponseCode.getMessageByValue(validResult);

      jsonMap.put("message", message);
    }

    resp.setContentType("application/json; charset=UTF-8");

    try {
      var os = resp.getOutputStream();
      mapper.writeValue(os, jsonMap);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
