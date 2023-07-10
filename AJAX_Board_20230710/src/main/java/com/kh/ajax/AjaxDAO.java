package com.kh.ajax;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AjaxDAO {
  private static AjaxDAO instance = null;
  private Connection con = null;
  private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
  private String id = "kh";
  private String password = "KH";

  private AjaxDAO() {}

  public static AjaxDAO getInstance() {
    if (instance == null) {
      instance = new AjaxDAO();
    }

    return instance;
  }

  public Connection getConnection() {
    try {
      if (this.con == null || this.con.isClosed()) {
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        this.con = DriverManager.getConnection(this.url, this.id, this.password);
      }
    } catch (SQLException e) {
      System.err.println(e);

      return null;
    }

    return this.con;
  }
}
