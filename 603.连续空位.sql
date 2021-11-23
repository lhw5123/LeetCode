/*
* 你能利用表 cinema ，帮他们写一个查询语句，获取所有空余座位，并将它们按照 seat_id 排序后返回吗？
* Note: 一个表和自己连接之后得到的是笛卡尔积。
*/
select distinct
    a.seat_id
from 
    cinema a join cinema b
    on abs(a.seat_id - b.seat_id) = 1
    and a.free = true
    and b.free = true
order by
    a.seat_id
;   
