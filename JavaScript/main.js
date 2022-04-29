function hello(name) {
  console.log('hello ' + name)
  let s = '00'
  console.log(isNaN(s))
  let n = parseInt(s)
  console.log(n < 0 || n > 255)  // 性能最好
  // console.log(Number(s))  // 性能最差
}

hello('hevin')

