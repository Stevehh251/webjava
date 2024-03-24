package cmc.WebJava.DAO;

import cmc.WebJava.relations.RoleHistory;
import cmc.WebJava.relations.Employees;
import cmc.WebJava.relations.PaymentsHistory;
import cmc.WebJava.relations.Projects;

import java.util.List;

public interface EmployeesDAO extends DefaultDAO<Employees, Long> {
    List<Projects> getProjectsByEmployee(Long empId);

    List<PaymentsHistory> getPaymentsHistory(Long empId);

    List<RoleHistory> getRoleHistory(Long empId);

    List<Projects> getEmployeeProjects(Long empId);
}
