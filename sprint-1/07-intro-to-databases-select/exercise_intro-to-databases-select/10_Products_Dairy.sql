USE northwind;

-- The Product name, price and category id
-- of all dairy products

-- Expected: 10 rows

SELECT *
FROM categories;

SELECT product_name
	, unit_price
FROM products
WHERE category_id = 4;



