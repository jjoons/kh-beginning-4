package _01_servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 브라우저 주소창의 contextPath("/프로젝트명") 뒤에 @WebServlet 어노테이션에서
// 인수로 지정된 요청이 GET 방식으로 들어오면 doGet() 메소드가 자동으로 실행된다
//   POST 방식으로 요청이 들어오면 doPost() 메소드가 자동으로 실행된다

// @WebServlet("/HomeController") -> MVC 2에서 Controller
@WebServlet("/JoinAction")
public class JoinAction extends HttpServlet {
  // GET 메소드로 컨트롤러에 요청이 들어올 때 자동으로 실행되는 메소드
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

  }

  // POST 메소드로 컨트롤러에 요청이 들어올 때 자동으로 실행되는 메소드
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    this.reqPro(req, resp);
  }

  // 실제 처리하는 메소드를 작성해서 호출
  protected void reqPro(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException {
    req.setCharacterEncoding("utf-8");

    String id = req.getParameter("id");
    String pw = req.getParameter("pw");
    String name = req.getParameter("name");
    String email = req.getParameter("email");

    // 취미
    String[] arr = req.getParameterValues("hobby");
    String hobby = "";

    for (int i = 0; i < arr.length; i++) {
      hobby += arr[i];

      if (i != arr.length - 1) {
        hobby += ",";
      }
    }

    MemberBean bean = new MemberBean(id, pw, name, email, hobby);

    // Request 객체를 통해 JSP 페이지로 전달할 데이터 저장
    // 01_joinView.jsp 로 저장해서 보낸다
    req.setAttribute("bean", bean);

    // RequestDispatcher 인터페이스 객체를 이용해서 요청
    // 브라우저에 표시하기 위해 준비한다

    // forward()
    RequestDispatcher dis = req.getRequestDispatcher("/servlet/01_joinView.jsp");
    dis.forward(req, res);
  }

  // init() 메소드로 초기화 진행을 해야한다
  @Override
  public void init() throws ServletException {
    System.out.println("서블릿 초기화");
  }

  // destroy()
  @Override
  public void destroy() {
    System.out.println("서블릿 제거");
  }
}
