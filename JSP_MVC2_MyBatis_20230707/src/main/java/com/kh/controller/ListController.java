package com.kh.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kh.service.FreeboardService;
import com.kh.vo.FreeboardList;

public class ListController implements Controller {
  @Override
  public String action(HttpServletRequest req, HttpServletResponse res) {
    FreeboardService service = FreeboardService.getInstance();

    String pageStr = req.getParameter("currentPage");
    String limitStr = req.getParameter("limit");
    int page = 1;
    int limit = 10;

    try {
      page = Integer.parseInt(pageStr);
      page = Integer.parseInt(limitStr);
    } catch (NumberFormatException e) {
      System.err.println(e);
    }

    FreeboardList list = service.getBoards(limit, page);

    req.setAttribute("boardList", list);
    return "/list_solution.jsp";
  }
}
