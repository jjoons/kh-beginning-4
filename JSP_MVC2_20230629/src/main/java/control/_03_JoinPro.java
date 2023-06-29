package control;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/joinPro.do")
public class _03_JoinPro extends HttpServlet {
  private static final long serialVersionUID = -6147014770938762275L;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    this.reqPro(req, resp);
  }

  protected void reqPro(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setCharacterEncoding("utf-8");

    // form에서 보내온 정보 꺼내기
    // MemberBean 생성해서 멤버들을 관리하는 DAO

    RequestDispatcher dis = req.getRequestDispatcher("03_joinView.jsp");
    dis.forward(req, resp);
  }
}
