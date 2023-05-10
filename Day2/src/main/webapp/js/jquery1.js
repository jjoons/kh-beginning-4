function a1() {
  // span 태그를 선택해서 속성 변경
  // document.querySelector()
  $('span').css('color', 'pink')
}

function a2() {
  $('#t1').css('color', 'red')
}

function a3() {
  $('.t2').css('color', 'blue')
}

function a4() {
  $('li > span').css('color', 'lime')
}

// 자손
function a5() {
  $('li span').css('color', 'purple')
}

// nth-child
//   같은 부모 요소를 가지는 형제 요소 중에서 특정한 순서가 있는 요소 선택

// nth-last-child: 뒤에서부터 숫자를 센다. 1부터 시작

// $('li').eq(0) === $('li:eq(0)')

//	n은 자동을 0부터 1씩 증가하는 정수이고 '+', '-', '*' 연산을 사용할 수 있다.
//	$('li:nth-child(n)').css('backgroundColor', 'dodgerblue'); // 모두 선택된다.
//	$('li:nth-child(n + 3)').css('backgroundColor', 'dodgerblue'); // 3번째 부터 모두 선택된다.
//	'' 연산도 가능한데 '' 연산자를 사용하면 안되고 숫자가 n 앞에 나와야 한다.
//	$('li:nth-child(2n)').css('backgroundColor', 'dodgerblue'); // 짝수 인덱스만 선택한다.
//	$('li:nth-child(2n + 1)').css('backgroundColor', 'dodgerblue'); // 홀수 인덱스만 선택한다.

function a6() {
  $('li:nth-child(1)').css('backgroundColor', 'red')
}

function a7() {
  $('li:first-child').css('backgroundColor', 'tomato')
}

function a8() {
  $('li:last-child').css('backgroundColor', 'yellow')
}
