package com.kh.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kh.service.FreeboardService;

public class AddDummyController implements Controller {
  @Override
  public String action(HttpServletRequest req, HttpServletResponse res) {
    if (req.getMethod().equals("POST")) {
      boolean success = false;
      String countStr = req.getParameter("count");
      int count = 0;

      success = FreeboardService.getInstance().addDummy(0);

      req.setAttribute("success", success);

      return "/add_dummy_api.jsp";
    }

    return null;
  }
}
