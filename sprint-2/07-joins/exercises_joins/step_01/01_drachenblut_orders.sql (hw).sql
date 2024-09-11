-- 1. The Company Name, Order Id, Order Date and Shipped Date
-- for all orders that were placed by Drachenblut Delikatessen. 
-- Order the results by shipped date, newest to oldest.
-- (6 rows)


SELECT company_name,
       order_id, 
       shipped_date,
       order_date
       
FROM customers AS c
 
INNER JOIN orders AS o ON c.customer_id = o.customer_id

WHERE c.company_name ='Drachenblut Delikatessen'

ORDER BY shipped_date DESC
		   
       
       
       


       

