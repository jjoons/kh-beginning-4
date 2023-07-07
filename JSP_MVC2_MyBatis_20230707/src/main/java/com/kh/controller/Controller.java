package com.kh.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
  public String action(HttpServletRequest req, HttpServletResponse res);
}
