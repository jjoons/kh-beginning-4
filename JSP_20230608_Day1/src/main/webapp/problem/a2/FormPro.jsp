<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>FormPro</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="common.css" />
  </head>
  <body>
    <%!
      public class Account {
        private int serialNum;
        private String email;
        private String password;

        public Account(int serialNum, String email, String password) {
          this.serialNum = serialNum;
          this.email = email;
          this.password = password;
        }

        public int getSerialNum() {
          return this.serialNum;
        }

        public String getEmail() {
          return this.email;
        }

        public String getPassword() {
          return this.password;
        }
      }
    
      ArrayList<Account> accs = new ArrayList<>();
    %>
    <%
      String email = request.getParameter("email");
      String password = request.getParameter("password");
      
      if (email != null && password != null) {
        accs.add(new Account(accs.size() + 1, email, password));
      }
    %>
    <div id="wrap">
      <div class="_header bg-secondary-subtle">
        <h2 class="">Form 정보</h2>
      </div>
      <div>
        <table class="table table-striped">
          <thead class="table-dark">
            <tr>
              <th>번호</th>
              <th>이메일</th>
              <th>비밀번호</th>
            </tr>
          </thead>
          <tbody>
            <% for (Account acc : accs) { %>
              <tr>
                <th><%= acc.serialNum %></th>
                <th><%= acc.email %></th>
                <th><%= acc.password %></th>
              </tr>
            <% } %>
          </tbody>
        </table>
      </div>
      
    </div>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
