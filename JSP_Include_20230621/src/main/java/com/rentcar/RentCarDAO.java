package com.rentcar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentCarDAO {
  public static RentCarDAO instance = new RentCarDAO();
  public String realPath = "";
  private String fileName = "/rentcar_data.txt";
  private String dbConnectUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
  private String dbId = "kh";
  private String dbPw = "KH";

  // 데이터를 저장해서 활용
  private ArrayList<RentCar> rentCarList = new ArrayList<>();
  private ArrayList<Member> memberList = new ArrayList<>();
  private ArrayList<CarReserve> carReserveList = new ArrayList<>();
  private Connection conn = null;

  private RentCarDAO() {}

  public static RentCarDAO getInstance() {
    return instance;
  }

  public Connection getConnection() {
    try {
      if (this.conn == null || this.conn.isClosed()) {
        this.conn = DriverManager.getConnection(this.dbConnectUrl, this.dbId, this.dbPw);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return this.conn;
  }

  // 회원이 있으면 1을 돌려주고 아니면 0을 반환
  public int getMember(String id, String pw) {
    int result = 0;

    for (int i = 0; i < this.memberList.size(); i++) {
      Member member = this.memberList.get(i);

      if (member.getId().equals(id) && member.getPw1().equals(pw)) {
        result = 1;
        break;
      }
    }

    return result;
  }

  //
  public ArrayList<RentCar> getSelectCar3() {
    ArrayList<RentCar> list = new ArrayList<>();

    for (int i = 0; i < this.rentCarList.size(); i++) {
      list.add(this.rentCarList.get(i));

      if (i >= 2) {
        return list;
      }
    }

    return list;
  }

  public ArrayList<RentCar> getCategoryCar(int cate) {
    ArrayList<RentCar> list = new ArrayList<>();

    // rentCarList 안에서 반복하면서 카테고리 내용을 가지고 와서
    // cate와 비교해서 같은 값만 리스트에 넣어서 반환한다

    for (RentCar car : this.rentCarList) {
      if (car.getCategory() == cate) {
        list.add(car);
      }
    }

    return list;
  }

  // 리스트에서 no을 이용해서 데이터를 꺼내가기
  public RentCar getOneCar(int no) {
    // 실제 번호 1, 2, 3, 4 이지만 리스트에 저장되는 값은 다르다
    for (RentCar car : this.rentCarList) {
      if (car.getNo() == no) {
        return car;
      }
    }

    return null;
  }

  // 예약 리스트에 저장하기
  public void setReserveCar(CarReserve bean) {
    // 예약 리스트에서 공통적인 예약 번호를 적기 위해서 가장 큰 번호를 가지고 온다
    int maxNum = 0;

    if (this.carReserveList.size() > 0) {
      int last = this.carReserveList.size() - 1;
      maxNum = carReserveList.get(last).getNo();
    }
    // 만약 데이터가 처음 저장되는 것이면 바로 추가
    bean.setReserve_seq(maxNum);
    this.carReserveList.add(bean);

    // 파일에 저장하는 메소드 호출
  }

  public List<CarReserve> getReservation(String id) {
    List<CarReserve> list = new ArrayList<>();

    for (CarReserve reserve : this.carReserveList) {
      if (reserve.getId().equals(id)) {
        list.add(reserve);
      }
    }

    return list;
  }

  public boolean removeReservation(int reserve_seq) {
    for (CarReserve reserve : this.carReserveList) {
      if (reserve.getReserve_seq() == reserve_seq) {
        return this.carReserveList.remove(reserve);
      }
    }

    return false;
  }

  // 회원가입이 없어서 미리 초기 설정
  public void memberBasicSet() {
    Member mb = new Member();
    mb.setId("aa");
    mb.setPw1("11");

    this.memberList.add(mb);

    mb = new Member();
    mb.setId("bb");
    mb.setPw1("22");

    this.memberList.add(mb);
  }

  // 렌트카에 대한 기본 설정
  public void rentCarBasicSet() {
    this.rentCarList.clear();
    RentCar rc;
    rc = new RentCar(1, "아반테", 1, 2000, 4, "기아", "rent_1.jpg", "아반테 자동차 입니다.");
    this.rentCarList.add(rc);
    rc = new RentCar(2, "BMW", 3, 6000, 4, "BMW", "rent_2.jpg", "BMW 자동차 입니다.");
    this.rentCarList.add(rc);
    rc = new RentCar(3, "카니발", 1, 4000, 7, "기아", "rent_3.jpg", "카니발 자동차 입니다.");
    this.rentCarList.add(rc);
    rc = new RentCar(4, "카렌스", 2, 2500, 4, "기아", "rent_4.jpg", "카렌스 자동차 입니다.");
    this.rentCarList.add(rc);
    rc = new RentCar(5, "코란도", 1, 3000, 4, "현대", "rent_5.jpg", "코란도 자동차 입니다.");
    this.rentCarList.add(rc);
    rc = new RentCar(6, "에쿠스", 3, 6000, 4, "BMW", "rent_6.jpg", "에쿠스 자동차 입니다.");
    this.rentCarList.add(rc);
    rc = new RentCar(7, "제네시스", 1, 3000, 4, "기아", "rent_7.jpg", "제네시스 자동차 입니다.");
    this.rentCarList.add(rc);
    rc = new RentCar(8, "그랜져", 1, 2400, 4, "현대", "rent_8.jpg", "그랜져 자동차 입니다.");
    this.rentCarList.add(rc);
    rc = new RentCar(9, "k3", 1, 2700, 4, "현대", "rent_9.jpg", "k3 자동차 입니다.");
    this.rentCarList.add(rc);
    rc = new RentCar(10, "k5", 2, 5000, 4, "기아", "rent_10.jpg", "k5 자동차 입니다.");
    this.rentCarList.add(rc);
    rc = new RentCar(11, "k9", 1, 6000, 4, "현대", "rent_11.jpg", "k9 자동차 입니다.");
    this.rentCarList.add(rc);
    rc = new RentCar(12, "라세티", 2, 2000, 5, "기아", "rent_12.jpg", "라세티 자동차 입니다.");
    this.rentCarList.add(rc);
    rc = new RentCar(13, "lf소나타", 1, 2000, 4, "현대", "rent_13.jpg", "lf소나타 자동차 입니다.");
    this.rentCarList.add(rc);
    rc = new RentCar(14, "말리부", 3, 2000, 4, "BMW", "rent_14.jpg", "말리부 자동차 입니다.");
    this.rentCarList.add(rc);
    rc = new RentCar(15, "모닝", 1, 23000, 4, "현대", "rent_15.jpg", "모닝 자동차 입니다.");
    this.rentCarList.add(rc);
    rc = new RentCar(16, "올라도", 3, 5000, 4, "BMW", "rent_16.jpg", "올라도 자동차 입니다.");
    this.rentCarList.add(rc);
    rc = new RentCar(17, "레이", 2, 4000, 4, "현대", "rent_17.jpg", "레이 자동차 입니다.");
    this.rentCarList.add(rc);
    rc = new RentCar(18, "SM5", 1, 2700, 4, "BMW", "rent_18.jpg", "SM5 자동차 입니다.");
    this.rentCarList.add(rc);
  }
}
