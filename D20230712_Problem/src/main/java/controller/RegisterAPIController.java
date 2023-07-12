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

    AccountDTO dto = this.getAccountDTO(id, password, password_re, name, age, gender, email);

    if (dto != null) {
      int result = AccountDAO.getInstance().insertAccount(dto);

      if (result > 0) {
        jsonMap.replace("success", true);
      } else {
        resp.setStatus(409);
        jsonMap.put("message", "오류가 발생했습니다.");
        System.out.println("RegisterAPIController");
        System.out.println(dto);
      }
    } else {
      resp.setStatus(400);
      jsonMap.put("message", "일부 파라미터가 없거나 값이 올바르지 않습니다.");
    }

    resp.setContentType("application/json; charset=UTF-8");
    Writer writer = resp.getWriter();
    mapper.writeValue(writer, jsonMap);
  }

  private AccountDTO getAccountDTO(String id, String password, String password_re, String name,
      int age, String gender, String email) {
    if (id != null && !id.isEmpty() && id.matches("[a-zA-Z0-9]{1,20}")
        && AccountDAO.getInstance().checkDuplicateId(id) == 0 && password != null
        && !password.isEmpty() && password_re != null && !password_re.isEmpty()
        && password.equals(password_re) && name != null && !name.isEmpty() && age > -1
        && gender != null && !gender.isEmpty() && email != null && !email.isEmpty()) {
      return AccountDTO.builder().id(id).password(password).name(name).age(age).gender(gender)
          .email(email).build();
    }

    return null;
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setCharacterEncoding("utf-8");
    super.service(req, resp);
  }
}
