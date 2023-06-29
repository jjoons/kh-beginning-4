package _02_practice;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/practice/Test03")
public class Test03 extends HttpServlet {
  // 1. 기존에 가입한 id와 pw를 비교한 결과를 03_basicView로 단순히 결과만 출력한다
  // 2. if문으로 결과를 비교해서 로그인 성공 또는 실패 만들기
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setCharacterEncoding("utf-8");
    super.service(req, resp);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setStatus(400);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String dbId = req.getParameter("dbId");
    String dbPw = req.getParameter("dbPw");

    String id = req.getParameter("id");
    String pw = req.getParameter("pw");

    req.setAttribute("result", (id.equals(dbId) && pw.equals(dbPw)) ? "로그인 성공" : "로그인 실패");

    RequestDispatcher rd = req.getRequestDispatcher("03_basicView.jsp");
    rd.forward(req, resp);
  }
}
