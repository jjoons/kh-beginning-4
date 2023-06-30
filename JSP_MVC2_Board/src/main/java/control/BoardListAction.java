package control;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BeanDAO;
import model.BoardBean;

@WebServlet("/board_list")
public class BoardListAction extends HttpServlet {
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
    String pageStr = req.getParameter("page");
    int page = 0;
    int count = 10;

    try {
      page = pageStr != null ? Integer.parseInt(pageStr) : 1;
    } catch (NumberFormatException e) {
      e.printStackTrace();
      count = 0;
    }

    BeanDAO dao = BeanDAO.getInstance();
    List<BoardBean> list = dao.getBoards(count, page);

    req.setAttribute("boardList", list);

    req.getRequestDispatcher("board_list.jsp").forward(req, resp);
  }
}
