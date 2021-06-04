# 编写一个 SQL 查询，来删除 Person 表中所有重复的电子邮箱，重复的邮箱里只保留 Id 最小的那个。
select p1.*
from Person p1,
  Person p2
where
  p1.Email = p2.Email
and
  p1.Id > p2.Id
;