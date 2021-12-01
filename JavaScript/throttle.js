// 节流函数：一段时间内只执行一次函数，如果被重复调用，则会被忽略。
function throttle(fn, wait) {
  let pre = new Date();
  return function() {
    let context = this;
    let args = arguments;
    let now = new Date();
    if (now - pre >= wait) {
      fn.apply(context, args);
      pre = now;
    }
  };
}
