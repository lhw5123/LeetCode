# Solution 1
select seller_id 
from Sales
group by seller_id
having sum(price) >= all(
  select sum(price)
  from sales
  group by seller_id
);

# Solution 2
select seller_id
from Sales
group by seller_id
having sum(price) = (
  select sum(price) as total_sales
  from Sales
  group by seller_id
  order total_sales
  desc limit 1
);