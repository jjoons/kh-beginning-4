package problem.a2;

public class OrderDetailVO {
  private int id;
  private int orderId;
  private int beverageId;
  private int count;

  public OrderDetailVO(int id, int orderId, int beverageId, int count) {
    this.id = id;
    this.orderId = orderId;
    this.beverageId = beverageId;
    this.count = count;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getOrderId() {
    return orderId;
  }

  public void setOrderId(int orderId) {
    this.orderId = orderId;
  }

  public int getBeverageId() {
    return beverageId;
  }

  public void setBeverageId(int beverageId) {
    this.beverageId = beverageId;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  @Override
  public String toString() {
    return "OrderDetail [id=" + id + ", orderId=" + orderId + ", beverageId=" + beverageId
        + ", count=" + count + "]";
  }
}
