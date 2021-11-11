# https://leetcode-cn.com/problems/biggest-single-number/
select SUM(num)
from (
  select num
  from MyNumbers
  group by num
  having count(num) = 1
  order by num desc
  limit 0, 1
)
;