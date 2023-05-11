export interface Forms extends HTMLCollectionOf<HTMLFormElement> {
  register_form?: HTMLFormElement
}

export interface RegisterFormElements extends HTMLFormControlsCollection {
  id?: HTMLInputElement
  password?: HTMLInputElement
  password_repeat?: HTMLInputElement
  name?: HTMLInputElement
  email?: HTMLInputElement
  nickname?: HTMLInputElement
  phone_number?: HTMLInputElement
}

export function PasswordInputListener(this: HTMLInputElement, event: Event): void
