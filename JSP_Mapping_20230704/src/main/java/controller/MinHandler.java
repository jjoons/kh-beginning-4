package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MinService;

public class MinHandler implements CommandHandler {
  private MinService minService = new MinService();

  @Override
  public String handlerAction(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException {
    int result = 0;

    // 파라미터 값 가져오기
    //    req.getParameter("");
    String n1Str = req.getParameter("n1");
    String n2Str = req.getParameter("n2");

    int n1 = 0;
    int n2 = 0;

    // 더해서 처리하기
    try {
      n1 = Integer.parseInt(n1Str);
      n2 = Integer.parseInt(n2Str);
    } catch (NumberFormatException e) {
      System.err.println(e);
    }

    result = this.minService.minus(n1, n2);

    // 저장하는 공간이 필요하다
    // request에 저장해서 보낼 것
    req.setAttribute("result", result);


    return "/min.jsp";
  }
}
