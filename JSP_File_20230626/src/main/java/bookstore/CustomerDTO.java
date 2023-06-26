package bookstore;

public class CustomerDTO {
  // 이름, 아이디, 패스워드, 가입일자, 전화번호, 주소
  private String id;
  private String passwd;
  private String name;
  private String reg_date;
  private String tel;
  private String address;

  // 생성자 (기본, 매개 변수)
  public CustomerDTO() {}

  public CustomerDTO(String id, String passwd, String name, String reg_date, String tel,
      String address) {
    this.id = id;
    this.passwd = passwd;
    this.name = name;
    this.reg_date = reg_date;
    this.tel = tel;
    this.address = address;
  }

  // getter, setter
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPasswd() {
    return passwd;
  }

  public void setPasswd(String passwd) {
    this.passwd = passwd;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getReg_date() {
    return reg_date;
  }

  public void setReg_date(String reg_date) {
    this.reg_date = reg_date;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  // toString() 선택
  @Override
  public String toString() {
    return "CustomerDTO {\"id\": \"" + id + "\", \"passwd\": \"" + passwd + "\", \"name\": \""
        + name + "\", \"reg_date\": \"" + reg_date + "\", \"tel\": \"" + tel + "\", \"address\": \""
        + address + "\"}";
  }
}
