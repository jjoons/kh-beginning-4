package com.kh.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet("/AjaxInsert")
public class AjaxInsertSolution extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    actionDo(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    actionDo(req, resp);
  }

  protected void actionDo(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("AjaxSearch서블릿의 actionDo() 메서드 실행 ");

    req.setCharacterEncoding("UTF-8");
    resp.setContentType("text/html; charset=UTF-8");

    // insert.jsp에서 입력한 데이터가 ajax를 통해서 넘어오는 데이터를 받는다
    String name = req.getParameter("name").trim();
    int age = Integer.parseInt(req.getParameter("age").trim());

    String gender = req.getParameter("gender");
    String email = req.getParameter("email").trim();

    // 넘겨받은 데이터를 AjaxDTO 객체에 저장한다
    AjaxDTO vo = AjaxDTO.builder().name(name).age(age).gender(gender).email(email).build();

    // 넘겨받은 데이터를 테이블에 저장하는 메소드를 실행한다
    int result = AjaxDAO.getInstance().insert(vo);
  }
}