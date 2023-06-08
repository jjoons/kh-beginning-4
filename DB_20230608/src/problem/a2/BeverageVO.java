package problem.a2;

public class BeverageVO {
  private int id;
  private String name;
  private int price;
  private String bType;

  public BeverageVO(int id, String name, int price, String bType) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.bType = bType;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getbType() {
    return bType;
  }

  public void setbType(String bType) {
    this.bType = bType;
  }

  @Override
  public String toString() {
    return "BeverageVO [id=" + id + ", name=" + name + ", price=" + price + ", bType=" + bType
        + "]";
  }
}
