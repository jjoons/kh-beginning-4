'use strict'

void (function (D) {
  const { insertUser: insertUserFormEl } = D.forms

  if (insertUserFormEl instanceof HTMLFormElement) {
    insertUserFormEl.addEventListener('submit', function (e) {
      e.preventDefault()

      const { name, age, gender, email } = this.elements

      if (
        name instanceof HTMLInputElement &&
        age instanceof HTMLInputElement &&
        gender instanceof RadioNodeList &&
        email instanceof HTMLInputElement
      ) {
        fetch('insert_api', {
          body: new URLSearchParams({
            name: name.value,
            age: age.value,
            gender: gender.value,
            email: email.value,
          }),
          method: 'POST',
        })
          .then((r) => r.json())
          .catch((r) => {
            alert('객체로 변환 중 오류 발생')
          })
          .then((v) => {
            if (v.success) {
              alert('추가 성공')
              location.reload()
            } else {
              alert('추가 실패')
            }
          })
      }
    })
  }
})(document)

function searchFunction() {
  const searchEl = document.querySelector('input#username')
  const tbodyEl = document.querySelector('tbody#ajaxTable')

  const createTableRow = ({ idx, name, age, gender, email } = {}) => {
    if (
      typeof idx !== 'number' ||
      typeof name !== 'string' ||
      typeof age !== 'number' ||
      typeof gender !== 'string' ||
      typeof email !== 'string'
    ) {
      return null
    }

    const tr = document.createElement('tr')
    const [noEl, nameEl, ageEl, genderEl, emailEl] = Array.from({ length: 5 }, () =>
      document.createElement('td'),
    )

    noEl.innerText = idx
    nameEl.innerText = name
    ageEl.innerText = age
    genderEl.innerText = gender
    emailEl.innerText = email

    tr.append(noEl, nameEl, ageEl, genderEl, emailEl)

    return tr
  }

  if (searchEl instanceof HTMLInputElement && tbodyEl instanceof HTMLTableSectionElement) {
    fetch(`search_api?s=${encodeURIComponent(searchEl.value)}`)
      .then((v) => v.json())
      .catch((r) => {
        alert('객체 변환 실패')
      })
      .then((v) => {
        if (v.success) {
          tbodyEl.innerHTML = ''

          for (const i of v.data) {
            const tr = createTableRow(i)
            tr && tbodyEl.append(tr)
          }
        } else if (v.message) {
          tbodyEl.append(v.message)
        }
      })
  }
}
