package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.MemberDAO;

// URL: applyPro.do

// 1. form으로 넘어온 데이터를 DAO에 보내서 데이터베이스에 저장되게 하기
// 2. 08_applyView.jsp 로 넘긴다

@WebServlet("/applyPro.do")
public class _08_ApplyPro extends HttpServlet {
  private static final long serialVersionUID = -6245156776049018659L;

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    super.service(req, resp);
    req.setCharacterEncoding("utf-8");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();
    String id = (String) session.getAttribute("memId");

    // 추가적으로 입력하는 정보들만 꺼내온다. 폼 태그에서 받은 객체 안에서
    String field = req.getParameter("field");
    String major = req.getParameter("major");

    // 각각의 체크 내용을 문자열로 연결해서 한꺼번에 저장
    String[] skill = req.getParameterValues("skill");
    String skill2 = "";

    for (int i = 0; i < skill.length; i++) {
      skill2 += skill[i];
      if (i != skill.length - 1) {
        skill2 += ",";
      }
    }

    MemberDAO mDao = MemberDAO.getInstance();
    mDao.apply(id, field, skill2, major);

    req.getRequestDispatcher("08_applyView.jsp").forward(req, resp);
  }
}
