package service;

import dao.AccountDAO;
import dto.AccountDTO;

public class AccountService {
  public static final String ID_REGEX = "[a-zA-Z0-9]{2,20}";
  public static final String ID_INVALID_MESSAGE = "아이디는 영문자 및 숫자를 혼용해서 2자 이상 20자 이하여야 합니다.";
  public static final String PASSWORD_INVALID_MESSAGE = "비밀번호는 8자 이상 20자 이하여야 합니다.";
  public static final int PASSWORD_MIN_LENGTH = 8;
  public static final int PASSWORD_MAX_LENGTH = 20;

  public static int checkValidId(String id) {
    if (id == null) {
      return ServiceResponseCode.ID_PARAMETER_NULL.value();
    }

    if (id.isBlank()) {
      return ServiceResponseCode.ID_EMPTY.value();
    }

    if (!id.matches(ID_REGEX)) {
      return ServiceResponseCode.ID_MISMATCH_CONDITIONAL.value();
    }

    int checkResult = AccountDAO.getInstance().checkDuplicateId(id);

    if (checkResult > 0) {
      return ServiceResponseCode.ID_DUPLICATE.value();
    } else if (checkResult < 0) {
      return ServiceResponseCode.SQL_ERROR.value();
    }

    return ServiceResponseCode.ID_VALID.value();
  }

  public static int checkValidPassword(String password, String password_re) {
    if (password == null || password_re == null) {
      return ServiceResponseCode.PASSWORD_PARAMETER_NULL.value();
    }

    if (password.isEmpty() || password_re.isEmpty()) {
      return ServiceResponseCode.PASSWORD_EMPTY.value();
    }

    if (password.length() < PASSWORD_MIN_LENGTH || password.length() > PASSWORD_MAX_LENGTH) {
      return ServiceResponseCode.PASSWORD_MISMATCH_CONDITIONAL.value();
    }

    if (!password.equals(password_re)) {
      return ServiceResponseCode.PASSWORD_MISMATCH.value();
    }

    return ServiceResponseCode.PASSWORD_VALID.value();
  }


  public static int checkValidAccount(AccountDTO dto) {
    int responseCode = checkValidId(dto.getId());

    if (responseCode != ServiceResponseCode.ID_VALID.value()) {
      return responseCode;
    }

    responseCode = checkValidPassword(dto.getPassword(), dto.getPassword());

    if (responseCode != ServiceResponseCode.PASSWORD_VALID.value()) {
      return responseCode;
    }

    if (dto.getName() == null) {
      return ServiceResponseCode.NAME_PARAMETER_NULL.value();
    }

    if (dto.getName().isBlank()) {
      return ServiceResponseCode.NAME_EMPTY.value();
    }

    if (dto.getAge() <= -1) {
      return ServiceResponseCode.AGE_MISMATCH_CONDITIONAL.value();
    }

    if (dto.getGender() == null) {
      return ServiceResponseCode.GENDER_PARAMETER_NULL.value();
    }

    if (dto.getGender().isBlank()) {
      return ServiceResponseCode.GENDER_EMPTY.value();
    }

    if (dto.getEmail() == null) {
      return ServiceResponseCode.EMAIL_PARAMETER_NULL.value();
    }

    if (dto.getEmail().isBlank()) {
      return ServiceResponseCode.EMAIL_EMPTY.value();
    }

    return ServiceResponseCode.ACCOUNT_VALID.value();
  }
}
