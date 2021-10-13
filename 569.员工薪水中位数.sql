# 中位数的定义：排序之后，位于序列中间的那个数。
select Id, Company, Salary
from
(
  select Id, Company, Salary,
  row_number() over(partition by Company order by Salary) as ranking,
  COUNT(Id) over(partition by Company) as cnt
  from Employee
) a
where ranking >= cnt/2 AND ranking <= cnt/2+1
;