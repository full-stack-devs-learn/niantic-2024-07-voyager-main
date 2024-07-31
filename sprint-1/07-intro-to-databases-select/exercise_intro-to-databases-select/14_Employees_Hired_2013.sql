USE northwind;

-- The employee name and title
-- of all employees who were hired
-- in 2013

-- Expected: 3 rows

    select *
    from employees
    where hire_date between '2013-01-01' and '2013-12-31';

