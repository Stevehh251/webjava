package cmc.WebJava.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import cmc.WebJava.relations.Employee;
import cmc.WebJava.relations.EmpOnProj;
import cmc.WebJava.relations.PaymentsHistory;
import cmc.WebJava.relations.PaymentsPolicies;
import cmc.WebJava.relations.Project;
import cmc.WebJava.relations.RoleHistory;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestPropertySource(locations="classpath:application.properties")
public class EmployeeDAOTest {
    @Autowired
    private EmployeeDAO employeeDAO;
    @Autowired
    private EmpOnProj emponprojDAO;
    @Autowired
    private ProjectDAO projectDAO;
    @Autowired
    private PaymentsHistoryDAO paymentshistoryDAO;
    @Autowired
    private PaymentsPoliciesDAO paymentspoliciesDAO;
    @Autowired
    private EntityManagerFactory entityManagerFactory;


    @Test
    void testUpdateEmployee() {
        Employee employee = employeeDAO.getById(1L);
        assertNotNull(employee);
        employee.setName("Britney Spears");
        employeeDAO.update(employee);
        employee = employeeDAO.getById(1L);
        assertEquals("Britney Spears", employee.getName());
    }

    @Test
    void testDeleteEmployee() {
        Employee employee = employeeDAO.getById(1L);
        assertNotNull(employee);
        employeeDAO.delete(employee);
        employee = employeeDAO.getById(1L);
        assertNull(employee);
    }

    @Test
    void testDeleteById() {
        Employee employee = employeeDAO.getById(1L);
        assertNotNull(employee);
        employeeDAO.deleteById(1L);
        employee = employeeDAO.getById(1L);
        assertNull(employee);
    }

}
