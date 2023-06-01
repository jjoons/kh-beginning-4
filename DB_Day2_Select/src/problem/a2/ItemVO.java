package problem.a2;

import java.util.Objects;

public class ItemVO {
  private int id;
  private String name;
  private String stock;
  private int price;

  public ItemVO(int id, String name, String stock, int price) {
    this.id = id;
    this.name = name;
    this.stock = stock;
    this.price = price;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getStock() {
    return stock;
  }

  public int getPrice() {
    return price;
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
    ItemVO other = (ItemVO) obj;
    return id == other.id && Objects.equals(name, other.name) && price == other.price
        && Objects.equals(stock, other.stock);
  }

  @Override
  public String toString() {
    return "POSGoodsVO [id=" + id + ", name=" + name + ", stock=" + stock + ", price=" + price
        + "]";
  }
}
