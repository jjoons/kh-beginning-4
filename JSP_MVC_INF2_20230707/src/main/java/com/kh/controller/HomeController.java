package com.kh.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.nhn")
public class HomeController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    this.actionDo(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    this.actionDo(req, resp);
  }

  protected void actionDo(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    // 받을 때
    req.setCharacterEncoding("utf-8");

    // 보낼 때
    resp.setContentType("text/html; charset=UTF-8");

    // getRequestURI() 메소드로 주소창에 요청된 컨텍스트 패스와 요청을 받는다
    String url = req.getRequestURI();
    System.out.println(url);

    // getContextPath() 메소드로 주소창에 요청한 컨텍스트 패스만 담는다
    String contextPath = req.getContextPath();
    System.out.println(contextPath);

    // 주소창에 입력된 컨텍스트 패스 뒤의 요청만 얻어온다
    // 지정된 숫자 다음부터 끝까지 문자열을 잘라서 가지고 온다
    String context = url.substring(contextPath.length() + 1, url.length() - 4);
    System.out.println("context: " + context);

    // 파일명만 가져와서

    // 요청 페이지에 따라서 view 페이지만 결정한다
    String viewPage = "/WEB-INF/";

    switch (context) {
      case "home":
        // /WEB-INF/home
        viewPage += "home";
        break;

      case "index":
        viewPage += "index"; // "/WEB-INF/" + "index" => "/WEB-INF/index"
        break;

      default:
        break;
    }

    // 확장자를 붙이는 작업
    //   /WEB-INF/home.jsp
    viewPage += ".jsp";
    System.out.println(viewPage);

    // 요청에 따른 페이지를 호출한다
    RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
    dispatcher.forward(req, resp);
  }
}
