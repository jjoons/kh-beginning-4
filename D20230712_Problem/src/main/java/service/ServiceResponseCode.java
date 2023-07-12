package service;

import java.util.HashMap;
import java.util.Map;

public enum ServiceResponseCode {
  PASSWORD_VALID(10, "유효한 비밀번호입니다."),
  PASSWORD_PARAMETER_NULL(-13, "비밀번호 파라미터가 지정되지 않았습니다."),
  PASSWORD_EMPTY(-11, "비밀번호가 비어있습니다."),
  PASSWORD_MISMATCH(-12, "비밀번호와 재입력 비밀번호가 일치하지 않습니다."),
  PASSWORD_MISMATCH_CONDITIONAL(-13, "비밀번호가 조건과 일치하지 않습니다."),

  ID_VALID(20, "사용 가능한 아이디입니다."),
  ID_EMPTY(-21, "아이디가 비어있습니다."),
  ID_MISMATCH_CONDITIONAL(-22, "아이디가 조건과 일치하지 않습니다."),
  ID_DUPLICATE(-23, "중복된 아이디입니다."),
  ID_PARAMETER_NULL(-24, "아이디 파라미터가 지정되지 않았습니다."),

  NAME_PARAMETER_NULL(-31, "이름 파라미터가 지정되지 않았습니다."),
  NAME_EMPTY(-32, "이름이 비어있습니다."),

  AGE_MISMATCH_CONDITIONAL(-41, "나이가 조건과 일치하지 않습니다."),

  GENDER_PARAMETER_NULL(-51, "성별 파라미터가 지정되지 않았습니다."),
  GENDER_EMPTY(-52, "성별이 비어있습니다."),

  EMAIL_PARAMETER_NULL(-61, "이메일 파라미터가 지정되지 않았습니다."),
  EMAIL_EMPTY(-62, "이메일이 비어있습니다."),

  ACCOUNT_VALID(70, "유효한 계정입니다."),

  SQL_ERROR(-10000, "SQL 오류입니다."),

  UNKNOWN_ERROR(-65536, "알 수 없는 오류입니다.");

  private int value;
  private String message;

  ServiceResponseCode(int value, String message) {
    this.value = value;
    this.message = message;
    InnerClass.map.put(value, this);
  }

  private static class InnerClass {
    private static Map<Integer, ServiceResponseCode> map = new HashMap<>();
  }

  public int value() {
    return value;
  }

  public String message() {
    return message;
  }

  public static String getMessageByValue(int value) {
    String message = null;
    ServiceResponseCode code = InnerClass.map.get(value);

    if (code != null) {
      message = code.message;
    }

    return message;
  }
}
