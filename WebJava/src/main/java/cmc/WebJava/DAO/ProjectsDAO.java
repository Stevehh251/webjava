package cmc.WebJava.DAO;

import cmc.WebJava.relations.Employees;
import cmc.WebJava.relations.Projects;

import java.util.List;

public interface ProjectsDAO extends DefaultDAO<Projects, Long> {
    List<Employees> getEmployeesByProject(Long projectId);
}
