const words = ['spray', 'limit', 'elite', 'exuberant', 'destruction']

function callback(element) {
  console.log(element)
}

// words.filter(callback)

// words.filter(function (element) {
//   console.log(element)
// })

words.filter((element) => {
  console.log(element)
})
console.log('1. =============================================')

function callback2(element) {
  if (element.length > 6) {
    return element
  }
}

let newWords = words.filter(callback2)
console.log(newWords)
