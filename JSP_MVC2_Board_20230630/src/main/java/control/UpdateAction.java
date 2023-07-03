package control;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BoardBean;
import model.BoardDAO;

//@WebServlet("/UpdateAction")
public class UpdateAction extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    this.reqPro(req, resp);
  }

  protected void reqPro(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    // 수정할 때 변경되는 num 값 가져오기
    int num = Integer.parseInt(req.getParameter("num"));

    BoardDAO bDao = BoardDAO.getInstance();
    BoardBean bean = bDao.getBoard(num);

    req.setAttribute("bean", bean);

    RequestDispatcher dis = req.getRequestDispatcher("05_boardUpdate.jsp");
    dis.forward(req, resp);
  }
}
