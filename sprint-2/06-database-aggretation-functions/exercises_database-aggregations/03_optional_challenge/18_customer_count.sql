-- 18. Count the number of customers in each country
-- include the country and total_customer_count
-- (use customers table)

-- (21 rows)


SELECT country, COUNT(*) AS total_customer_count
FROM customers
GROUP BY country;
