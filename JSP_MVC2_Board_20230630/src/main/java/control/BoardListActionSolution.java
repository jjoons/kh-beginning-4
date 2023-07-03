package control;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BoardBean;

//@WebServlet("")
public class BoardListActionSolution extends HttpServlet {
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    super.service(req, resp);
    req.setCharacterEncoding("utf-8");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    this.reqPro(req, resp);
  }

  public void reqPro(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    // 화면에 보여질 게시글의 개수
    int pageSize = 10;

    String pageNumber = req.getParameter("pageNum");

    if (pageNumber == null) {
      pageNumber = "1";
    }

    // 전체 게시글의 개수
    int count = 0;

    // JSP 페이지 내에서 보여질 숫자 값을 저장하는 변수 선언
    int number = 0;

    // 현재 보여지고 있는 페이지 문자를 숫자로 형변환
    int currentPage = Integer.parseInt(pageNumber);

    // 전체 게시글 개수를 가져와야 하기에 데이터베이스 객체 생성
    // BoardDAO 객체 안에서 연동, getAllCount()

    // 현재 보여질 페이지 시작 번호 지정
    int startRow = (currentPage - 1) * pageSize;

    // 최신글 10개 기준으로 게시글을 리턴받는 메소드 호출
    // DAO에서 getAllBoard() 메소드로 리턴받음. 매개변수 startRow, pageSize 
    ArrayList<BoardBean> list = null;

    // request 객체에 저장
    // 최신 게시글, number, pageSize, count, currentPage
    number = count - (currentPage - 1) * pageSize;

    // RequestDispatcher는 페이지 호출없이 JSP 파일 내에서 다른 파일 요청을 보애고 바로 응답받는다
    // req.setAttribute("v", list);

    // sendRedirect: 브라우저가 response에 따라 서버로 지정된 경로를 다시 요청해 페이지를 호출한다
    RequestDispatcher dis = req.getRequestDispatcher("02_boardList.jsp");
    dis.forward(req, resp);
  }
}
