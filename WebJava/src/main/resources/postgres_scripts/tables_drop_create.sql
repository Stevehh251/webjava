DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS emp_on_proj;
DROP TABLE IF EXISTS role_history;
DROP TABLE IF EXISTS payments_history;
DROP TABLE IF EXISTS projects;
DROP TABLE IF EXISTS payments_policies;

CREATE TABLE employees (
    emp_id INTEGER PRIMARY KEY,
    name text NOT NULL,
    bdate date NOT NULL,
    phone_number text,
    email text,
    emp_date date
);

CREATE TABLE emp_on_proj (
    proj_id INTEGER,
    emp_id INTEGER,
    role text,
    PRIMARY KEY(proj_id, emp_id)
);

CREATE TABLE role_history (
    record_id INTEGER PRIMARY KEY,
    proj_id INTEGER,
    emp_id INTEGER,
    rec_date date,
    prev_role text,
    new_role text
);

CREATE TABLE payments_history (
    pay_id INTEGER PRIMARY KEY,
    emp_id INTEGER,
    pay_date date,
    amount INTEGER
);

CREATE TABLE projects (
    proj_id INTEGER PRIMARY KEY,
    name text,
    start_date date,
    end_date date,
    status text
);

CREATE TABLE payments_policies (
    policy_id INTEGER PRIMARY KEY,
    name text,
    type text,
    proj_id INTEGER,
    periodicity text,
    start_date date,
    end_date date,
    status text
);

COPY employees FROM '/tmp/employees.csv' WITH (FORMAT csv);
COPY projects FROM '/tmp/projects.csv' WITH (FORMAT csv);