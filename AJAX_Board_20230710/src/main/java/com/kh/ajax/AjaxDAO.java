package com.kh.ajax;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AjaxDAO {
  private static AjaxDAO instance = null;
  private Connection con = null;
  private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
  private String id = "kh";
  private String password = "KH";

  private AjaxDAO() {
    this.getConnection();
  }

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

  // 검색어로 입력된 문자열이 name 필드에 포함된 데이터만 얻어오는 메소드
  public List<AjaxDTO> search(String searchString) {
    //    System.out.println();
    List<AjaxDTO> list = new ArrayList<>();

    String sql = "SELECT * FROM ajax WHERE name LIKE '%' || ? || '%'";

    try (PreparedStatement ps = this.con.prepareStatement(sql)) {
      searchString = searchString.replace("%", "%25");
      ps.setString(1, searchString);

      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        int idx = rs.getInt("idx");
        String name = rs.getString("name");
        int age = rs.getInt("age");
        String gender = rs.getString("gender");
        String email = rs.getString("email");

        AjaxDTO dto =
            AjaxDTO.builder().idx(idx).name(name).age(age).gender(gender).email(email).build();
        list.add(dto);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return list;
  }

  // insert.jsp 에서 입력한 데이터를 테이블에 저장하는 메소드
  public int insert(AjaxDTO dto) {
    // System.out.println("");

    // 테이블에 저장하고 정상적으로 실행되었다면 개수 리턴
    // SQL 명령에 오류가 있어서 catch 블록에서 실행되면 -1을 리턴한다
    String sql = "INSERT INTO ajax(NAME, AGE, GENDER, EMAIL) VALUES (?, ?, ?, ?)";

    try (PreparedStatement ps = this.con.prepareStatement(sql)) {
      ps.setString(1, dto.getName());
      ps.setInt(2, dto.getAge());
      ps.setString(3, dto.getGender());
      ps.setString(4, dto.getEmail());

      return ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return -1;
  }
}
