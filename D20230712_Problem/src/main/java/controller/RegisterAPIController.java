package controller;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.AccountDAO;
import dto.AccountDTO;
import service.AccountService;
import service.ServiceResponseCode;

@WebServlet("/register_api")
public class RegisterAPIController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String id = req.getParameter("id");
    String password = req.getParameter("password");
    String password_re = req.getParameter("password_re");
    String name = req.getParameter("name");
    String ageStr = req.getParameter("age");
    String gender = req.getParameter("gender");
    String email = req.getParameter("email");
    int age = -1;

    Map<String, Object> jsonMap = new HashMap<>();
    jsonMap.put("success", false);

    ObjectMapper mapper = new ObjectMapper();

    try {
      age = Integer.parseInt(ageStr);
    } catch (NumberFormatException e) {}

    AccountDTO dto = AccountDTO.builder().id(id).password(password).name(name).age(age)
        .gender(gender).email(email).build();
    int validResult = AccountService.checkValidAccount(dto);

    if (validResult == ServiceResponseCode.ACCOUNT_VALID.value()) {
      validResult = AccountService.checkValidPassword(password, password_re);

      if (validResult == ServiceResponseCode.PASSWORD_VALID.value()) {
        int result = AccountDAO.getInstance().insertAccount(dto);

        if (result > 0) {
          jsonMap.replace("success", true);
        } else {
          resp.setStatus(409);
          String message = ServiceResponseCode.UNKNOWN_ERROR.message();
          jsonMap.put("message", message);

          System.out.println("RegisterAPIController");
          System.out.println(dto);
        }
      } else {
        resp.setStatus(400);
        String message = ServiceResponseCode.getMessageByValue(validResult);

        jsonMap.put("message", message);
      }
    } else {
      resp.setStatus(400);
      String message = ServiceResponseCode.getMessageByValue(validResult);

      jsonMap.put("message", message);
    }

    resp.setContentType("application/json; charset=UTF-8");
    Writer writer = resp.getWriter();
    mapper.writeValue(writer, jsonMap);
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setCharacterEncoding("utf-8");
    super.service(req, resp);
  }
}
