'use strict'

/** @type {HTMLTableSectionElement | null} */
const tbody = D.querySelector('tbody#addtr')

/** @type {NodeListOf.<HTMLInputElement>} */
const [id, password, address, phoneNo] = D.querySelectorAll(
  'input[name="id"], input[name="password"], input[name="address"], input[name="phoneNo"]'
)

/** @type {HTMLTableRowElement[]} */
const list = []

function tableAdd() {
  if (tbody && id && password && address && phoneNo) {
    const tr = D.createElement('tr')
    const [idEl, passwordEl, addressEl, telEl, blankEl] = createElements('td', 5)

    idEl.innerText = id.value
    passwordEl.innerText = password.value
    addressEl.innerText = address.value
    telEl.innerText = phoneNo.value

    tr.append(idEl, passwordEl, addressEl, telEl, blankEl)
    tbody.append(tr)
    list.push(tr)
  }
}

function removeLast() {
  list[list.length - 1].remove()
  list.pop()
}

function removeAll() {
  list.map((e, i, a) => e.remove(), console.log(e, i, a), a.shift())
}
