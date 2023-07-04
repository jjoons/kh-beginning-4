package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
  // 들어온 URL 주소가 /add 이거나 /min 일 때 처리하는 함수
  // 서블릿들의 내용을 저장해서 가지고 있어야 한다
  private Map<String, CommandHandler> commandHandlerMap = new HashMap<>();

  // 초기화할 때
  @Override
  public void init() throws ServletException {
    this.commandHandlerMap.put("/add", new AddHandler());
    this.commandHandlerMap.put("/min", new MinHandler());
    this.commandHandlerMap.put("/", (req, res) -> "/Login.jsp");
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("요청 분석");

    String requestURL = req.getRequestURI();
    System.out.println("요청 URL(req.getRequestURI()): " + requestURL);

    // req.getRequestURL(): 전체 경로
    // req.getServletPath(): 파일명
    // req.getRealPath(): 실제 프로젝트 폴더
    // req.getContextPath(): 프로젝트명

    System.out.println("req.getContextPath(): " + req.getContextPath());

    String command = requestURL.substring(req.getContextPath().length());
    System.out.println("command: " + command);

    // 경로를 찾아서 저장
    // 처리하면 어디에 보여줄지 저장하는 변수
    CommandHandler handler = null;
    String viewPage = null;

    if (requestURL.indexOf(req.getContextPath()) == 0) {
      handler = this.commandHandlerMap.get(command);
      viewPage = handler.handlerAction(req, resp);
      System.out.println("모델과 관련된 비지니스 로직 동작");
    }

    System.out.println("뷰 페이지로 포워딩");
    req.getRequestDispatcher(viewPage).forward(req, resp);
  }
}
