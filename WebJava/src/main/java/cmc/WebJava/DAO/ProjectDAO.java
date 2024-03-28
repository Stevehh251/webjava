package cmc.WebJava.DAO;

import cmc.WebJava.relations.Employee;
import cmc.WebJava.relations.Project;

import java.util.List;

public interface ProjectDAO extends DefaultDAO<Project, Long> {
    List<Employee> getEmployeesByProject(Long projectId);
}
