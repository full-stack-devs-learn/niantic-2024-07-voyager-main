-- 7. List the names of all actors who acted in
-- the film "HUMAN GRAFFITI"

-- (4 rows)

USE sakila;

SELECT 
    CONCAT(first_name, ' ', last_name) AS actor_name

FROM actor AS a

JOIN film_actor AS fa ON fa.actor_id=a.actor_id

JOIN film AS f ON fa.film_id= f.film_id

WHERE title = 'HUMAN GRAFFITI';
