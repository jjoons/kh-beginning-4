/*
  동기적 함수 처리: 순서대로 실행한다
*/
console.log('1')
console.log('2')
console.log('3')

// 위 처럼 1 2 3 순서대로 실행해서 출력한다
// 비동기 방식 처리
//   setTimeout(함수, 시간): 지정한 시간이 경과된 후 함수를 실행한다
console.log('a')
setTimeout(function () {
  console.log('b')
}, 1000)
console.log('c')

// 실행 결과는 ac b 비동기 방식으로 실행해서 1초 후 출력한다
// 비동기식 처리를 사용하는 이유

// 동기적 콜백
//   변수에 var를 붙여서 선언하거나 함수가 선언되면 호이스팅에 의해서 맨 위로 올라간다
printImmdiately(() => console.log('hello'))

function printImmdiately(print) {
  print()
}

// 비동기적 콜백
printWithDelay(() => console.log('callback'), 1000)

function printWithDelay(print, timeout) {
  setTimeout(print, timeout)
}

// 호이스팅
//   인터프리터가 변수와 함수의 메모리 공간을 선언하기 전에 미리 할당하는 것
//   var로 선언한 변수의 경우 호이스팅 시 undefined로 변수를 초기화한다
