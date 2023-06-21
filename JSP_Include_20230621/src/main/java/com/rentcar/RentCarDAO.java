package com.rentcar;

public class RentCarDAO {
  private static RentCarDAO instance = new RentCarDAO();

  private RentCarDAO() {}

  public static RentCarDAO getInstance() {
    return instance;
  }
}
