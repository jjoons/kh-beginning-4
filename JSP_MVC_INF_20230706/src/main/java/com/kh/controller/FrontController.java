package com.kh.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet 어노테이션에 특정 요청을 써 주면 그 요청이 들어왔을 때
// 컨트롤러의 메소드가 자동으로 실행됨

// @WebServlet 어노테이션에 특정 요청 해당 컨트롤러의 메소드가 실행되므로
// 요청할 때마다 컨트롤러를 일일히 만들어야하는 문제점(?)이 발생한다

// @WebServlet 어노테이션에 와일드카드 문자(*)를 사용하는 확장명 패턴의 요청을 받을 수 있다
// 확장명 패턴 방식으로 요청을 받을 때만! 앞에 "/"를 붙이지 않는다

@WebServlet("*.do")
public class FrontController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public FrontController() {
    super();
    System.out.println("new FrontController()");
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
    System.out.println("FrontController().doGet()");
    String viewPage = "/WEB-INF/index.jsp";

    req.getRequestDispatcher(viewPage).forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    super.doPost(req, resp);
  }
}
