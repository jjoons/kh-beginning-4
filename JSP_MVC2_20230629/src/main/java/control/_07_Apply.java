package control;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.MemberBean;
import model.MemberDAO;

// 서블릿 URL apply.do
// 멤버 아이디를 가지고 세션에서 꺼내와서
// DAO 데이터베이스에 처리하는 기능을 만든다 getOneMember()
// 결과값을 가지고 오고 가져온 결과를 이용해 MemberBean 객체를 생성해서
// 그 결과를 07

@WebServlet("/apply.do")
public class _07_Apply extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    RequestDispatcher dis = req.getRequestDispatcher("07_apply.jsp");
    dis.forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();
    String id = (String) session.getAttribute("memId");

    if (id != null) {
      // 1. 아이디 값을 이용해서 데이터베이스에서 찾아서 결과 저장
      MemberDAO mDao = MemberDAO.getInstance();
      MemberBean bean = mDao.getOneMember(id);

      String tel = bean.getTel();
      String[] arr = tel.split("-");

      req.setAttribute("tel1", arr[0]);
      req.setAttribute("tel2", arr[1]);
      req.setAttribute("tel3", arr[2]);
      req.setAttribute("bean", bean);
    }

    RequestDispatcher dis = req.getRequestDispatcher("07_apply.jsp");
    dis.forward(req, resp);
  }
}
