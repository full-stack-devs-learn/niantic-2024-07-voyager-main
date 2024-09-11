-- 11. The average sales amount for all sales in Europe
-- (Use the customer_orders view)

-- (1 row) approx $605.99


SELECT AVG(sales_price * quantity)
FROM customer_orders
WHERE country in ('Germany', 'Switzerland', 'France', 'Portugal', 'Finland', 'Poland', 'Ireland', 'Sweden', 'UK');



