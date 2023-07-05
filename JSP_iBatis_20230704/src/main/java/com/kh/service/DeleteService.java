package com.kh.service;

public class DeleteService {
  //singleton 클래스 디자인 패턴은 한 순간에 단 한 개의 객체만 필요할 경우 사용하는 디자인 패턴이다.
  //singleton 패턴 코딩 방식
  //1. 자기 자신(현재 클래스)의 객체를 기본 생성자를 사용해서 정적 필드로 선언한다.
  private static DeleteService instance = new DeleteService();

  //2. 클래스 외부에서 객체를 생성할 수 없도록 기본 생성자의 접근 권한을 private으로 변경한다.
  private DeleteService() {}

  //3. 자신의 객체를 리턴시키는 정적 메소드를 만든다.
  public static DeleteService getInstance() {
    return instance;
  }
}
