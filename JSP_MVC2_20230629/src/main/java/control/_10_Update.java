package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.MemberBean;
import model.MemberDAO;

@WebServlet("/update.do")
public class _10_Update extends HttpServlet {
  private static final long serialVersionUID = 9167286740702412460L;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();
    String id = (String) session.getAttribute("id");

    MemberDAO mDao = MemberDAO.getInstance();
    MemberBean bean = mDao.getOneMember(id);

    req.getRequestDispatcher("10_update.jsp").forward(req, resp);
  }
}
