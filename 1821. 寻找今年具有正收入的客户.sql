# 写一个 SQL 查询来查询 2021 年具有 正收入 的客户。
# 可以按 任意顺序 返回结果表。
select 
  customer_id
from
  Customers
  where sum(revenue) > 0
  and year = 2021
  group by customer_id
;
