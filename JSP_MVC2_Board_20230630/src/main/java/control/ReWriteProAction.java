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

@WebServlet("/ReWriteProAction")
public class ReWriteProAction extends HttpServlet {
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    super.service(req, resp);
    req.setCharacterEncoding("utf-8");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    super.doPost(req, resp);
  }

  protected void reqPro(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    BoardBean bean = new BoardBean();

    bean.setWriter(req.getParameter("writer"));
    bean.setSubject(req.getParameter("subject"));
    bean.setEmail(req.getParameter("email"));
    bean.setPassword(req.getParameter("password"));
    bean.setContent(req.getParameter("content"));

    // 댓글에 관한 변수들을 추가해야한다
    // 현재 게시글의 정보를 가지고 온다 reWriteAction
    // 현재 선택된 게시글의 정보를 가지고 04 파일로 갔다가 거기서 답글 완료를 누르면
    // pro로 와서 거기에 새로운 내용으로 객체를 생성해서 데이터베이스에 업데이트한다
    bean.setRef(Integer.parseInt(req.getParameter("ref")));
    bean.setRe_step(Integer.parseInt(req.getParameter("re_step")));
    bean.setRe_level(Integer.parseInt(req.getParameter("re_level")));

    BoardDAO boardDAO = BoardDAO.getInstance();
    boardDAO.updateBoard(bean);

    RequestDispatcher dis = req.getRequestDispatcher("BoardListAction");
    dis.forward(req, resp);
  }
}
