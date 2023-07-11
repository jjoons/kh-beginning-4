package com.kh.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// AjaxInsert, AjaxSearch
// 서블릿을 사용할 수 있게 세팅하기
// 보낼 때 받을 때 한글 깨짐 해결하기
// index.jsp 에서 입력한 데이터가 ajax 통해서 넘어오는 데이터를 받는다

@WebServlet("/insert_api")
public class AjaxInsert extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setCharacterEncoding("utf-8");
    super.service(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    boolean success = false;

    String name = req.getParameter("name");
    String ageStr = req.getParameter("age");
    String gender = req.getParameter("gender");
    String email = req.getParameter("email");

    int age = -1;

    try {
      age = Integer.parseInt(ageStr);
    } catch (NumberFormatException e) {}

    if (name != null && age > -1 && gender != null && email != null) {
      AjaxDTO dto = AjaxDTO.builder().name(name).age(age).gender(gender).email(email).build();
      int result = AjaxDAO.getInstance().insert(dto);

      if (result > 0) {
        success = true;
      }
    }

    req.setAttribute("success", success);
    req.getRequestDispatcher("WEB-INF/api/insert.jsp").forward(req, resp);
  }
}
