package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.MemberDAO;

@WebServlet("/delete.do")
public class _09_Delete extends HttpServlet {
  private static final long serialVersionUID = 2602494441872613808L;

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

    String id = (String) session.getAttribute("memId");

    if (id != null) {
      MemberDAO mDao = MemberDAO.getInstance();
      boolean result = mDao.delete(id);
      req.setAttribute("result", result);
      session.invalidate();
    }

    req.getRequestDispatcher("09_deletePro.jsp").forward(req, resp);
  }
}
