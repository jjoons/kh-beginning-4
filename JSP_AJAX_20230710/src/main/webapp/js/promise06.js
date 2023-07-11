// Promise 객체를 생성함과 동시에 실행되기 때문에 명령 바로 실행
const promise = new Promise((resolve, reject) => {
  // 네트워크를 통해 data를 받아오거나 파일에서 뭔가 큰 정보를 받아올 때 사용하는
  // 무거운 작업을 동기 방식으로 하면 받아오는 시간동안 다른 작업을 못 한다
  // Promise를 선언하는 순간 콜백 함수를 전달
  //   new를 object를 만들면 생성자 안에 executor라는 콜백 함수가 자동으로 실행되며
  // 데이터가 성공적으로 받아졌으면 resolve(), reject() 두가지 함수를 받아온다
  // 네트워크에서 data를 가져오는 코드를 작성하면 선언하는 순간 바로 수행
  console.log('ing')

  setTimeout(() => {
    // 정상적으로 실행되면 resolve() 함수의 인수로 리턴시킨다
    // resolve('seohee')

    // 실패 시 reject() 함수의 인수로 리턴시킨다
    reject('ing error')

    // 성공하면 promise 객체로 인수값이 넘어간다
  }, 1000)
})

promise
  .then((value) => {
    // Promise가 잘 작동했다면 value 변수에 resolve()에 넣었던 값을 가져온다
    // 내가 지정한 동작을 통해 얻어온다
    console.log(value)
  })
  .catch((error) => {
    // Promise가 실패했다면 error 변수에 reject()에 넣었던 값을 가져온다
    console.log(error)
  })
  .finally(() => {
    // 성공, 실패 여부 상관없이 가장 마지막에 동작
  })

// 메소드 체이닝
//   자바스크립트 모든 것이 객체다
//   메소드의 반환값이 객체이기 때문에 "."을 사용하면
//   연속적으로 메소드를 이용할 수 있다

// 메소드 실행 결과로 객체가 반환되면 해당 객체를 사용해서 다시 메소드 실행
// 그리고 이것을 반복하는 것
// 메소드가 이어져 있는 모습이 사슬
/* function solution() {
  var strArr = []

  strArr = strArr.split('')
  strArr = strArr.reverse()
  strArr = strArr.join('')
  return strArr
} */

// 모두 정상적일 때 (resolve)
const getHan = () =>
  new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve('닭')
    }, 1000)
  })

const getEgg = (han) =>
  new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve(`${han}: 계란`)
    }, 1000)
  })

const cook = (egg) =>
  new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve(`${egg}: 후라이`)
    }, 1000)
  })

/*
const getHen = function () {
	return new Promise(function (resolve, reject) {
		setTimeout(function () {
			resolve('암탉');
		}, 1000);
	});
}

const getEgg = function (hen) {
	return new Promise(function (resolve, reject) {
		setTimeout(function () {
			resolve(`${hen} => 달걀`);
		}, 1000);
	});
}

const getMeal = function (egg) {
	return new Promise(function (resolve, reject) {
		setTimeout(function () {
			resolve(`${egg} => 후라이`);
		}, 1000);
	});
}
*/

//
getHan().catch().then(getEgg).catch().then(cook).catch().then(console.log).catch()

// 매개 변수의 개수가 같으면 함수 이름만 써도 된다
