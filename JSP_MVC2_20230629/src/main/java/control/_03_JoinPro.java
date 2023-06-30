package control;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MemberBean;
import model.MemberDAO;

@WebServlet("/joinPro.do")
public class _03_JoinPro extends HttpServlet {
  private static final long serialVersionUID = -6147014770938762275L;

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    super.service(req, resp);
    req.setCharacterEncoding("utf-8");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setStatus(405);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    this.reqPro(req, resp);
  }

  protected void reqPro(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    // form에서 보내온 정보 꺼내기
    // MemberBean 생성해서 멤버들을 관리하는 DAO
    boolean result = false;

    String id = req.getParameter("id");
    String pw = req.getParameter("pw");
    String name = req.getParameter("name");
    String tel1 = req.getParameter("tel1");
    String tel2 = req.getParameter("tel2");
    String tel3 = req.getParameter("tel3");
    String email = req.getParameter("email");

    MemberDAO dao = MemberDAO.getInstance();
    MemberBean bean = new MemberBean();
    bean.setId(id);
    bean.setPw(pw);
    bean.setName(name);
    bean.setTel(tel1 + "-" + tel2 + "-" + tel3);
    bean.setEmail(email);

    dao.register(bean);

    RequestDispatcher dis = req.getRequestDispatcher("03_joinView.jsp");
    dis.forward(req, resp);
  }
}
