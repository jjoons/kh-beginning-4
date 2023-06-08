package problem.a3;

import java.util.List;
import java.util.Scanner;
import problem.a2.BeverageVO;

public class Menu {
  private Scanner sc = new Scanner(System.in);
  private CafeController con = new CafeController();

  public void mainMenu() {
    while (true) {
      System.out.println("===== 카페 =====");
      System.out.println("1. 주문하기");
      System.out.println("2. 주문 취소");
      //      System.out.println("9. 관리자");
      System.out.println("0. 종료");

      System.out.println("입력: ");
      int sel = this.sc.nextInt();

      switch (sel) {
        case 1:
          this.orderMenu();
          break;
        case 2:
          this.cancelOrderMenu();
          break;
        case 0:
          return;
        default:
          System.out.println("번호를 잘못 입력하셨습니다. 다시 시도해 주세요");
          break;
      }
    }
  }

  public void orderMenu() {
    while (true) {
      System.out.println("1. 메뉴 추가");
      System.out.println("2. 메뉴 삭제");
      System.out.println("3. 결제");
      System.out.println("0. 이전 메뉴");

      int sel = this.sc.nextInt();

      switch (sel) {
        case 1:
          this.addMenu();
          break;
        case 2:
          this.removeMenu();
          break;
        case 3:
          this.paymentMenu();
          break;
        case 0:
          return;
        default:
          break;
      }
    }
  }

  public void addMenu() {
    List<BeverageVO> bevers = this.con.getBeverages(10, 1);

    for (BeverageVO bever : bevers) {
      System.out.println(bever);
    }
  }

  public void removeMenu() {}

  public void paymentMenu() {}

  public void cancelOrderMenu() {}
}
