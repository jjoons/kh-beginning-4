'use strict'

void (function (D) {
  /** @type {HTMLDivElement | null} */
  const messageEl = D.querySelector('div.message')
  /** @type {HTMLDivElement | null} */
  const visibleNotLoginEl = D.querySelector('div.visible_not_login')
  /** @type {HTMLDivElement | null} */
  const visibleLoginEl = D.querySelector('div.visible_login')
  /** @type {HTMLButtonElement | null} */
  const logoutButtonEl = D.querySelector('button.logout_button')

  if (
    !(messageEl instanceof HTMLDivElement) ||
    !(visibleLoginEl instanceof HTMLDivElement) ||
    !(visibleNotLoginEl instanceof HTMLDivElement) ||
    !(logoutButtonEl instanceof HTMLButtonElement)
  ) {
    console.error('일부 요소가 없습니다', messageEl, visibleNotLoginEl, visibleLoginEl)
    return
  }

  if (account.loginAccount) {
    logoutButtonEl.addEventListener('click', function () {
      account.logout()
      location.reload()
    })

    messageEl.innerText = `${account.loginAccount.name}님 환영합니다`
    visibleNotLoginEl.hidden = true
    visibleLoginEl.hidden = false
  }
})(document)
