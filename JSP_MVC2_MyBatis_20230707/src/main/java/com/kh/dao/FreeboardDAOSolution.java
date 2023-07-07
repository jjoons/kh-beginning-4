package com.kh.dao;

public class FreeboardDAOSolution {
  private static FreeboardDAOSolution instance = null;

  private FreeboardDAOSolution() {}

  public static FreeboardDAOSolution getInstance() {
    if (instance == null) {
      instance = new FreeboardDAOSolution();
    }

    return instance;
  }
}
