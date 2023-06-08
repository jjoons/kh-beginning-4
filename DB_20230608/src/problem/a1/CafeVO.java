package problem.a1;

public class CafeVO {
  // Cafe에 대한 내용을 저장하는 클래스
  // 생성자, toString 선언
  // getter, setter 선언
  // Statement 클래스에서 ArrayList 클래스에 저장한 후 출력

  int cafeId;
  String cafeName;
  String corporation;
  int price;

  public CafeVO(int cafeId, String cafeName, String corporation, int price) {
    this.cafeId = cafeId;
    this.cafeName = cafeName;
    this.corporation = corporation;
    this.price = price;
  }

  public int getCafeId() {
    return cafeId;
  }

  public void setCafeId(int cafeId) {
    this.cafeId = cafeId;
  }

  public String getCafeName() {
    return cafeName;
  }

  public void setCafeName(String cafeName) {
    this.cafeName = cafeName;
  }

  public String getCorporation() {
    return corporation;
  }

  public void setCorporation(String corporation) {
    this.corporation = corporation;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "CafeVO [cafeId=" + cafeId + ", cafeName=" + cafeName + ", corporation=" + corporation
        + ", price=" + price + "]";
  }
}
