# 查询每个公司的员工薪水中位数。
# 中位数的定义：排序之后，位于序列中间的那个数。
select Id, Company, Salary
from
(
  select Id, Company, Salary,
  row_number()over(partition by Company order by Salary) as ranking, # row_number() 用来求出当前分区中的数据行号
  COUNT(Id)over(partition by Company) as cnt  # 每个公司中员工的数量
  from Employee
)a
where ranking >= cnt/2 AND ranking <= cnt/2+1
;