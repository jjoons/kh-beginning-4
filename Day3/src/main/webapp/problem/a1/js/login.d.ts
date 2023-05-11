export interface LoginForms extends HTMLCollectionOf<HTMLFormElement> {
  login_form?: HTMLFormElement
}

export interface LoginFormElements extends HTMLFormControlsCollection {
  id?: HTMLInputElement
  password?: HTMLInputElement
  login_button?: HTMLButtonElement
}
