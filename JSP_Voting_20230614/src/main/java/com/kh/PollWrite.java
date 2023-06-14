package com.kh;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class PollWrite {
  // 텍스트 파일에 저장할 데이터가 저장된 ArrayList를 넘겨 받아 텍스트 파일로 저장하는 메소드
  public static void pollWrite(String filePath, ArrayList<String> poll) {
    PrintWriter printWriter = null;

    try {
      printWriter = new PrintWriter(filePath);

      // ArrayList에 저장된 개수만큼 반복하며 텍스트 파일로 출력한다
      // 텍스트 파일이 다 문자로 되어있기 때문에 텍스트 파일 안에서
      // 줄을 바꾸거나 줄의 맨 앞쪽으로 이동해야한다
      for (String str : poll) {
        printWriter.write(str + "\r\n");
      }
    } catch (FileNotFoundException e) {
      System.err.println("디스크에 파일이 존재하지 않습니다");
      e.printStackTrace();
    } finally {
      // 예외가 발생 여부와 관계없이 무조건 파일을 열었으면 닫는 문장이 있어야 함
      // 텍스트 파일을 저장하는 객체를 닫는다
      // 출력 객체를 닫지 않으면 파일로 출력한 데이터가 저장되지 않는다
      if (printWriter != null) {
        printWriter.close();
      }
    }
  }
}
