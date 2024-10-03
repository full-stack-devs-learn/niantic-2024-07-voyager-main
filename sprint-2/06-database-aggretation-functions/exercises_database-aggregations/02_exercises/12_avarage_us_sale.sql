-- 12. The average line_item amount for all sales in the US
-- (Use the customer_orders view)
-- expect approx $748.77

-- (1 row)


SELECT AVG(sales_price * quantity) AS average_line_item
FROM customer_orders
WHERE country = 'USA';


