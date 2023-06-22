package com.rentcar;

// 렌터카의 정보를 저장해서 조회했을 때 정보 출력
public class RentCar {
  // 차량 저장 번호
  private int no;

  // 차량 이름
  private String name;

  // 차량 분류 (소형, 중형, 대형)
  private int category;

  // 차량 가격
  private int price;

  // 차량 탑승 가능 인원
  private int user_people;

  // 차량 제조사
  private String company;

  // 차량 이미지 파일명
  private String img;

  // 차량에 대한 정보 저장
  private String info;

  public RentCar() {}

  public RentCar(int no, String name, int category, int price, int user_people, String company,
      String img, String info) {
    super();
    this.no = no;
    this.name = name;
    this.category = category;
    this.price = price;
    this.user_people = user_people;
    this.company = company;
    this.img = img;
    this.info = info;
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getCategory() {
    return category;
  }

  public void setCategory(int category) {
    this.category = category;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getUser_people() {
    return user_people;
  }

  public void setUser_people(int user_people) {
    this.user_people = user_people;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public String getImg() {
    return img;
  }

  public void setImg(String img) {
    this.img = img;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }

  @Override
  public String toString() {
    return "RentCar [no=" + no + ", name=" + name + ", category=" + category + ", price=" + price
        + ", user_people=" + user_people + ", company=" + company + ", img=" + img + ", info="
        + info + "]";
  }
}
