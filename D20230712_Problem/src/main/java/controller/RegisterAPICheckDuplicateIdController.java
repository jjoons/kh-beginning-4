package controller;

import java.io.IOException;
import java.io.OutputStream;
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

@WebServlet("/register_api/check_duplicate_id")
public class RegisterAPICheckDuplicateIdController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    Map<String, Object> jsonMap = new HashMap<>();
    jsonMap.put("isAvailable", false);

    String id = req.getHeader("X-ID");

    int result = AccountService.checkValidId(id);

    if (result == ServiceResponseCode.ID_VALID.value()) {
      jsonMap.replace("isAvailable", true);
    } else {
      resp.setStatus(400);
      String message = ServiceResponseCode.getMessageByValue(result);
      jsonMap.put("message", message);
    }

    resp.setContentType("application/json; charset=UTF-8");

    try {
      OutputStream os = resp.getOutputStream();
      mapper.writeValue(os, jsonMap);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setCharacterEncoding("utf-8");
    super.service(req, resp);
  }
}
