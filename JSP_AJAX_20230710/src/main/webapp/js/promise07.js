class UserStorage {
  loginUser(id, password) {
    // 함수가 호출되면 Promise를 만들어서 리턴한다
    return new Promise((resolve, reject) => {
      setTimeout(() => {
        if (id === 'seohee' && password === 'seohee') {
          resolve(id)
        } else {
          reject('로그인 실패')
          // onError(new Error('not found'))
        }
      }, 2000)
    })
  }

  getRoles(user) {
    return new Promise((resolve, reject) => {
      setTimeout(() => {
        if (user === 'seohee') {
          resolve({
            name: user,
            role: 'admin',
          })
        } else {
          reject('권한이 없습니다')
        }
      }, 1000)
    })
  }
}

const id = prompt('아이디를 입력하세요')
const pw = prompt('비밀번호를 입력하세요')

const userStorage = new UserStorage()
userStorage
  .loginUser(id, pw)
  .then((id) => userStorage.getRoles(id))
  .then((userWithRole) => alert(`안녕하세요 ${userWithRole.name}님 권한은 ${userWithRole.role}`))
  .catch(console.log)
