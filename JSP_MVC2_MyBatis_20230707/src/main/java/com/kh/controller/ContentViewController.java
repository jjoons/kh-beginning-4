package com.kh.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kh.service.FreeboardService;
import com.kh.vo.FreeboardVO;

public class ContentViewController implements Controller {
  @Override
  public String action(HttpServletRequest req, HttpServletResponse res) {
    String idStr = req.getParameter("id");
    int id = 0;

    try {
      id = Integer.parseInt(idStr);
    } catch (NumberFormatException e) {
      System.err.println(e);
    }

    FreeboardVO vo = FreeboardService.getInstance().getBoard(id);
    req.setAttribute("vo", vo);

    return "/contentView.jsp";
  }
}
