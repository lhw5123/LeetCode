# https://leetcode-cn.com/problems/department-top-three-salaries/
# 部门里前三高的薪水，意味着有不超过 3 个工资比这些值大。
select
  d.Name as 'Department', e1.Name as 'Employee', e1.Salary
from
  Employee e1
  join
  Department d
  on
  e1.DepartmentId = d.Id
where
  3 > (
    select count(distinct e2.Salary)
    from
      Employee e2
    where
      e2.Salary > e1.Salary and e2.DepartmentId = e1.DepartmentId
  )
;
