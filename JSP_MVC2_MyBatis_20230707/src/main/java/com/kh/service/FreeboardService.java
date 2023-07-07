package com.kh.service;

public class FreeboardService {
  private static FreeboardService instance = null;

  private FreeboardService() {}

  public static FreeboardService getInstance() {
    if (instance == null) {
      instance = new FreeboardService();
    }

    return instance;
  }
}
