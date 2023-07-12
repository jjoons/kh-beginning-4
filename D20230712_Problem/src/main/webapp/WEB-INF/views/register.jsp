<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
  <link rel="stylesheet" href="css/register.css" />
  <script defer src="js/register.js"></script>
</head>
<body>
  <div id="wrap">
    <form name="registerForm" id="registerForm" method="post">
      <table class="table table-bordered">
        <colgroup>
          <col style="width: 150px;" />
          <col />
        </colgroup>
        <thead>
          <tr>
            <th class="bg-success-subtle py-3" colspan="2">
              <h2 class="text-center">회원 가입 양식</h2>
            </th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td class="bg-danger-subtle fw-bold">아이디</td>
            <td>
              <div>
                <input type="text" name="id" id="" class="form-control " placeholder="아이디를 입력하세요" required />
                <span class="bg-primary-subtle">
                  <button type="button" id="check_id_duplicate_btn" class="btn btn-primary">중복 검사</button>
                </span>
              </div>
            </td>
          </tr>
          <tr>
            <td class="bg-danger-subtle fw-bold">비밀번호</td>
            <td>
              <input type="password" name="password" id="" class="form-control" placeholder="비밀번호를 입력하세요" required />
            </td>
          </tr>
          <tr>
            <td class="bg-danger-subtle fw-bold">비밀번호 확인</td>
            <td>
              <input type="password" name="password_re" id="" class="form-control" placeholder="비밀번호를 한번 더 입력하세요" required />
            </td>
          </tr>
          <tr>
            <td class="bg-danger-subtle fw-bold">이름</td>
            <td>
              <input type="text" name="name" id="" class="form-control" placeholder="이름을 입력하세요" required />
            </td>
          </tr>
          <tr>
            <td class="bg-danger-subtle fw-bold">나이</td>
            <td>
              <input type="number" name="age" id="" class="form-control" placeholder="나이를 입력하세요" required />
            </td>
          </tr>
          <tr>
            <td class="bg-danger-subtle fw-bold">성별</td>
            <td class="text-center">
              <div class="btn-group">
                <input type="radio" name="gender" value="male" id="gender_male" class="btn-check" checked required />
                <label for="gender_male" class="btn btn-primary">남자</label>
                <input type="radio" name="gender" value="female" id="gender_female" class="btn-check" />
                <label for="gender_female" class="btn btn-primary">여자</label>
              </div>
            </td>
          </tr>
          <tr>
            <td class="bg-danger-subtle fw-bold">이메일</td>
            <td>
              <input type="email" name="email" id="" class="form-control" placeholder="이메일을 입력하세요" required />
            </td>
          </tr>
        </tbody>
        <tfoot>
          <tr>
            <td colspan="2" class="bg-body text-center">
              <div>
                <div id="idCheckMessage"></div>
                <div id="passwordCheckMessage"></div>
                <div id="errorMessage"></div>
              </div>
              <div>
                <button type="submit" class="btn btn-primary">회원가입</button>
                <button type="reset" class="btn btn-primary">다시 쓰기</button>
              </div>
            </td>
          </tr>
        </tfoot>
      </table>
    </form>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</body>
</html>
