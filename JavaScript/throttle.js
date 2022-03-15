// 防抖函数：在一定时间内只执行一次函数，如果被重复调用，则重新开始计时。
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
