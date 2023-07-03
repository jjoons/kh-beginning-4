package control;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BoardBean;
import model.BoardDAO;

@WebServlet("/ReWriteAction")
public class ReWriteAction extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    super.doGet(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    super.doPost(req, resp);
  }

  protected void reqPro(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    int num = Integer.parseInt(req.getParameter("num"));

    BoardDAO dao = BoardDAO.getInstance();
    BoardBean bean = dao.getBoard(num);

    // 현재 글 번호로 댓글 그룹의 번호로 지정한다
    int ref = bean.getRef();
    int re_step = bean.getRe_step();
    int re_level = bean.getRe_level();

    //    System.out.println("Ref: " + ref);
    req.setAttribute("ref", ref);
    req.setAttribute("re_step", re_step);
    req.setAttribute("re_level", re_level);

    RequestDispatcher dis = req.getRequestDispatcher("04_reWrite.jsp");
    dis.forward(req, resp);
  }
}
