package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// 하나의 서블릿에 매칭으로 여러 개 배열로 선언
// @WebServlet(urlPatterns = {"main", "test", "join"})
// @WebServlet(urlPattern = "/first")
@WebServlet("/Login")
public class Login extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    this.doPost(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String id = req.getParameter("id");
    String pw = req.getParameter("pw");

    req.setAttribute("id", id);
    req.setAttribute("pw", pw);

    req.getRequestDispatcher("LoginView.jsp").forward(req, resp);
  }

  // 서블릿 초기화하는 메소드 오버라이딩
  @Override
  public void init() throws ServletException {
    System.out.println("서블릿 초기화");
  }

  // 서블릿은 main 함수가 없다. 그래서 메인 함수 대신 service 함수가 main 함수의 역할을 한다
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    super.service(req, resp);
    req.setCharacterEncoding("utf-8");
  }
}
