package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.SelectService;

@WebServlet("/info")
public class InfoController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    super.service(req, resp);
    req.setCharacterEncoding("utf-8");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();

    var id = (String) session.getAttribute("id");
    var dto = SelectService.getInstance().getUserById(id);

    if (dto != null) {
      req.setAttribute("dto", dto);
      req.getRequestDispatcher("WEB-INF/view/info.jsp").forward(req, resp);
    } else {
      try {
        resp.sendRedirect("home");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
