ALTER TABLE payments_history
    ADD CONSTRAINT emp_id_fkey FOREIGN KEY (emp_id) REFERENCES employees(emp_id);

ALTER TABLE role_history
    ADD CONSTRAINT emp_id_fkey FOREIGN KEY (emp_id) REFERENCES employees(emp_id);

ALTER TABLE role_history
    ADD CONSTRAINT proj_id_fkey FOREIGN KEY (proj_id) REFERENCES projects(proj_id);

ALTER TABLE emp_on_proj
    ADD CONSTRAINT proj_id_fkey FOREIGN KEY (proj_id) REFERENCES projects(proj_id);

ALTER TABLE emp_on_proj
    ADD CONSTRAINT emp_id_fkey FOREIGN KEY (emp_id) REFERENCES employees(emp_id);

ALTER TABLE payments_proj
    ADD CONSTRAINT policy_id_fkey FOREIGN KEY (policy_id) REFERENCES payments_policies(policy_id);
