package com.kh.controller;

import java.util.LinkedHashMap;
import java.util.Map;

public class ControllerMap {
  public static Map<String, Controller> getList() {
    Map<String, Controller> map = new LinkedHashMap<>();

    map.put("/content_view", new ContentViewController());
    map.put("/list", new ListController());

    return map;
  }
}
