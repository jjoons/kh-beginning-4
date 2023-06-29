package _02_practice;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/practice/Test01")
public class Test01 extends HttpServlet {
  private static final long serialVersionUID = -3309080696997698902L;

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setCharacterEncoding("utf-8");
    super.service(req, resp);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    // this.reqPro(req, resp);

    RequestDispatcher rd = req.getRequestDispatcher("01_basic.jsp");
    rd.forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    int korScore = 0;
    int mathScore = 0;
    int engScore = 0;
    double avgScore = 0;
    String resultMsg = null;
    boolean result = false;

    String korScoreStr = req.getParameter("korScore");
    String mathScoreStr = req.getParameter("mathScore");
    String engScoreStr = req.getParameter("engScore");

    try {
      korScore = Integer.parseInt(korScoreStr);
      mathScore = Integer.parseInt(mathScoreStr);
      engScore = Integer.parseInt(engScoreStr);

      avgScore = (korScore + mathScore + engScore) / 3;
      result = avgScore >= 70;
      resultMsg = result ? "합격" : "불합격";
    } catch (NumberFormatException e) {
      resultMsg = "숫자만 입력할 수 있습니다.";
    }

    req.setAttribute("korScore", korScore);
    req.setAttribute("mathScore", mathScore);
    req.setAttribute("engScore", engScore);
    req.setAttribute("avgScore", avgScore);
    req.setAttribute("result", result);
    req.setAttribute("resultMsg", resultMsg);

    RequestDispatcher rd = req.getRequestDispatcher("01_basicView.jsp");
    rd.forward(req, resp);
  }

  public void reqPro(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    // 1. 국영수 입력 (국어, 영어, 수학)
    // 2. 평균 70점 이상이면 합격, 미만이면 불합격 저장
    // 3. 각각 저장해야하는 내용들을 내장 객체인 변수들에 저장
    // 4. 01_basicView에 출력되게 하기
  }
}
