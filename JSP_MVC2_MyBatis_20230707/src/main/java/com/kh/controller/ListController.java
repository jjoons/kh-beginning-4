package com.kh.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kh.service.FreeboardService;
import com.kh.vo.FreeboardVO;

public class ListController implements Controller {
  @Override
  public String action(HttpServletRequest req, HttpServletResponse res) {
    FreeboardService service = FreeboardService.getInstance();
    List<FreeboardVO> list = service.getBoards();

    req.setAttribute("items", list);
    return "/list.jsp";
  }
}
