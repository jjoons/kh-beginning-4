package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BoardDAO;
import model.BoardBean;

@WebServlet("/InfoAction")
public class InfoAction extends HttpServlet {
  private static final long serialVersionUID = 121666636999165320L;

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    super.service(req, resp);
    req.setCharacterEncoding("utf-8");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String numStr = req.getParameter("page");
    int num = 0;

    try {
      num = numStr != null ? Integer.parseInt(numStr) : 1;
    } catch (NumberFormatException e) {
      e.printStackTrace();
      num = 0;
    }

    BoardDAO dao = BoardDAO.getInstance();
    dao.increaseReadCount(num);
    BoardBean bean = dao.getBoard(num);

    req.setAttribute("num", bean.getNum());
    req.setAttribute("readcount", bean.getReadcount());
    req.setAttribute("writer", bean.getWriter());
    req.setAttribute("reg_date", bean.getReg_date());
    req.setAttribute("email", bean.getEmail());
    req.setAttribute("subject", bean.getSubject());
    req.setAttribute("content", bean.getContent());

    req.getRequestDispatcher("WEB-INF/03_boardInfo.jsp").forward(req, resp);
  }
}
