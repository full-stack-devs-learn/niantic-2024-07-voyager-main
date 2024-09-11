-- 4. I want to know what category is the most popular
-- category for my best customer.

-- SELECT the Company Name, Category, and the OrderCount
-- for Save-a-lot Markets. (my best customer)
-- (the order count specifies how many times a category
-- was included in their orders)

-- sort in the order of the most ordered category to the least

-- (8 rows)

USE northwind;

SELECT c.company_name,
       cs.category_name,
       cs.category_id,
        count(cs.category_id)AS ordercount
    
FROM customers AS c
INNER JOIN  orders AS o ON c.customer_id = o.customer_id
INNER JOIN order_details AS od ON o.order_id = od.order_id
INNER JOIN products AS p ON od.product_id = p.product_id
INNER JOIN  categories AS cs ON cs.category_id = p.category_id

WHERE c.company_name= 'Save-a-lot Markets'

GROUP BY c.company_name,
         cs.category_name,
		 cs.category_id
         
ORDER BY ordercount desc       

	   
	   



