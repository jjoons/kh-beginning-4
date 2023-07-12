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
const insertRequest = new XMLHttpRequest()

function searchFunction() {
  //console.log("searchFunction()");
  //console.log(document.getElementById('username').value);

  // 요청을 할 때 문자열로 나가기는 하지만 인코딩
  // encodeURIComponent() : 문자열을 유니코드로 인코딩을 하는 메서드

  let url = './AjaxSearch?name=' + encodeURIComponent(document.getElementById('username').value)
  console.log(url)
  searchRequest.open('GET', url, true)
  // send()서버로 객체 전달 send() -> get방식  send(문자열) -> post
  // 데이터 url의 일부인 쿼리스트링
  // ?~~~~)으로 전송할 경우 send() 함수의 인수를 null 을 사용한다.
  searchRequest.send(null)

  // onreadystatechange를 사용해서 ajax 요청이 완료되면 실행할 콜백 함수 이름을 지정한다.
  searchRequest.onreadystatechange = searchProcess // 함수를 작성할 때 () 를 쓰면 안된다.
}
// ajax 요청이 완료되면 실행할 콜백 함수
function searchProcess() {
  console.log('searchProcess() 요청한 ajax가 완료되면 자동으로 실행되는 함수 ')

  // xml 객체의 ready status
  // 서버로 부터 응답을 확인하기 위해서 readyState 프로퍼티
  // 0 : 아직 실행하지 않음 (xmlhttpRequest 객체를 생성됨 )
  // 1 : 로딩중         (open()메서드가 성공적으로 실행됨)
  // 2 : 로딩됨         (모든 요청에 대한 응답이 도착함)
  // 3 : 통신중         (요청한 데이터를 처리 중임)
  // 4 : 통신완료        (요청한 데이터의 처리가 완료되어 응답할 준비가 완료됨)

  // XML 객체의 status
  // 200: 수신성공
  // 3xx: 금지
  // 400: 페이지없음
  // 500: 서버 오류(백프로 문법오류,오타!,서블릿의 이름이 없을 경우!)

  // 통신이 정상적으로 완료 되었음을 확인하고 필요한 작업을 실행한다.
  if (searchRequest.readyState == 4 && searchRequest.status == 200) {
  }
}

// 페이지가 로드 되자마자 화면에 전체 데이터가 보여지게 하기위해서 onload이벤트에서
// searchFunction() 함수를 실행한다.

onload = () => searchFunction()

// ajax 입력 요청 함수
function insertFunction() {
  console.log('insertFunction()')

  // 입력된 정보를 서블릿으로 보내서 데이터베이스에서 처리할 수 있도록
  // URL 데이터를 연결해서 보내는 GET 방식으로 보내기
  let url =
    './AjaxInsert?name=' +
    encodeURIComponent(document.getElementById('name').value) +
    '&age=' +
    encodeURIComponent(document.getElementById('age').value) +
    '&gender=' +
    encodeURIComponent($('input[name="gender"]:checked').val()) +
    '&email=' +
    encodeURIComponent(document.getElementById('email').value)

  console.log(url)

  // 서버로 보내 XMLHttpRequest 객체 생성 및 설정
  insertRequest.open('GET', url, true)
  insertRequest.send(null)

  // 서버에서 요청한 데이터를 받아서 처리하고 응답해 준다
  // 그 때 연결할 콜백 함수 작성
  insertRequest.onreadystatechange = insertProcess
}

function insertProcess() {
  // 응답을 받아도 데이터가 제대로 들어왔는지 확인
  if (insertRequest.readyState == 4 && insertRequest.status == 200) {
    // 텍스트 상자 안에 있는 내용은 필요없으니 지운다
    document.getElementById('name').value = ''
    document.getElementById('age').value = ''
    document.getElementById('email').value = ''
    document.getElementById('username').value = ''

    // 서블릿에서 리턴하는 데이터를 받는다
    let result = insertRequest.responseText
    console.log(result)

    if (result == 1) {
      // 입력한 데이터가 화면에 표시되야 하므로 데이터를 얻어오는 함수를 실행한다
      alert('저장 성공')
      searchFunction()
    } else {
      alert('저장 실패')
    }
  }
}
