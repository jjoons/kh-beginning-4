package com.kh.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public HomeController() {
    super();
    System.out.println("new HomeController()");
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    super.service(req, resp);
    req.setCharacterEncoding("utf-8");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("HomeController().doGet()");
    // WEB-INF 폴더 안에 JSP 파일의 경로를 쓸 때는 절대 경로
    // 기본 위치는 프로젝트명
    //   /WEB-INF/뷰페이지.jsp
    String viewPage = "/WEB-INF/home.jsp";

    req.getRequestDispatcher(viewPage).forward(req, resp);
  }
}
