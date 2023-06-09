<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>FormMain</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="common.css" />
  </head>
  <body>
    <div id="wrap">
      <div class="_header bg-body-secondary">
        <h2 class="fw-bold">Form</h2>
        <p class="fw-bold">폼을 통해 데이터를 전송해 봅시다.</p>
      </div>
      <div class="py-5">
        <form action="FormPro.jsp" method="POST">
          <div class="mb-3">
            <label for="user_email" class="form-label fw-bold">이메일</label>
            <input type="email" name="email" id="user_email" class="form-control" />
          </div>
          <div class="mb-3">
            <label for="user_password" class="form-label fw-bold">비밀번호</label>
            <input type="password" name="password" id="user_password" class="form-control" />
          </div>
          <button type="submit" class="btn btn-primary">Submit</button>
        </form>
      </div>
    </div>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
