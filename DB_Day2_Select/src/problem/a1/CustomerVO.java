package problem.a1;

import java.util.Objects;

public class CustomerVO {
  private int custId;
  private String name;
  private String address;
  private String phone;

  public CustomerVO(int custId, String name, String address, String phone) {
    this.custId = custId;
    this.name = name;
    this.address = address;
    this.phone = phone;
  }

  public int getCustId() {
    return custId;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public String getPhone() {
    return phone;
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, custId, name, phone);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    CustomerVO other = (CustomerVO) obj;
    return Objects.equals(address, other.address) && custId == other.custId
        && Objects.equals(name, other.name) && Objects.equals(phone, other.phone);
  }

  @Override
  public String toString() {
    return "CustomerVO [custId=" + custId + ", name=" + name + ", address=" + address + ", phone="
        + phone + "]";
  }
}
