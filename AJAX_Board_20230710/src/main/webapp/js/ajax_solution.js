/*
  Asynchronous Javascript And XML
    웹 페이지 전체를 다시 로딩하지 않고도, 웹 페이지의 일부만 갱신할 수 있게 한다.
    

  ajax동작하는 원리 
    1.버튼을 누르거나 마우스로 드래그하거나 클릭하거나 이벤트가 발생 
    2.자바스크립트 호출 
    3.XMLHttpRequest 객체 생성 
    4.Ajax요청 처리 
    5.응답생성 
    6. html, xml , json 데이터 
    7. html 및 css 
    8. 일부분 다시 로딩을 해준다.

  XMLHttpRequest 객체
    - 웹 브라우저가 서버와 데이터를 교환할 때 사용

    onreadystatechange 등록
      onreadystatechange = function () { ... }
      
      onreadystatechange로 서버로 부터 응답이 오게 되어 XMLHttpRequest 객체의 값이
      변경된다. 이를 감지해 자동으로 호출되는 함수를 설정한다

    서버로 AJAX 요청하는 방식
      xhr.open('전달방식(http method)', url주소, 동기여부)
        전달방식은 요청을 전달할 방식으로 GET, POST 등의 HTTP 메소드 입력
        URL 주소는 요청을 보낼 서버의 URL 주소를 입력한다
        
*/

const searchRequest = new XMLHttpRequest()
const inputRequest = new XMLHttpRequest()

function searchFunction() {
  // encodeURIComponent(): 문자열을 유니코드로 인코딩하는 메소드
}

searchRequest.onreadystatechange = searchFunction
searchRequest.open('GET', '')
