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

@WebServlet("")
public class _11_UpdatePro extends HttpServlet {
  private static final long serialVersionUID = 3504336377282447898L;

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
    String id = (String) session.getAttribute("id");

    String name = req.getParameter("name");
    String pw = req.getParameter("pw");
    String tel1 = req.getParameter("tel1");
    String tel2 = req.getParameter("tel2");
    String tel3 = req.getParameter("tel3");

    String tel = String.format("%s-%s-%s", tel1, tel2, tel3);

    String email = req.getParameter("email");
    String field = req.getParameter("field");
    String[] skills = req.getParameterValues("skill");
    String skill = "";

    for (int i = 0; i < skills.length; i++) {
      skill += skills[i] + (i >= skills.length - 1 ? "" : ",");
    }

    String major = req.getParameter("major");

    MemberDAO mDao = MemberDAO.getInstance();
    MemberBean bean = new MemberBean(id, pw, name, tel, email, field, skill, major);
    boolean result = mDao.updateMember(id, bean);

    req.setAttribute("result", result);

    req.getRequestDispatcher("11_updateView.jsp").forward(req, resp);
  }
}
