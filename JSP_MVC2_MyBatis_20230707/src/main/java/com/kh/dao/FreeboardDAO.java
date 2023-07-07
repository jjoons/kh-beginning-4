package com.kh.dao;

public class FreeboardDAO {
  private static FreeboardDAO instance = null;

  private FreeboardDAO() {}

  public static FreeboardDAO getInstance() {
    if (instance == null) {
      instance = new FreeboardDAO();
    }

    return instance;
  }
}
