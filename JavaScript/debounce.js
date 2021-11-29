// 防抖函数
function debounce(fn, wait) {
  let timeout = null;
  return function() {
    let context = this;
    let args = arguments;
    if (timeout) {
      clearTimeout(timeout);
    }
    // setTimeout 返回的是表示定时器的 id
    timeout = setTimeout(() => {
      fn.apply(context, args);
    }, wait);
  };
}
