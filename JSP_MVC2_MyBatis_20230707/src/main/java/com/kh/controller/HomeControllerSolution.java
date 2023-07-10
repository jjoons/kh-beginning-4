package com.kh.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.nhn")
public class HomeControllerSolution extends HttpServlet {

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

  public void actionDo(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    // 한글 깨짐 방지

    // 요청을 받는다. 
    // getRequestURI()
    // subString() viewpage의 경로를 만든다. 

    // switch문을 이용해서 insert.jsp에서 테이블에 저장할 데이터를 입력하고 
    // submit 버튼을 클릭하면 폼에 입력한 정보가 컨트롤러의 dopost() 메서드 
    // httpServletRequest 인터페이스 타입의 객체인 request에 저장된다. 

    // 모든 url요청을 먼저 controller 다 ~ 받는다. 
    // 데이터베이스 요청 service 메서드를 호출
    // service 데이터베이스에 접근하기 위해서 정보를 만든다. 
    // sqlsession 매퍼라는 정보를 만든다. 
    // 실제 데이터베이스에 접근을 할 수 있는 DAO 호출 
    // 결과값을 돌려준다. 


    // 컨트롤러에 increment.nhn
    // 이라는 요청이 들어오면 컨트롤러에서 호출하는 메서드로 조회수를 증가시킬 
    // 글 번호를 넘겨받고 mapper를 얻어온 후 MvcboardDAO클래스의 update sql
    // 명령문을 실행하는 메서드를 호출하는 메서드 


    //      컨트롤러에 contentView.nhn 이라는 요청이 들어오면 컨트롤러에서 호출하는 메소드로 조회수를 증가시킨
    //      글번호를 넘겨받고 mapper를 얻어온 후 MvcboardDAO 클래스의 select sql 명령을 실행하는 메소드를
    //      실행하고 얻어온 조회수를 증가시킨 글 1건을 request 영역에 저장하는 메소드


    //      컨트롤러에 delete.nhn 이라는 요청이 들어오면 컨트롤러에서 호출하는 메소드로 삭제할 글번호를
    //      넘겨받고 mapper를 얻어온 후 MvcboardDAO 클래스의 delete sql 명령을 실행하는 메소드를 실행하는 메소드


    //      컨트롤러에 replyInsert.nhn 이라는 요청이 들어오면 컨트롤러에서 호출하는 메소드로 답글 정보를
    //      넘겨받고 mapper를 얻어온 후 MvcboardDAO 클래스의 조건에 만족하는 seq를 1씩 증가시키는 update sql 명령을
    //      실행하고 답글을 저장하는 메소드를 실행하는 메소드 

    System.out.println("HomeController 클래스의 actionDo() 메소드");

    // 한글 깨짐 방지
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");

    // 요청을 받는다.
    String url = request.getRequestURI();
    String contextPath = request.getContextPath();
    String context = url.substring(contextPath.length());
    // System.out.println(context);

    // 요청받은 viewpage의 경로를 만든다.
    String viewpage = "/WEB-INF/";
    switch (context) {
      case "/insert.nhn":
        viewpage += "insert";
        break;
      case "/insertOK.nhn":

        // insert.jsp에서 테이블에 저장할 데이터를 입력하고 submit 버튼을 클릭하면 폼에 입력한 정보가
        // 컨트롤러의 doPost() 메소드의 HttpServletRequest 인터페이스 타입의 객체인 request에 저장된다.
        // doPost() 메소드는 request 객체에 저장된 데이터를 가지고 actionDo() 메소드를 실행하므로
        // insert.jsp에서 폼에 입력한 데이터는 actionDo() 메소드의 request객체에 저장된다.
        service.insert(request, response);

        viewpage += "index";
        break;
      case "/list.nhn":

        // 브라우저에 출력할 1페이지 분량의 글과 페이징 작업에 사용할 8개의 변수가 저장된 클래스 객체를
        // 얻어오는 메소드를 호출한다.
        service.selectList(request, response);

        viewpage += "list";
        break;
      case "/increment.nhn":

        // 조회수를 증가시키는 메소드를 호출한다.
        service.increment(request, response);

        viewpage += "increment";
        break;
      case "/contentView.nhn":

        // 조회수를 증가시킨 글 1건을 얻어오는 메소드를 호출한다.
        service.selectByIdx(request, response);

        viewpage += "contentView";
        break;
      case "/update.nhn":

        // 글 1건을 수정하는 메소드를 호출한다.
        service.update(request, response);

        viewpage += "goList";
        break;
      case "/delete.nhn":

        // 글 1건을 삭제하는 메소드를 호출한다.
        service.delete(request, response);

        viewpage += "goList";
        break;
      case "/reply.nhn":

        // 답글을 입력하는 페이지에 질문글을 출력하기 위해서 질문글 1건을 얻어와서 답글을
        // 입력하는 페이지로 넘겨준다.
        service.selectByIdx(request, response);

        viewpage += "reply";
        break;
      case "/replyInsert.nhn":

        // 답글이 브라우저에 표시될 위치를 정하기 위해서 조건에 만족하는 seq 값을 1씩
        // 증가시킨 후 답글을 저장하는 메소드를 호출한다.
        service.replyInsert(request, response);

        viewpage += "goList";
        break;
    }
    viewpage += ".jsp";

    // 요청받은 페이지로 넘긴다.
    RequestDispatcher dispatcher = request.getRequestDispatcher(viewpage);
    dispatcher.forward(request, response);

  }
}
