USE northwind;

-- Write a script that updates the price of all products 
-- within a category by a certain percent.
-- use variables to accept the Category name and the percent increase 

INSERT INTO categories(category_name) VALUES ('Dairy Products');

SET @category_name = 'Dairy Products'
	, @percent_increase = 1.1;
    
SELECT @category_id := category_id
FROM categories
WHERE category_name = @category_name;

SELECT @category_id;

SELECT product_id
	, product_name
    , unit_price
    , (unit_price * @percent_increase) AS new_price
    , category_id
FROM products
WHERE category_id = @category_id;

UPDATE products
SET unit_price = unit_price * @percent_increase
WHERE category_id = @category_id;