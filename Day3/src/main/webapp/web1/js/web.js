/*
HTML 5에서 간단하게 저장할 수 있는 공간

웹 스토리지
*/

// setItem()
localStorage.setItem('name', 'seohee')
localStorage.setItem('age', '20')

// getItem()
const value = localStorage.getItem('name')
console.log(value)

// 객체를 저장한다
// 객체를 만들어도 안에 숫자값이 있으면 오류
const obj = {
  name: '이서희',
  age: 20,
  gender: '',
}

// 객체를 문자열 자체로 변경
// 웹 통신할 때 JSON 파일
const arr = [1, 2, 3]

// 객체를 JSON 문자열로 변환. stringify(변수)
const objString = JSON.stringify(obj)
const arrString = JSON.stringify(arr)

// 문자열로 변환한 데이터를 스토리지에 저장
localStorage.setItem('person', objString)
localStorage.setItem('array', arrString)

// 웹 스토리지에서 꺼내온 데이터를 원래 자료형으로 변경
let personObj2 = localStorage.getItem('person')
let arrayObj2 = localStorage.getItem('array')

const personObj = JSON.parse(personObj2)
const arrayObj = JSON.parse(arrayObj2)

console.log(personObj)
console.log(arrayObj)

// key를 가지고 구별하기 때문에 중복되는 key는 사용하기 말기
// 새로운 key로 추가되는 것이 아니라 기존에 있는 키 값에 value 값이 변경된다

// 삭제
localStorage.removeItem('name')
localStorage.removeItem('age')

console.log(localStorage.getItem('name'))
console.log(localStorage.getItem('age'))

const key1 = localStorage.key(0)
const key2 = localStorage.key(1)

console.log(key1)
console.log(key2)

for (let i = 0; i < localStorage.length; i++) {
  let key = localStorage.key(i)
  console.log(localStorage.getItem(key))
}

// for-in
for (let key in localStorage) {
  console.log(key, localStorage.getItem(key))
}

for (const i of Object.keys(localStorage)) {
  console.log(localStorage.getItem(i))
}
