package com.example.SpringBootAssignment;

import com.example.SpringBootAssignment.entity.Employee;
import com.example.SpringBootAssignment.repository.EmployeeRespository;
import com.example.SpringBootAssignment.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import org.springframework.boot.test.context.SpringBootTest;


import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class SpringBootAssignmentApplicationTests {

    @Mock
    private EmployeeRespository employeeRespository;


    @InjectMocks
    private EmployeeService employeeService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getEmployeesTest(){
        when(employeeRespository.findAll()).thenReturn(Stream.
                of(new Employee("321456", "Kamlesh Kumar", "7878659021", "kamlesh@gmail.com", "GET"),
                        new Employee("481245", "Raj Sharma", "9923275533", "raj@gmail.com", "GET")).collect(Collectors.toList()));
        System.out.println(employeeService.getAllEmployees());
        assertEquals(2, employeeService.getAllEmployees().size());
    }

    @Test
    public void getEmployeeByIDTest(){
        String employeeId = "198765";
        Employee employee = new Employee(employeeId, "Abhishek Shrivastav", "9923276655", "abhishek@gmail.com","GET");
        when(employeeRespository.findById(employeeId)).thenReturn(Optional.of(employee));
        System.out.println(employee);
        assertEquals(employee,employeeService.getEmployee(employeeId));
    }

    @Test
    public void addEmployeeTest(){
        Employee employee= new Employee("334455", "Praful Raj","7030213231","praful@gmail.com","GET");
        employeeService.addEmployee(employee);
        verify(employeeRespository,times(1)).save(employee);
        System.out.println(employee);
    }

    @Test
    public void updateEmployeeTest(){
        String employeeId = "334455";
        Employee employeeOld = new Employee(employeeId, "Roshan Singh", "8811220033", "roshan@gmail.com","GET");
        employeeService.addEmployee(employeeOld);
        System.out.println(employeeOld);
        Employee employeeupdate = new Employee(employeeId, "Roshan Singh", "1231234560", "roshan@gmail.com","GET");
        employeeService.updateEmployee(employeeId, employeeupdate);
        System.out.println(employeeupdate);
        verify(employeeRespository, times(1)).save(employeeupdate);
    }

    @Test
    public void deleteEmployeeTest() throws InterruptedException {
        String employeeId = "229911";
        Employee employee = new Employee(employeeId, "Avinash Yadav", "1100888221", "avinash@gmail.com","GET");
        employeeService.addEmployee(employee);
        System.out.println(employee);
        employeeService.deleteEmployee(employeeId);
        verify(employeeRespository, times(1)).deleteById(employeeId);

    }

}
