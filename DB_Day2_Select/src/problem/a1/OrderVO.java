package problem.a1;

import java.sql.Date;
import java.util.Objects;

public class OrderVO {
  private int orderId;
  private int custId;
  private int bookId;
  private int salePrice;
  private Date orderDate;

  public OrderVO(int orderId, int custId, int bookId, int salePrice, Date orderDate) {
    this.orderId = orderId;
    this.custId = custId;
    this.bookId = bookId;
    this.salePrice = salePrice;
    this.orderDate = orderDate;
  }

  public int getOrderId() {
    return orderId;
  }

  public int getCustId() {
    return custId;
  }

  public int getBookId() {
    return bookId;
  }

  public int getSalePrice() {
    return salePrice;
  }

  public Date getOrderDate() {
    return orderDate;
  }

  @Override
  public int hashCode() {
    return Objects.hash(bookId, custId, orderDate, orderId, salePrice);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    OrderVO other = (OrderVO) obj;
    return bookId == other.bookId && custId == other.custId
        && Objects.equals(orderDate, other.orderDate) && orderId == other.orderId
        && salePrice == other.salePrice;
  }

  @Override
  public String toString() {
    return "OrderVO [orderId=" + orderId + ", custId=" + custId + ", bookId=" + bookId
        + ", salePrice=" + salePrice + ", orderDate=" + orderDate + "]";
  }
}
