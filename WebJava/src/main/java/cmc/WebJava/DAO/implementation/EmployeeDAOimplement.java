package cmc.WebJava.DAO.implementation;

import cmc.WebJava.DAO.EmployeeDAO;
import cmc.WebJava.DAO.PaymentsHistoryDAO;
import cmc.WebJava.relations.*;

import cmc.WebJava.DAO.EmpOnProjDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class EmployeeDAOimplement extends DefaultDAOimplement<Employee, Long> implements EmployeeDAO {

    public EmployeeDAOimplement() {
        super(Employee.class);
    }


    @Autowired
    private EmpOnProjDAO employeeOnProjectDAO = new EmpOnProjDAOimplement();

    @Override
    public List<Project> getProjectsByEmployee(Long empId) {
        List<Project> projects = new ArrayList<>();
        for(EmpOnProj employeeOnProject : employeeOnProjectDAO.getAll()) {
            if (Objects.equals(employeeOnProject.getEmployee().getId(), empId)) {
                projects.add(employeeOnProject.getProject());
            }
        }
        return projects;
    }

    @Autowired
    private PaymentsHistoryDAO paymentsHistoryDAO = new PaymentsHistoryDAOimplement();

    @Override
    public List<PaymentsHistory> getPaymentsHistory(Long empId) {
        List<PaymentsHistory> paymentsHistories = new ArrayList<>();
        for(PaymentsHistory paymentsHistory: paymentsHistoryDAO.getAll()) {
            if (Objects.equals(paymentsHistory.getEmployee().getId(), empId)) {
                paymentsHistories.add(paymentsHistory);
            }
        }
        return paymentsHistories;
    }

    @Override
    public List<RoleHistory> getRoleHistory(Long empId) {
        return null;
    }
}