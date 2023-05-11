// 웹 요소 가져오기

// 사용자가 입력한 내용
const todoInput = document.querySelector('#todo-input')
// 추가 버튼
const addButton = document.querySelector('#add-button')
// 할 일 리스트
const todoList = document.querySelector('#todo-list')

// 이벤트 처리
document.addEventListener('DOMContentLoaded', getLocal)
addButton.addEventListener('click', addTodo)
todoList.addEventListener('click', manageTodo)

function getLocal(e) {
  // 기본 동작 취소
  e.preventDefault()

  // 입력값을 가져와서 새로운 소스를 추가한다
  const newDiv = document.createElement('div')
  newDiv.classList.add('todo')

  const newTodo = document.createElement('li')
  newTodo.innerText = todoInput.value
  newTodo.classList.add('todo-content')

  // 맨 마지막에 새로운 태그를 추가함
  newDiv.appendChild(newTodo)

  // 로컬 스토리지에 추가한다
  saveToLocal(todoInput.value)

  // 완료
  const completeButton = document.createElement('button')
  completeButton.innerText = '완료'
  completeButton.classList.add('complete-button')
  newDiv.appendChild(completeButton)

  // 삭제
  const deleteButton = document.createElement('button')
  deleteButton.innerText = '삭제'
  deleteButton.classList.add('delete-button')
  newDiv.appendChild(deleteButton)
}

function saveToLocal(todo) {
  let todos

  if (localStorage.getItem('todos') === null) {
    todos = []
  } else {
    todos = JSON.parse(localStorage.getItem('todos'))
  }

  // 위 데이터를 하나의 배열에 저장
  // 값을 가져와서 추가하는 항목은 실제 변경된 배열에 추가한다
  todos.push(todo)

  localStorage.setItem('todos', JSON.stringify(todos))

  // ul에 자식으로 추가
  todoList.appendChild(newDiv)

  todoInput.value = ''
}

function removeLocal(todo) {
  let todos

  if (localStorage.getItem('todos') === null) {
    todos = []
  } else {
    todos = JSON.parse(localStorage.getItem('todos'))
  }

  const index = todos.indexOf(todo.children[0].innerText)

  // index번째 요소 삭제
  todos.splice(index, 1)

  // 삭제한 배열을 가지고 와서 다시 로컬 스토리지에 저장
  localStorage.setItem('todos', JSON.stringify(todos))
}

function addTodo() {}

function manageTodo() {}
