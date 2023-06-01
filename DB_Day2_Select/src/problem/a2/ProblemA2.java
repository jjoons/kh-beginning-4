package problem.a2;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class ProblemA2 {
  private Scanner sc = new Scanner(System.in);

  public void mainMenu() {
    while (true) {
      System.out.println("========== POS 시스템 ==========");
      System.out.println(" 1. POS");
      System.out.println(" 2. 재고관리");
      System.out.println(" 0. 종료");

      System.out.println("메뉴 선택: ");
      int sel = this.sc.nextInt();

      switch (sel) {
        case 1:
          this.posMenu();
          break;
        case 0:
          return;
        default:
          System.out.println("잘못 입력했습니다. 다시 시도해 주세요.");
      }
    }
  }

  public void posMenu() {
    System.out.println("등록할 상품 번호를 입력해 주세요");
    int sel = this.sc.nextInt();
  }

  public static void main(String[] args) throws ClassNotFoundException, SQLException {
    POSDBConnect posDB = POSDBConnect.getInstance();
    Connection con = posDB.getConnection();


  }
}
