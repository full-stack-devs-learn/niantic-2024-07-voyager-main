-- 20. Return the State with the most number of orders placed.
-- Include state / region and order_count.
-- (use customer_orders view)

-- do not include any orders for customers whose state/region is unknow

-- (1 rows)
-- SP   49


SELECT region,
	COUNT(DISTINCT order_id) AS orders_placed
FROM customer_orders
WHERE region IS NOT NULL
GROUP BY region
ORDER BY COUNT(*) DESC
LIMIT 1;


