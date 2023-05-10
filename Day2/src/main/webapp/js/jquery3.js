
/*
// 이벤트 연결할 객체
    function () {}

// 웹 브라우저를 실행할 때 문서가 준비되어 있다면 팝업을 띄우겠다
    $(document).ready(function () {
      alert('싫다! 날이 너무 좋다!')
    })

    $().ready(function () {
      alert('싫다! 날이 너무 좋다!')
    })
    
    $().ready(() => {
      alert('싫다! 날이 너무 좋다!')
    })
    
    $(function () {
      alert('싫다! 날이 너무 좋다!')
    })
    
    $(() => {
      alert('싫다! 날이 너무 좋다!')
    })
*/

$(() => {
  // onclick, onchange와 같은 이벤트가 "on"으로 시작
  $('select').eq(0).change(() => {
    // select 태그의 change 이벤트 실행됨
    // option: selected는 option에서 선택된 태그를 가지고 온다
    let select = $('select:eq(0) > option:selected').eq(0).val()
    console.log(select)

    $('input:text').eq(0).val(select)
  })

  $('input[name="gender"]').click(() => {
    let check = $('input[name="gender"]:checked').val()
    console.log(check)
    
    $('input:text').eq(1).val(check)
  })
})

function choice() { }
function choice2() { }
function choice3() { }
