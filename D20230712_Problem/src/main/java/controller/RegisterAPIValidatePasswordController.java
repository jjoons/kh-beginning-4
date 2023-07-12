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

    if (password != null && !password.isEmpty() && password_re != null && !password_re.isEmpty()) {
      if (password.equals(password_re)) {
        jsonMap.replace("isValid", true);
      } else {
        resp.setStatus(400);
        jsonMap.put("message", "비밀번호가 일치하지 않거나 조건에 맞지 않습니다.");
      }
    } else {
      resp.setStatus(400);
      jsonMap.put("message", "일부 파라미터가 없습니다.");
    }

    resp.setContentType("application/json; charset=UTF-8");
    var os = resp.getOutputStream();
    mapper.writeValue(os, jsonMap);
  }
}
