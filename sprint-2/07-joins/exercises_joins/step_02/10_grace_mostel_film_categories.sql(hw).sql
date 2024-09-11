-- 10. Count of films in each category
-- that GRACE MOSTEL has appeared in as an actress

-- include first_name, last_name, category_name, film_count

-- (11 rows)

USE sakila;

USE sakila;

SELECT 
    a.first_name, 
    a.last_name, 
    c.name AS category_name, 
    COUNT(f.film_id) AS film_count
FROM 
    actor AS a
JOIN 
    film_actor fa ON a.actor_id = fa.actor_id
JOIN 
    film f ON fa.film_id = f.film_id
JOIN 
    film_category fc ON f.film_id = fc.film_id
JOIN 
    category c ON fc.category_id = c.category_id
WHERE 
    a.first_name = 'Grace' 
    AND a.last_name = 'Mostel'
GROUP BY 
    a.first_name, a.last_name, c.name
ORDER BY 
    category_name;


