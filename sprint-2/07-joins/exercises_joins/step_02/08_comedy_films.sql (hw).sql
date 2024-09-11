-- 8. Display the Category Name, and film title of all films
-- in the "Comedy" category

-- (58 rows)

USE sakila;


SELECT 
	c.name AS categoryname, 
    f.title AS filmtitle
   
FROM 
    film AS f
JOIN 
    film_category AS fc ON f.film_id = fc.film_id
JOIN 
    category AS c ON fc.category_id = c.category_id
WHERE 
    c.name = 'Comedy';

