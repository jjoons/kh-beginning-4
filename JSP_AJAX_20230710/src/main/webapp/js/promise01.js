// JSON.stringify(): 배열이나 객체를 문자열로 반환
// JSON (JavaScript Object Notation)
//   자바스크립트

let json = JSON.stringify(true)
console.log(true)
console.log(json)
console.log('1. ======================')

json = JSON.stringify(['apple', 'banana'])
console.log(['apple', 'banana'])
console.log(json)
console.log('2. ========================')

// JavaScript 객체
const rabbit = {
  name: '토끼',
  color: '회식',
  size: '겁나큼',
  // 자바스크립트 객체나 함수는 stringify() 함수로 JSON 형태로 변환시킬 수 없다
  birthDate: new Date(),
  jump: () => console.log('jump'),
}

// 폼 데이터를 JSON 문자열로 전송하려면 formData 객체로 폼 데이터 전체를 가져온 후
// 변환하는 루프문으로 처리해서 객체 배열로 가공해야 한다
console.log(rabbit)

// JSON은 key 부분이 반드시 큰 따옴표를 사용하는 문자열로 바꿔야 한다
json = JSON.stringify(rabbit)
console.log(json)
console.log('3. =====================================')

// stringify() 함수의 2번째 인수로 json으로 변환할 속성을 배열로 지정할 수도 있다
json = JSON.stringify(rabbit, ['name', 'color'])
console.log(json)
console.log('4. ==================================')

// 공공 API
//   개발자 센터와 데이터를 JSON 형태로 주고 받고

// 2번째 인수로 콜백 함수 (함수의 매개 변수로 함수가 들어간다)
json = JSON.stringify(rabbit, (key, value) => {
  console.log(`key: ${key}, value: ${value}`)
  return key == 'name' ? '별주부' : value
})
console.log(json)
console.log('5. ===========================================')

// 데이터를 문자열로 변환해서 보낸다
// 응답이 오면 JSON의 문자열 형태로 온다
// JSON 데이터 타입
//   Number 숫자형, String 문자열, boolean, Array, Object, null

let booklistobj = {
  booklist: [
    {
      title: '삼국지',
      author: '나관종',
    },
    {
      title: '다빈치코드',
      author: '덴 브라운',
    },
  ],
}

// booklistobj.booklist[0].title
// JSON 객체로 온 것을 JavaScript 객체로 변환
// parse()
console.log(json)
const obj = JSON.parse(json)
console.log(obj)

// 자바스크립트 객체의 함수는 JSON으로 변환시킬 수 없다
// JSON에 포함된 날짜도 문자열 형태이므로 객체로 변환시킬 수 없다
const obj2 = JSON.parse(json, function (key, value) {
  console.log(`key: ${key}, value: ${value}`)

  return key == 'birthDate' ? new Date() : value
})
console.log(obj2)
