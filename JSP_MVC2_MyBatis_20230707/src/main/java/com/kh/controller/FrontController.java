package com.kh.controller;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private String urlPrefix = "/JSP_MVC2_MyBatis_20230707";
  private String extensionName = ".do";
  private Map<String, Controller> list = ControllerMap.getList();

  protected void doAction(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String url = req.getRequestURI();
    String contextPath = req.getContextPath();

    if (contextPath.equals(urlPrefix)) {
      String browserUrl =
          url.substring(contextPath.length(), url.length() - extensionName.length());
      Controller con = list.get(browserUrl);

      if (con != null) {
        String actionUrl = con.action(req, resp);
        req.getRequestDispatcher("WEB-INF/view" + actionUrl).forward(req, resp);
      } else {
        this.doDefault(req, resp);
      }
    } else {
      this.doDefault(req, resp);
    }
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setCharacterEncoding("utf-8");
    super.service(req, resp);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    this.doAction(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    this.doAction(req, resp);
  }

  private void doDefault(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    switch (req.getMethod()) {
      case "GET":
        super.doGet(req, resp);
        break;
      case "POST":
        super.doPost(req, resp);
        break;
    }
  }
}
