export interface Forms extends HTMLCollectionOf<HTMLFormElement> {
  article_upload_form?: HTMLFormElement
}

export interface FormElements extends HTMLFormControlsCollection {
  article_title?: HTMLInputElement
  article_id?: HTMLInputElement
  article_password?: HTMLInputElement
  article_content?: HTMLInputElement
}
