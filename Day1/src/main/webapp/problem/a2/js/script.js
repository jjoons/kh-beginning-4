'use strict'

void (function (D) {
  /** @type {import('./util').CreateElements} */
  const createElements = createElements

  /* TODO 미완 */
  let postNumber = 1

  /**  */
  const createArticle = () => {
    const tr = D.createElement('tr')
    const [no, title, writer, date, readCount] = createElements('td', 5)

    tr.append(no, title, writer, date, readCount)
    return tr
  }

  /** @type {import('../types').Forms} */
  const { article_upload_form } = D.forms

  /** @type {HTMLTableSectionElement | null} */
  const tbody = D.querySelector('#article_list > tbody')

  if (article_upload_form) {
    article_upload_form.addEventListener('submit', function () {
      /** @type {import('../types').FormElements} */
      const { article_title, article_id, article_password, article_content } = this.elements

      if (article_title && article_id && article_password && article_content) {
      }
    })
  }
})(document)
