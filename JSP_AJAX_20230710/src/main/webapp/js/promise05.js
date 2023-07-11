/*
  콜백 지옥
    - 함수의 매개 변수로 넘겨지는 콜백 함수가 반복되어 코드의 들여쓰기가
      감당이 안 되는 수준으로 넘어간다
  
  콜백 함수
    - 다른 함수에 매개 변수로 함수를 넘겨준다
    - 비동기 프로그
*/

// id와 password를 입력받아서 해당 값으로 로그인하고 이에 성공하면
// 사용자 id를 받아서 그 id로 역할을 요청받아 오는 내용
class UserStorage {
  loginUser(id, password, onSuccess, onError) {
    setTimeout(() => {
      // 로그인 성공 시 callback 함수를 실행한다.
      // 그 때 매개 변수로 내가 넘겨받은 id를 다시 넘겨준다
      if (id === 'seohee' && password === 'seohee') {
        onSuccess(id)
      } else {
        onError('로그인 실패')
        // onError(new Error('not found'))
      }
    }, 2000)
  }

  // id를 입력받아서 user, admin 확인하는 함수
  getRoles(user, onSuccess, onError) {
    setTimeout(() => {
      if (user === 'seohee') {
        onSuccess({
          name: user,
          role: 'admin',
        })
      } else {
        onError('no access')
      }
    }, 1000)
  }
}

// 아이디, 패스워드 입력
const id = prompt('아이디를 입력하세요')
const pw = prompt('비밀번호를 입력하세요')

// 로그인 처리를 하기 위해서 loginUser() 함수를 실행해야 하니 클래스 객체 생성
const userStorage = new UserStorage()
userStorage.loginUser(
  id,
  pw,
  (user) => {
    // 로그인 성공 시 실행

    // 로그인에 성공하면 유저 역할 요청해서 받기
    userStorage.getRoles(
      user,
      (userWithRole) => {
        alert(`Hello ${userWithRole.name} / role: ${userWithRole.role}`)
      },
      (error) => {
        // 오류시 처리할 콜백
        console.log(error)
      },
    )
  },
  (error) => {
    // 로그인 실패 시 실행
    console.log(error)
  },
)

// 콜백 체인이 이어지는 것은 콜백 지옥이라고 한다
// 가독성이 떨어지고 디버깅하기도 쉽지 않다
