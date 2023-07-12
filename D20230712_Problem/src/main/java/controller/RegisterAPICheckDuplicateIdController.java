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
import dao.AccountDAO;

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

    if (id != null && !id.isEmpty()) {
      int result = AccountDAO.getInstance().checkDuplicateId(id);

      if (result == 0) {
        jsonMap.replace("isAvailable", true);
      } else if (result > 0) {
        resp.setStatus(409);
        jsonMap.put("message", "이미 사용 중인 아이디입니다.");
      } else {
        resp.setStatus(500);
        jsonMap.put("message", "내부 서버 오류입니다.");
      }
    } else {
      resp.setStatus(400);
      jsonMap.put("message", "Header가 없습니다.");
    }

    resp.setContentType("application/json; charset=UTF-8");
    OutputStream os = resp.getOutputStream();
    mapper.writeValue(os, jsonMap);
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setCharacterEncoding("utf-8");
    super.service(req, resp);
  }
}
