// async 키워드를 함수 앞에 붙이면 함수 내부의 코드가 자동으로 Promise 객체로 변한다
async function fetchUser() {
  return '홍길동'
}

const user = fetchUser()
console.log('user: ' + user)

// await
function delay(ms) {
  return new Promise((r) => setTimeout(r, ms))
}

// async를 붙여서 Promise를 리턴하도록 설정한 getApple() 함수는
// await에 의해서 delay() 함수가 끝나기까지 기다리다가 delay()가 종료되면 Promise를 리턴한다

// await 키워드는 async가 붙은 함수에서만 사용할 수 있고 await를 붙여준 함수가 완전히
// 끝나기를 기다렸다가 다음 작업을 실행한다.

async function getApple() {
  await delay(2000)
  return '사과'
}

const apple = getApple()
console.log('apple:', apple)
apple.then((r) => {
  console.log('apple response: ', r)
})

async function getBanana() {
  await delay(1000)
  return '바나나'
}

async function pickFruits() {
  const applePromise = getApple()
  const bananaPromise = getBanana()
  // 병렬 처리를 하기 위해서 Promise는 선언한 순간 바로 실행

  const apple = await applePromise
  const banana = await bananaPromise

  return `${apple} + ${banana}`
}

pickFruits().then((v) => {
  console.log('pickFruits', v)
})
