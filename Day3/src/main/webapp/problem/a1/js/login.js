'use strict'

void (function (D) {
  /** @type {import('./login').LoginForms} */
  const { login_form } = D.forms

  if (!login_form) {
    console.error('폼이 없습니다')
    return
  }

  /** @type {import('./login').LoginFormElements} */
  const { id, password, login_button } = login_form.elements

  if (
    !(id instanceof HTMLInputElement) ||
    !(password instanceof HTMLInputElement) ||
    !(login_button instanceof HTMLButtonElement)
  ) {
    console.error('요소가 없거나 다릅니다')
    return
  }

  login_form.addEventListener('submit', function (e) {
    e.preventDefault()

    if (account.login(id.value, password.value)) {
      location.href = 'main.html'
    } else {
      alert('아이디나 비밀번호를 잘못 입력하셨습니다')
    }
  })
})(document)
