package cmc.WebJava.DAO;

import cmc.WebJava.relations.RoleHistory;
import cmc.WebJava.relations.Employee;
import cmc.WebJava.relations.PaymentsHistory;
import cmc.WebJava.relations.Project;

import java.util.List;

public interface EmployeeDAO extends DefaultDAO<Employee, Long> {
    List<Project> getProjectsByEmployee(Long empId);

    List<PaymentsHistory> getPaymentsHistory(Long empId);

    List<RoleHistory> getRoleHistory(Long empId);
}
