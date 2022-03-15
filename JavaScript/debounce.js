// 节流函数：一段时间内只执行一次函数，如果被重复调用，则会被忽略。
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
