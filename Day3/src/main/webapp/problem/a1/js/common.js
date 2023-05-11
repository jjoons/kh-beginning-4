/** @type {import('./common').AccountObject} */
const account = {
  accounts: [],
  loginAccount: null,

  get LOCAL_STORAGE_PREFIX() {
    return '20230511_problem_a1_'
  },

  get ACCOUNTS_KEY() {
    return this.LOCAL_STORAGE_PREFIX + 'accounts'
  },

  get LOGIN_ACCOUNT_KEY() {
    return this.LOCAL_STORAGE_PREFIX + 'login_account'
  },

  initStorage() {
    const accounts = localStorage.getItem(this.ACCOUNTS_KEY)
    accounts ? (this.accounts = JSON.parse(accounts)) : this.syncAccounts()

    const currentLoginAccount = localStorage.getItem(this.LOGIN_ACCOUNT_KEY)
    currentLoginAccount && (this.loginAccount = JSON.parse(currentLoginAccount))
  },

  syncAccounts() {
    localStorage.setItem(this.ACCOUNTS_KEY, JSON.stringify(this.accounts))
  },

  syncCurrentLoginAccount() {
    this.loginAccount &&
      localStorage.setItem(this.LOGIN_ACCOUNT_KEY, JSON.stringify(this.loginAccount))
  },

  sync() {
    this.syncAccounts()
    this.syncCurrentLoginAccount()
  },

  addAccount(account) {
    return this.hasID(account.id) ? false : (this.accounts.push(account), this.sync(), true)
  },

  hasID(id) {
    for (const i of this.accounts) {
      if (i.id === id) {
        return true
      }
    }

    return false
  },

  login(id, password) {
    for (const i of this.accounts) {
      if (i.id === id && i.password === password) {
        this.loginAccount = i
        this.syncCurrentLoginAccount()

        return true
      }
    }

    return false
  },

  logout() {
    this.loginAccount = null
    localStorage.removeItem(this.LOGIN_ACCOUNT_KEY)
  },
}

account.initStorage()
