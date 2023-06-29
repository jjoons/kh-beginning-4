package _03_jstl;

public class MemberBean {
  private String id;
  private String password;
  private String name;
  private String email;
  private String hobby;

  public MemberBean() {}

  public MemberBean(String id, String password, String name, String email, String hobby) {
    this.id = id;
    this.password = password;
    this.name = name;
    this.email = email;
    this.hobby = hobby;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getHobby() {
    return hobby;
  }

  public void setHobby(String hobby) {
    this.hobby = hobby;
  }

  @Override
  public String toString() {
    return "MemberBean {\"id\": \"" + id + "\", \"password\": \"" + password + "\", \"name\": \""
        + name + "\", \"email\": \"" + email + "\", \"hobby\": \"" + hobby + "\"}";
  }
}
