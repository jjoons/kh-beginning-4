/**
 * 
 * html 파일명: 테이블.html
 */

function tableAdd() {
  // 데이터 입력시 form에서 가지고 오기
  // form 배열을 이용해서 가지고 오기
  let form = document.forms[0]
  console.log(form)

  // 폼 안에서 각각의 값들을 가지고 올 것
  console.log('id: ' + form.elements.id.value)
  console.log('password: ' + form.elements.password.value)
  console.log('address: ' + form.elements.address.value)
  console.log('phoneNo: ' + form.elements.phoneNo.value)

  let values = [
    form.elements.id.value,
    form.elements.password.value,
    form.elements.address.value,
    form.elements.phoneNo.value
  ]

  // 반복문을 이용해서 배열에 있는 각각 요소에 접근해서
  // 빈 공간이면 팝업 띄우기
  for (let i = 0; i < values.length; i++) {
    let value = values[i]

    if (value === null || value === '' || value === void 0) {
      switch (i) {
        case 0:
          alert('아이디를 입력하세요')
          break

        case 1:
          alert('비밀번호를 확인하세요')
          break
      }
    }
  }
}
