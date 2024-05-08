package com.example.SpringBootAssignment.service;

import com.example.SpringBootAssignment.entity.Employee;
import com.example.SpringBootAssignment.repository.EmployeeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRespository employeeRespository;

    public ArrayList<Employee> getAllEmployees(){
        ArrayList<Employee> employeeList = new ArrayList<>();
        employeeRespository.findAll().forEach(employeeList::add);
        return employeeList;
    }

    public Employee getEmployee(String employeeId) {
        return employeeRespository.findById(employeeId).get();
    }

    public void addEmployee(Employee employee) {
        employeeRespository.save(employee);
    }

    public void updateEmployee(String employeeId,Employee employee) {
       employeeRespository.save(employee);

    }

    public void deleteEmployee(String employeeId) {
        employeeRespository.deleteById(employeeId);
    }
}
