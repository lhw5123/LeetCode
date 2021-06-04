# 将 table 中的行转成列。
# 一个数字和 null 做 min 计算，返回的是数字。
select
  product_id,
  min(case store when 'store1' then price else null end) as store1,
  min(case store when 'store2' then price else null end) as store2,
  min(case store when 'store3' then price else null end) as store3
from Products
group by product_id;