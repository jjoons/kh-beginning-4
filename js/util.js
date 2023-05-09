/** @type {import('./util').CreateElements} */
const createElements = (tagName, count) =>
  Array.from({ length: count }, () => document.createElement(tagName))
