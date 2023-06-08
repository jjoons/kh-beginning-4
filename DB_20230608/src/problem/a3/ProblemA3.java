package problem.a3;

/*
 *   Cafe 패키지
 *    main  메뉴 보여주고 
 *              1. 음료목록추가   
 *              2. 주문  ->  커피이름 가격 개수 주문 번호 총 가격  
 *              3. 주문 취소 -> 주문번호 취소 
 *              4. 종료  -> 오늘의 총 매출은 ** 입니다!
 *                          아메리카노 2잔  4000
 *                          에이드    10잔 50000
 *  
 *    VO객체
 *    DTO 클래스 
 *      main-> 데이터베이스 실행해야된다 DTO클래스에서 데이터베이스 연동하고
 *      --> 저장, 삭제, 수정 (함수작성해서)-> main에서 map, list 
 *    
 */

public class ProblemA3 {
  public static void main(String[] args) {
    new Menu().mainMenu();
  }
}
