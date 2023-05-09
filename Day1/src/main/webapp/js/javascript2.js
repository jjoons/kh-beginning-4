/*function createImg() {
  // 라디오 버튼의 value 속성값을 얻어와서 브라우저에 표시할 이미지의 경로와 이름을 사용한다

  let radios = document.getElementsByName('radioBtn')
  let radioValue = ''

  for (let radio of radios) {
    if (radio.checked) {
      radioValue = radio.value
    }
  }
  
  console.log(radioValue)
  
  // 이미지 태그를 만들고 src 속성값 저장
  let img = document.createElement('img')
  img.setAttribute('src', radioValue)
  
  let div = document.getElementById('imgView')
  
  // div 태그들을 계속 만들면 가장 마지막에 생성된 태그만 실행할 수 있도록 설정하는 키워드
  
  // div.firstElementChild // 가장 처음만든 태그 가져오기
  //   lastElementChild // 가장 마지막에 만든 태그를 가져온다
  let divImg = div.lastElementChild
  div.appendChild(divImg)
}*/

function createImg() {
//  라디오 버튼의 value 속성값을 얻어와서 브라우저에 표시할 
// 이미지의 경로와 이름으로 사용한다.
  let radios = document.getElementsByName('radioBtn');
//  console.log(radios.length);
  
  radioValue = '';
  for (let radio of radios) {
    // console.log(radio.checked);
    if (radio.checked) {
      // console.log(radio.value);
      radioValue = radio.value;
    }
  }
  console.log(radioValue);
  
//  img 태그를 만들고 src 속성값을 radioValue로 지정하면 된다.
  let img = document.createElement('img'); // <img>
//  img 태그에 이미지를 표시하기 위해서 src 속성과 속성값을 추가한다.
  img.setAttribute('src', radioValue);
//  img 태그를 넣어줄 div 태그를 얻어온다.
  let div = document.getElementById('imgView');
  
//  라디오 버튼을 선택하고 이미지 생성 버튼을 클릭할 때 마다 이미지가 
 //  변경되게 하려면 
//  기존의 img 태그를 제거하고 다시 만든 img 태그를 넣어주면 된다.
//  div 태그에 들어가있는 마지막 노드를 선택해서 제거한다.

//  firstElementChild: 첫 번째 자식 노드
//  lastElementChild: 마지막 번째 자식 노드
  let divImg = div.lastElementChild;
//  removeChild(태그): 인수로 지정된 자식 태그를 제거한다.
  div.removeChild(divImg);
  
//  div 태그에 img 태그를 자식으로 넣어준다.
  div.appendChild(img);
}

function removeImg() {
  let div = document.getElementById('imgView');
  div.innerHTML = '<br/>';
}

