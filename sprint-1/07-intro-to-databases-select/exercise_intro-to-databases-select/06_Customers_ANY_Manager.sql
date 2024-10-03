USE northwind;

-- The company name, contact name, title and phone of 
-- all customers where the contact has the word manager
-- in their title

-- Expected: 33 rows

    SELECT *
    FROM customers
    WHERE contact_title LIKE '%Manager';

