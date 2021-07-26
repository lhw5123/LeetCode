/*
 *  1. 先通过 count() 找到有 5 个及以上下属的员工 id。
 *  2. 再 join Employee 表来找到对应的 Name。
 */
select 
  Name 
from 
  Employee as t1 join
  (
    select 
      ManagerId
    from 
      Employee
    group by ManagerId
    having count(ManagerId) >= 5
  ) as t2
  on t1.Id = t2.ManagerId
;
