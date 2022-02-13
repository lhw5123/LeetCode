// apply 的作用：
// 可以只写一次方法，用这个方法可以动态修改执行方法的 this
Function.prototype.myApply = function (context, args) {
  context.fn = this;
  let res;
  if (!args) {
    res = context.fn();
  } else {
    res = context.fn(...args);
  }
  return res;
}
