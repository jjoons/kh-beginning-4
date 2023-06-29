package _02_practice;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/practice/Test02")
public class Test02 extends HttpServlet {
  // 1. 서블릿 만들기
  // 2. 넘어온 값 저장
  // 3. 저장 후 단순히 뷰로 넘기기만 한다
  // 4. 넘어온 데이터를 가지고 JSTL 문법으로 비교해서 결과값 출력하기

  // 가위바위보 조건
  //   가위는 졌다
  //   바위는 비겼다
  //   보는 이겼다

  private static final long serialVersionUID = -1252210368586601273L;

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
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
    Enumeration<String> enu = req.getParameterNames();

    while (enu.hasMoreElements()) {
      String paramName = enu.nextElement();
      req.setAttribute("att_" + paramName, req.getParameter(paramName));
    }

    RequestDispatcher dis = req.getRequestDispatcher("02_basicView.jsp");
    dis.forward(req, resp);
  }
}
