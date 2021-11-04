# https://leetcode-cn.com/problems/customers-who-never-order/
select
  t1.Name Customers
from
  Customers t1
  left join Orders t2 on t1.Id = t2.CustomerId where t2.CustomerId is null
;
