'use strict'

$(function ($) {
  const mobileMenuEl = $('.__mobile_menu')
  mobileMenuEl.addClass('on')

  $('header .__main_header .__menu_button > button').on('click', function (e) {
    const a = $('.__mobile_menu')
    a.toggleClass('on')
  })

  $('header .__mobile_menu >.__mobile_menu_close_button').on('click', function () {
    const a = $('.__mobile_menu')
    a.removeClass('on')
  })
})
