package problem.a2;

import java.util.Objects;

public class ItemDTO {
  private int id;
  private String name;
  private int stock;
  private int price;

  public ItemDTO() {}

  public ItemDTO(int id, String name, int stock, int price) {
    this.id = id;
    this.name = name;
    this.stock = stock;
    this.price = price;
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

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, price, stock);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ItemDTO other = (ItemDTO) obj;
    return id == other.id && Objects.equals(name, other.name) && price == other.price
        && Objects.equals(stock, other.stock);
  }

  @Override
  public String toString() {
    return "POSGoodsVO [id=" + id + ", name=" + name + ", stock=" + stock + ", price=" + price
        + "]";
  }
}
