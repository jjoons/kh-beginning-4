package _05_User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class UserDAO {
  // 메모장에 저장되는 모든 내용을 저장하는 리스트
  private ArrayList<UserDTO> userList = new ArrayList<>();

  public String realPath = "";
  public String fileName = "userdata.txt";

  private static UserDAO instance = new UserDAO();

  public UserDAO() {}

  public static UserDAO getInstance() {
    return instance;
  }

  // 관리자 기능
  //   1. 전체 회원의 정보를 리턴해 주는 메소드
  public ArrayList<UserDTO> getUserList() {
    return this.userList;
  }

  //   2. 회원 id를 전달받아 해당 회원의 모든 정보를 리턴해 주는 메소드
  public UserDTO getUserDTO(String id) {
    UserDTO temp = null;

    for (int i = 0; i < this.userList.size(); i++) {
      if (this.userList.get(i).getId().equals(id)) {
        temp = this.userList.get(i);
      }
    }

    return temp;
  }

  // 아이디를 가지고 아이디가 속한 객체의 정보를 반환하는 메소드
  public UserDTO getUserId(String id) {
    for (UserDTO temp : this.userList) {
      if (temp.getId().equals(id)) {
        return temp;
      }
    }

    return null;
  }

  // 수정한 내용을 메모장, 리스트에 저장하는 메소드
  public void updateUser(UserDTO user) {
    //    for (int i = 0; i < this.userList.size(); i++) {
    //      UserDTO temp = this.userList.get(i);
    //
    //      if (temp.getId().equals(user.getId())) {
    //        this.saveData();
    //      }
    //    }

    for (UserDTO temp : this.userList) {
      if (temp.getId().equals(user.getId())) {
        temp = user;
        this.saveData();
      }
    }
  }

  // 파일 로드
  public void loadData() {
    File file = new File(this.realPath + this.fileName);

    // realPath + /userdata.txt 파일이 존재한다면
    if (file.exists()) {
      // 기존 데이터를 지운 다음 새로 작성한다
      this.userList.clear();

      try {
        // 파일 입출력을 할 때 방향. 불러오기
        FileReader fr = new FileReader(file);

        // 임시 버퍼를 이용해서 한꺼번에 데이터 읽기
        BufferedReader br = new BufferedReader(fr);

        // 한 줄씩 읽기
        String line = br.readLine();

        while (line != null) {
          // id / pw / name / data
          String[] arr = line.split("/");
          UserDTO user = new UserDTO(arr[0], arr[1], arr[2], arr[3]);

          this.userList.add(user);

          line = br.readLine();
        }

        fr.close();
        br.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public void saveData() {
    String data = "";

    for (UserDTO temp : this.userList) {
      // 텍스트 파일이 문자 형식 안에 멤버들을 문자로 변경해서 저장
      data += temp.getId();
      data += "/";
      data += temp.getPw();
      data += "/";
      data += temp.getName();
      data += "/";
      data += temp.getReg_date();
      data += "\r\n";

      System.out.println("실제 메모장의 위치: " + this.realPath);

      try {
        FileWriter fw = new FileWriter(this.realPath + this.fileName);
        fw.write(data);
        fw.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  // 회원 가입 메소드
  public void insertUser(UserDTO user) {
    this.userList.add(user);

    this.saveData();
  }

  // 아이디 중복 확인 메소드
  public boolean checkUserId(UserDTO user) {
    for (UserDTO temp : this.userList) {
      if (temp.getId().equals(user.getId())) {
        return true;
      }
    }

    return false;
  }

  // 로그인 시 호출되야 하는 메소드
  public boolean checkUserIdPw(String id, String pw) {
    for (UserDTO temp : this.userList) {
      if (temp.getId().equals(id) && temp.getPw().equals(pw)) {
        return true;
      }
    }

    return false;
  }

  //  public void deleteUserId(String id) {
  //    int i = 0;
  //    for (UserDTO temp : userList) {
  //      if (temp.getId().equals(id)) {
  //        userList.remove(i);
  //        saveData();
  //        break;
  //      }
  //
  //      i++;
  //    }
  //  }

  public void deleteUserId(String id) {
    for (int i = 0; i < this.userList.size(); i++) {
      UserDTO user = this.userList.get(i);

      if (user.getId().equals(id)) {
        this.userList.remove(i);
        this.saveData();

        break;
      }
    }
  }
}
