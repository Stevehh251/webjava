SELECT p.proj_id, e.emp_id, p.start_date rec_date, role
    FROM employees e JOIN emp_on_proj eop ON e.emp_id = eop.emp_id
    JOIN projects p ON eop.proj_id = p.proj_id;

SELECT p.proj_id, e.emp_id, p.start_date, NULL role
    FROM employees e JOIN emp_on_proj eop ON e.emp_id = eop.emp_id
                     JOIN projects p ON eop.proj_id = p.proj_id
    WHERE p.status = 'Closed';

SELECT p.proj_id
FROM projects p
WHERE p.status = 'Closed';