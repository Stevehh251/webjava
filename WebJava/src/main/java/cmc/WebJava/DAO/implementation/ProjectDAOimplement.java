package cmc.WebJava.DAO.implementation;

import cmc.WebJava.DAO.EmpOnProjDAO;
import cmc.WebJava.DAO.ProjectDAO;
import cmc.WebJava.relations.EmpOnProj;
import cmc.WebJava.relations.Employee;
import cmc.WebJava.relations.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ProjectDAOimplement extends DefaultDAOimplement<Project, Long> implements ProjectDAO {

    public ProjectDAOimplement() {
        super(Project.class);
    }

    @Autowired
    private EmpOnProjDAO empOnProjDAO = new EmpOnProjDAOimplement();

    @Override
    public List<Employee> getEmployeesByProject(Long projId) {
        List<Employee> employees = new ArrayList<>();
        for(EmpOnProj employeeOnProject : empOnProjDAO.getAll()) {
            if (Objects.equals(employeeOnProject.getProject().getId(), projId)) {
                employees.add(employeeOnProject.getEmployee());
            }
        }
        return employees;
    }
}