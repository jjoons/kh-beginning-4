$(() => {
  $('input:checkbox[name="all"]').click(() => {
    // prop('속성이름'): 인수로 지정된 속성의 프로퍼티를 얻어온다
    let checked = $('input:checkbox[name="all"]').prop('checked')

    // prop('속성이름', 프로퍼티): 인수로 지정된 속성의 프로퍼티를 변경한다
    $('input:checkbox[name="chk"]').prop('checked', checked)
  })

  $('#confirm').on('click', function (e) {
    let totalPrice = 0
    const chks = $('input[name="chk"]:checked')
    chks.each((i, e) => {
      totalPrice += $(e).val() * 1
    })

    $('#result').text(totalPrice)
  })
})
