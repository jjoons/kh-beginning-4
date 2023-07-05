<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- 대입문, 제어문 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> <!-- 서식 -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> <!-- 함수 -->
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Insert title here</title>
</head>
<body>
  <!-- JSTL에서 사용하는 한글 깨짐 방지 -->
  <fmt:requestEncoding value="utf-8" />

  <!--  el을 사용하면 request영역에 저장된 데이터를 받는 처리 없이 사용할 수있다.
  GuestbookList guestbookList = 
          (GuestbookList) request.getAttribute("guestbookList");
  out.println(guestbookList);
  \${guestbookList}
  
  
  el을 사용하면 객체 내부의 데이터를 \${객체이름.필드이름}의 형태로 얻어올 수있다. 
  => getter가 자동으로 실행된다.
  out.println(guestbookList.getList());
  \${guestbookList.list}와 같이 사용할 수 있다. 
  
  c:set  => 대입문 
  
  ArrayList<GuestbookVO> view = guestbookList.getList();
  jstl 문법으로 사용하면 
  <%-- <c:set var ="view" value ="\${guestbookList.list}" /> --%> 
  
  jstl if문 else를 사용할 수 없다. 
  jstl foreah문 1씩 2씩  [step=""] 양수만 사용해야된다. 생략하면 기본값으로 1
  
  <%--
  <c:forEach var="변수이름" begin="초기치" end="최종치" [step="증가치"]>
    반복할 문장
  </c:forEach>
  --%>
  
  향상된 for: 객체에 저장된 내용이 변수에 처음부터 마지막까지 차례대로 대입되며 반복한다.
  <%--
  <c:forEach var="변수이름" items=\${배열이나 List 형태의 객체}>
    반복할 문장
  </c:forEach>
  --%>
  
  jstl 함수 사용하기 
  \${fn: 함수이름(인수)}

  jstl 날짜 서식 -> 날짜 서식을 지정하는 방법은 자바랑 똑같다
  <%--
  <fmt:formatDate value=\${날짜 데이터} pattern="날짜서식"></fmt:formatDate>
  --%>
  
  -->
  <c:set var="view" value="${guestbookList.list}" />
  <table width="1000" align="center" border="1" cellpadding="5" cellspacing="0">
    <tr>
      <th>방명록 보기</th>
    </tr>
    <tr>
      <td align="right">
        ${guestbookList.totalCount}개(${guestbookList.currentPage} / ${guestbookList.totalPage})
      </td>
    </tr>
    <tr>
      <td>
      
        <!-- 테이블에 저장된 글이 없으면 없다고 출력한다. -->
        <c:if test="${view.size() == 0}">
          <marquee>테이블에 저장된 글이 없습니다.</marquee>
        </c:if>
        
        <!-- 테이블에 저장된 글이 있으면 글 목록을 출력한다. -->
        <c:if test="${view.size() != 0}">
          <!-- useBean으로 컴퓨터 시스템의 날짜와 시간을 얻어온다. -->
          <jsp:useBean id="date" class="java.util.Date"/>
          <%-- ${date} --%>
          
          <c:forEach var="vo" items="${view}">
            <table class="table" width="99%" align="center" border="1" cellpadding="5" cellspacing="0">
              <tr>
                <td>
                  ${vo.idx}. 
                  <!-- 이름에 태그가 먹지않도록 replace 함수를 적용한다. -->
                  <c:set var="name" value="${fn:replace(vo.name, '<', '&lt;')}"/>
                  <c:set var="name" value="${fn:replace(name, '>', '&gt;')}"/>
                  ${name}
                  
                  
                  (${vo.ip})님이 
                  
                  <!-- 날짜에 서식을 적용한다. -->
                  <fmt:formatDate value="${vo.writeDate}" pattern="yyyy.MM.dd(E)"/>
                  
                  에 남긴글<br/>
                  <!-- 메모에 태그가 먹지않도록 replace 함수를 적용한다. -->
                  <c:set var="memo" value="${fn:replace(vo.memo, '<', '&lt;')}"/>
                  <c:set var="memo" value="${fn:replace(memo, '>', '&gt;')}"/>
                  <c:set var="memo" value="${fn:replace(memo, enter, '<br/>')}"/>
                  ${memo}
                </td>
              </tr>
          </c:forEach>
          
        </c:if>
      
      </td>
    </tr>


  
    <!-- 글쓰기 버튼 -->
    <tr>
      <td align="right">
        <input class="button button1" type="button" value="글쓰기" onclick="location.href='insert.jsp'"/>
      </td>
    </tr>
  </table>

</body>
</html>
