# https://leetcode-cn.com/problems/sales-person/
select
  s.name
from
  salesperson s
where
  s.sales_id NOT IN (
    select 
      o.sales_id   
    from
      orders o
        JOIN company c ON c.com_id = o.com_id
      where
      c.name = 'RED'
  )
;
