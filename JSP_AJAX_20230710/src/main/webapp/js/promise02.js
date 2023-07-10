let number = [1, 2, 3, 4, 5]
// 화살표 함수
number.forEach((v) => {
  console.log(v * 2)
})

// 익명 함수 (일반 함수)
number.forEach(function (v) {
  console.log(v * 2)
})

function one() {
  console.log('one')
}

function two(name, callback) {
  console.log('two')
  callback()
}

one()

two('seohee', one)

// 자바스크립트는 null과 undefined 타입을 제외하고 모든 것을 객체로 다룬다
// 매개 변수로 함수 이름이 들어갈 때 () 붙일 필요가 없다

// 전역 변수, 지역 변수, 콜백 함수의 파라미터로 전달 가능
// 전역 변수 (Global variable): 함수 외부에서 선언된 변수
// 지역 변수 (Local variable): 함수 내부에서 선언된 변수

let fruit = 'apple' // 전역 변수

function callbackFunction(callback) {
  let vegetable = 'tomato' // 지역 변수
  callback()
}

function eat(vegetable) {
  console.log(`fruit: ${fruit}, vegetable: ${vegetable}`)
}

callbackFunction(eat)
