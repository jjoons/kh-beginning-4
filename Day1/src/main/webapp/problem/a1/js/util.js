'use strict'

const D = document

/** @type {import('../types/index').CreateElements} */
const createElements = (tagName, count) => [...Array(count)].map(() => D.createElement(tagName))
