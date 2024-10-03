-- 3.  List of all the categories 
-- that Alfreds Futterkiste has ever ordered
-- (5 rows)

USE Northwind;

SELECT DISTINCT category_name
                
FROM customers AS customers 

INNER JOIN orders AS orders ON orders.customer_id = customers.customer_id

INNER JOIN  order_details AS od ON od.order_id = orders.order_id

INNER JOIN  products AS p ON od.product_id =p.product_id

INNER JOIN  categories AS cs ON cs.category_id = p.category_id

WHERE company_name = 'Alfreds Futterkiste';
