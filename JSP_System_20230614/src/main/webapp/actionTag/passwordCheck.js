function passwordCheck(obj) {
  // 정규식 미사용 시
  // const pw = obj.password.value.trim();
  // for (let i=0; i<len; i++) {
  // 	if (pw.charAt(i) >= 'a' && pw.charAt(i) <= 'z' || pw.charAt(i) >= 'A' && pw.charAt(i) <= 'Z') {
  // 		alphaCount++;
  // 	} else if (pw.charAt(i) >= '0' && pw.charAt(i) <= '9') {
  // 		numberCount++;
  // 	} else {
  // 		etcCount++;
  // 	}
  // }
  // console.log('영문자: ' + alphaCount + '개, 숫자: ' + numberCount + '개, 특수문자: ' +
  // 	etcCount + '개');

  // if (alphaCount == 0 || numberCount == 0 || etcCount == 0) {
  // 	alert('비밀번호는 영문자, 숫자, 특수문자를 각각 1글자 이상 포함해야 합니다.')
  // 	obj.password.value = '';
  // 	obj.repassword.value = '';
  // 	obj.password.focus();
  // 	return false;
  // }

  // 입력한 비밀번호가 8자 이상이며 12자 이하인지 검사한다
  let len = obj.password.value.trim().length
  console.log(len)

  if (len < 8 || len > 12) {
    alert('비밀번호는 8자에서 12자 사이만 입력할 수 있습니다')
    obj.password.value = ''
    obj.repassword.value = ''
    obj.password.focus()

    return false
  }

  // 영문자, 숫자, 특수문자가 각각 1개 이상씩 입력되었는지 검사한다

  // 영문자 개수
  let alphaCount = 0
  // 숫자 개수
  let numberCount = 0
  // 특수문자 개수
  let etcCount = 0

  // 입력된 비밀번호의 문자 개수만큼 반복하며 영문자, 숫자, 특수문자의 개수를 센다

  // 정규 표현식(정규식)을 사용한 영문자, 대소문자, 숫자, 특수문자가 각각 1개씩 입력되고
  // 8~12자로 입력되었나 검사한다

  // new RegExp('정규식 패턴'): 자바스크립트 정규식 객체를 만든다
  // ".": 모든 문자 1글자를 대신한다
  // "*": 모든 문자 0글자 이상을 대신한다 (아무 문자가 안 나와도 되고 몇 개가 나와도 상관없다)
  // "+": 모든 문자 1글자 이상을 대신한다
  // ^: 시작하는
  // $: 끝나는

  // 글자 수 제한. 8자만 허용
  const pattern = new RegExp('^.{8}$')

  // 8자 이내만 허용한다
  const pattern2 = new RegExp('^.{1,8}$')

  // 8자 이상만 허용한다
  const pattern3 = new RegExp('^.{8,}$')

  // 8~12자 사이로만 입력
  const pattern4 = new RegExp('^.{8,12}$')

  // 숫자만 허용한다. 허용가능한 문자를 [] 안에 나열한다
  // "+"를 안 적으면 딱 1글자만 확인한다
  const pattern5 = new RegExp('^[0123456789]+$')

  // "-"를 사용해서 범위를 지정할 수 있다
  const pattern6 = new RegExp('^[0-9]+$')

  // 숫자 4글자만 허용한다. {}를 사용하면 "+", ",", "*"을 사용할 수 없다
  const pattern7 = new RegExp('^[0-9]{4}')

  //	const pattern = new RegExp('^[A-Z]+$'); // 대문자만 허용한다.
  //	const pattern = new RegExp('^[a-z]+$'); // 소문자만 허용한다.
  //	const pattern = new RegExp('^[A-Za-z]+$'); // 영문자만 허용한다.
  //	const pattern = new RegExp('^[a-zA-Z]+$'); // 영문자만 허용한다.

  //	const pattern = new RegExp('^[ㄱ-힣]+$'); // 한글만 허용한다.
  //	const pattern = new RegExp('^[!@#$%^&]+$'); // 지정된 특수문자만 허용한다.

  // 위에 있는 내용을 섞어서 조건을 완성하기
  //   영문자, 숫자, 특수문자만 8자 이상 12자 이하로 입력을 허용한다

  const pattern10 = new RegExp('^[A-Za-z0-9!@#$%^&]')

  // test(): 인수로 지정한 문자열이 정규식 패턴과 만족하는지 검사해서 만족하면 true,
  //   만족하지 않으면 false를 반환한다

  // 만족하지 않을 때 경고 띄우기
  if (!pattern10.test(pw)) {
    alert('비밀번호가 영문자, 숫자, 특수문자를 각각 1글자 이상 포함되어야 한다')
    obj.password.value = ''
    obj.repassword.value = ''
    obj.password.focus()

    return false
  }

  // 입력한 두 개의 비밀번호가 같은지 검사한다
  if (obj.password.value.trim() != obj.repassword.value.trim()) {
    alert('비밀번호가 일치하지 않습니다')
    obj.password.value = ''
    obj.repassword.value = ''
    obj.password.focus()

    return false
  }

  //	긍정형 전방 탐색 기능으로 특정 문자가 포함되어있나 검사한다. => (?=.*)
  // 전방 탐색: 패턴과 일치하지만 값으로 리턴하지 않는 정규식

  //	const pattern = new RegExp('(?=.*[0-9]+)'); // 숫자가 포함되어있나 검사한다.
  //	const pattern = new RegExp('(?=.*[A-Z]+)'); // 대문자가 포함되어있나 검사한다.
  //	const pattern = new RegExp('(?=.*[a-z]+)'); // 소문자가 포함되어있나 검사한다.
  //	const pattern = new RegExp('(?=.*[A-Za-z]+)'); // 영문자가 포함되어있나 검사한다.
  //	const pattern = new RegExp('(?=.*[ㄱ-힣]+)'); // 한글이 포함되어있나 검사한다.
  //	const pattern = new RegExp('(?=.*[!@#$%^&]+)'); // 지정된 특수문자가 포함되어있나 검사한다.

  // const pattern = new RegExp('^(?=.[0-9]+)(?=.[A-Za-z]+)(?=.*[!@#$%^&]+)[A-Za-z0-9!@#$%^&]{8,12}$')

  return true
}
