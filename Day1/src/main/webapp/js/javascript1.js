/**
 * 
 */

function elementCreate() {
  /*
   * // createAttribute('속성이름'): 특정 태그에 넣어줄 인수로 지정한 속성을 만든다.
   * let attr = document.createAttribute('style'); // style
   * //  nodeValue로 속성에 속성값을 추가한다.
   * attr.nodeValue = 'border: 2px solid blue'; // style="border: 2px solid blue"
   * //  setArrtibuteNode('속성'): 태그에 속성을 추가한다.
   * div.setAttributeNode(attr);
  
   * //  setAttribute('속성이름', '속성값'): 태그에 속성을 추가한다.
   * div.setAttribute('style', 'border: 2px solid red');
   * div.setAttribute('class', 'skyblue');
  
   * //  appendChild('추가할 태그 또는 문자열'): 인수로 지정된 태그 맨 뒤에 추가한다.
   * document.body.appendChild(div);
   */

  // 요소를 만들어서 문서에 추가한다

  // createElement('태그이름') 인수로 지정된 태그를 만든다
  let div = document.createElement('div')

  // 태그에 속성과 속성값을 추가한다
  div.setAttribute('style', 'border: 2px;')
  div.setAttribute('class', 'skyblue')

  // 만들고 속성 추가만 하면 안 되고 appendChild()로 만들어야 함
  document.body.appendChild(div)

  div.innerHTML = '<marquee>div 태그 추가</marquee>'
}
