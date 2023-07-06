package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.SelectService;

@WebServlet("/login")
public class LoginController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    super.service(req, resp);
    req.setCharacterEncoding("utf-8");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();
    //    Writer writer = resp.getWriter();

    String id = req.getParameter("id");
    String password = req.getParameter("password");

    boolean result = SelectService.getInstance().login(id, password);

    try {
      if (result) {
        session.setAttribute("id", id);
        resp.sendRedirect("info");
      } else {
        req.getRequestDispatcher("WEB-INF/view/fail.jsp").forward(req, resp);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
