declare const account: AccountObject

export interface AccountObject {
  accounts: Account[]
  loginAccount: Account | null
  get LOCAL_STORAGE_PREFIX(): string
  get ACCOUNTS_KEY(): string
  get LOGIN_ACCOUNT_KEY(): string
  initStorage(): void
  syncAccounts(): void
  syncCurrentLoginAccount(): void
  sync(): void
  addAccount(account: Account): boolean
  hasID(id: string): boolean
  login(id: string, password: string): boolean
  logout(): void
}

export interface Account {
  id: string
  password: string
  name: string
  email: string
  nickname: string
  phoneNumber: string
}
