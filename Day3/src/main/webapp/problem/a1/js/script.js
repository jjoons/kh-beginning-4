'use strict'

void (function (D) {
  /** @type {import('./script').Forms} */
  const { register_form } = D.forms

  if (!register_form) {
    console.error('form이 없습니다')
    return
  }

  /** @type {import('./script').RegisterFormElements} */
  const { id, password, password_repeat, name, email, nickname, phone_number } =
    register_form.elements

  if (!id || !password || !password_repeat || !name || !email || !nickname || !phone_number) {
    console.error('다음 요소 중 하나가 없습니다', register_form.elements)
    return
  }

  const idVerifyMsgEl = id.nextElementSibling
  const passwordVerifyMsgEl = password_repeat.nextElementSibling
  const emailVerifyMsgEl = email.nextElementSibling
  const phoneNumberVerifyMsgEl = phone_number.nextElementSibling

  if (
    !(idVerifyMsgEl instanceof HTMLDivElement) ||
    !(passwordVerifyMsgEl instanceof HTMLDivElement) ||
    !(emailVerifyMsgEl instanceof HTMLDivElement) ||
    !(phoneNumberVerifyMsgEl instanceof HTMLDivElement)
  ) {
    console.error('검증 메시지 요소 중 하나가 없습니다')
    return
  }

  id.addEventListener('input', function (e) {
    console.log(this.validity)
    if (this.validity.valid && this.value.length >= 1) {
      idVerifyMsgEl.classList.remove('error')
      idVerifyMsgEl.classList.add('ok')
      idVerifyMsgEl.innerText = '정상'
    } else {
      idVerifyMsgEl.classList.remove('ok')
      idVerifyMsgEl.classList.add('error')
      idVerifyMsgEl.innerText = '8~20자 사이로 입력'
    }
  })

  /** @type {import('./script').PasswordInputListener} */
  const passwordInputListener = function (e) {
    if (
      password.value === password_repeat.value &&
      password.value.length >= 1 &&
      password_repeat.value.length >= 1
    ) {
      passwordVerifyMsgEl.classList.remove('error')
      passwordVerifyMsgEl.classList.add('ok')
      passwordVerifyMsgEl.innerText = '비밀번호가 같습니다'
    } else {
      passwordVerifyMsgEl.classList.remove('ok')
      passwordVerifyMsgEl.classList.add('error')

      if (password.value.length <= 0 && password_repeat.value.length <= 0) {
        passwordVerifyMsgEl.innerText = '비밀번호를 입력해 주시기 바랍니다'
      } else {
        passwordVerifyMsgEl.innerText = '비밀번호가 다릅니다'
      }
    }
  }

  password.addEventListener('input', passwordInputListener)
  password_repeat.addEventListener('input', passwordInputListener)

  email.addEventListener('input', function () {
    if (this.validity.valid) {
      emailVerifyMsgEl.innerText = ''
    } else if (this.value.length <= 0) {
      emailVerifyMsgEl.innerText = '이메일을 입력해 주시기 바랍니다'
    } else {
      emailVerifyMsgEl.innerText =
        '올바른 이메일 주소를 입력해 주시기 바랍니다 (예: email@example.com)'
    }
  })

  phone_number.addEventListener('input', function () {
    if (this.validity.valid) {
      phoneNumberVerifyMsgEl.innerText = ''
    } else {
      phoneNumberVerifyMsgEl.innerText =
        '휴대폰 번호를 올바르게 입력해 주시기 바랍니다 (예: 01012345678)'
    }
  })
})(document)
