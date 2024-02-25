DROP TABLE IF EXISTS emp_on_proj;
DROP TABLE IF EXISTS role_history;
DROP TABLE IF EXISTS payments_history;
DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS projects;
DROP TABLE IF EXISTS payments_policies;

CREATE TABLE employees (
    emp_id INTEGER PRIMARY KEY,
    name text NOT NULL,
    bdate date NOT NULL,
    phone_number text,
    email text,
    emp_date date NOT NULL
);

CREATE TABLE emp_on_proj (
    proj_id INTEGER,
    emp_id INTEGER,
    role text NOT NULL,
    PRIMARY KEY(proj_id, emp_id)
);

CREATE TABLE role_history (
    record_id SERIAL PRIMARY KEY,
    proj_id INTEGER NOT NULL,
    emp_id INTEGER NOT NULL,
    rec_date date NOT NULL,
    new_role text   -- If NULL -> dismissal from project
);

CREATE TABLE payments_history (
    pay_id SERIAL PRIMARY KEY,
    emp_id INTEGER NOT NULL,
    policy_id INTEGER NOT NULL,
    pay_date date NOT NULL,
    amount INTEGER NOT NULL
);

CREATE TABLE projects (
    proj_id INTEGER PRIMARY KEY,
    name text NOT NULL,
    start_date date NOT NULL,
    end_date date, -- If NULL -> no end date planned
    status text NOT NULL
);

CREATE TABLE payments_policies (
    policy_id SERIAL PRIMARY KEY,
    name text NOT NULL,
    type text NOT NULL,
    proj_id INTEGER,
    periodicity INTEGER, -- In days
    start_date date,
    end_date date,
    amount INTEGER
);
