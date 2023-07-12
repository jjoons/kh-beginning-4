'use strict'

void (function (D) {
  const registerForm = D.forms.registerForm

  if (registerForm instanceof HTMLFormElement) {
    const idEl = registerForm.elements.id
    const passwordEl = registerForm.elements.password
    const passwordReEl = registerForm.elements.password_re
    const nameEl = registerForm.elements.name
    const ageEl = registerForm.elements.age
    const genderEl = registerForm.elements.gender
    const emailEl = registerForm.elements.email
    const checkIdDuplicateBtn = registerForm.elements.check_id_duplicate_btn
    const idCheckMessageEl = D.querySelector('div#idCheckMessage')
    const passwordCheckMessageEl = D.querySelector('div#passwordCheckMessage')
    const errorMessageEl = D.querySelector('div#errorMessage')

    if (
      idEl instanceof HTMLInputElement &&
      checkIdDuplicateBtn instanceof HTMLButtonElement &&
      idCheckMessageEl instanceof HTMLDivElement
    ) {
      checkIdDuplicateBtn.addEventListener('click', function () {
        if (idEl.validity.valid) {
          fetch(`register_api/check_duplicate_id`, {
            headers: {
              'X-ID': idEl.value,
            },
          })
            .then((j) => j.json())
            .then((v) => {
              if (v.isAvailable) {
                idEl.classList.remove('is-invalid')
                idEl.classList.add('is-valid')
                idCheckMessageEl.innerText = '사용 가능한 아이디입니다.'
                idCheckMessageEl.style.color = 'green'
              } else {
                idEl.classList.remove('is-valid')
                idEl.classList.add('is-invalid')
                idCheckMessageEl.innerText = v.message
                idCheckMessageEl.style.color = 'red'
              }
            })
        }
      })
    }

    if (
      passwordEl instanceof HTMLInputElement &&
      passwordReEl instanceof HTMLInputElement &&
      passwordCheckMessageEl instanceof HTMLDivElement
    ) {
      const passwordFocusoutListener = function () {
        fetch('register_api/validate_password', {
          method: 'POST',
          body: new URLSearchParams({
            password: passwordEl.value,
            password_re: passwordReEl.value,
          }),
        })
          .then((j) => j.json())
          .then((v) => {
            if (v.isValid) {
              passwordCheckMessageEl.style.color = 'green'
              passwordCheckMessageEl.innerText = '비밀번호가 일치합니다.'
            } else {
              passwordCheckMessageEl.style.color = 'red'
              passwordCheckMessageEl.innerText = v.message
            }
          })
      }

      passwordEl.addEventListener('focusout', passwordFocusoutListener)
      passwordReEl.addEventListener('focusout', passwordFocusoutListener)
    }

    if (
      idEl instanceof HTMLInputElement &&
      passwordEl instanceof HTMLInputElement &&
      passwordReEl instanceof HTMLInputElement &&
      nameEl instanceof HTMLInputElement &&
      ageEl instanceof HTMLInputElement &&
      genderEl instanceof RadioNodeList &&
      emailEl instanceof HTMLInputElement
    ) {
      registerForm.addEventListener('submit', function (e) {
        e.preventDefault()

        fetch('register_api', {
          method: 'POST',
          body: new URLSearchParams({
            id: idEl.value,
            password: passwordEl.value,
            password_re: passwordReEl.value,
            name: nameEl.value,
            age: ageEl.value,
            gender: genderEl.value,
            email: emailEl.value,
          }),
        })
          .then((j) => j.json())
          .then((v) => {
            if (v.success) {
              alert('회원가입이 완료되었습니다.')
              this.reset()
            } else {
              alert('회원가입에 실패했습니다. ' + v.message)
            }
          })
      })
    }
  }
})(document)
