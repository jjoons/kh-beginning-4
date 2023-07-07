package com.kh.mybatis;

import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// SqlSession
// SqlSessionFactory가 생성하는 SqlSession이라는 것은 데이터베이스에 SQL을 실행하기 위해서 필요하다

public class MySession {
  public static SqlSessionFactory factory = null;

  // 정적 초기화 블록에서 설정 파일을 읽어 객체(매퍼)를 생성한다
  static {
    try {
      Reader r = Resources.getResourceAsReader("com/kh/mybatis/SqlConfig.xml");
      SqlSessionFactoryBuilder build = new SqlSessionFactoryBuilder();
      factory = build.build(r);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // SqlSession 객체를 얻어온다
  public static SqlSession getSession() {
    return factory.openSession();
  }
}
