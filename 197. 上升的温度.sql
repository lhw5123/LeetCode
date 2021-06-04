# 编写一个 SQL 查询，来查找与之前（昨天的）日期相比温度更高的所有日期的 id 。
# 返回结果 不要求顺序 。
select 
  weather.id as `Id` 
from
  weather
    join
  weather w on DATEDIFF(weather.recordDate, w.recordDate) = 1
  and weather.temperature > w.temperature;
