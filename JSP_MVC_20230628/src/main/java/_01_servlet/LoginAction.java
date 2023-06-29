package _01_servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginAction")
public class LoginAction extends HttpServlet {
  private static final long serialVersionUID = 4207030638545412301L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    super.doGet(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    this.reqPro(req, resp);
  }

  protected void reqPro(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException {
    // 실제 처리하는 메소드가 된다
    String id = req.getParameter("id");
    String pw = req.getParameter("pw");

    req.setAttribute("id", id);
    req.setAttribute("pw", pw);

    // 로그인을 유지하기 위해서 웹 브라우저에서만 사용할 수 있도록 session에 저장
    RequestDispatcher dis = req.getRequestDispatcher("servlet/02_loginView.jsp");
    dis.forward(req, res);
  }
}
