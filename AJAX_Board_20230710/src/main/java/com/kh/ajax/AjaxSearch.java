package com.kh.ajax;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/search_api")
public class AjaxSearch extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setCharacterEncoding("utf-8");
    super.service(req, resp);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    boolean success = false;
    String s = req.getParameter("s");
    String message = null;

    if (s != null && !s.isEmpty()) {
      List<AjaxDTO> list = AjaxDAO.getInstance().search(s);

      ObjectMapper mapper = new ObjectMapper();
      String data = mapper.writeValueAsString(list);
      success = true;
      req.setAttribute("data", data);
    } else if (s == null) {
      req.setAttribute("message", "파라미터가 없습니다.");
    } else if (s.isEmpty()) {
      req.setAttribute("message", "검색어를 입력해 주세요.");
    }

    req.setAttribute("success", success);
    req.getRequestDispatcher("WEB-INF/api/search.jsp").forward(req, resp);
  }
}
