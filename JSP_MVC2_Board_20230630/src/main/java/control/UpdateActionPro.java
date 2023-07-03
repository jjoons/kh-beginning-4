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

@WebServlet("/UpdateActionPro")
public class UpdateActionPro extends HttpServlet {
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    super.service(req, resp);
    req.setCharacterEncoding("utf-8");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    this.reqPro(req, resp);
  }

  protected void reqPro(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    BoardBean bean = new BoardBean();

    bean.setNum(Integer.parseInt(req.getParameter("num")));
    bean.setWriter(req.getParameter("writer"));
    bean.setSubject(req.getParameter("subject"));
    bean.setEmail(req.getParameter("email"));
    bean.setPassword(req.getParameter("password"));
    bean.setContent(req.getParameter("content"));

    BoardDAO boardDAO = BoardDAO.getInstance();
    boardDAO.updateBoard(bean);

    RequestDispatcher dis = req.getRequestDispatcher("");
    dis.forward(req, resp);
  }
}
