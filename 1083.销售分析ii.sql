# https://leetcode-cn.com/problems/sales-analysis-ii/
select 
  buyer_id
from
  Sales
  join Product on Sales.product_id = Product.product_id
group by
  buyer_id
having
  count(if(Product.product_name = 'S8', 1, NULL)) > 0
  and
  count(if(Product.product_name = 'iPhone', 1, NULL)) = 0
;
