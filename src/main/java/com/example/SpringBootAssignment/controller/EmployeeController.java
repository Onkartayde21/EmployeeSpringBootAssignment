package com.example.SpringBootAssignment.controller;

import com.example.SpringBootAssignment.entity.Employee;
import com.example.SpringBootAssignment.repository.EmployeeRespository;
import com.example.SpringBootAssignment.service.EmployeeService;
import com.example.SpringBootAssignment.service.PropertiesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRespository employeeRespository;

    @Autowired
    private PropertiesService propertiesService;

    @GetMapping("/properties")
    public Map<String, String> getApplicationProperties(){
        Map<String, String> properties = new LinkedHashMap<>();
        properties.put("Application Name : ", propertiesService.getAppName());
        properties.put("Application Version : ", propertiesService.getAppVersion());
        properties.put("Application Description : ", propertiesService.getAppDescription());
        return properties;
    }

    @GetMapping("/employees/pages")
    public List<Employee> getAllEmployees(@RequestParam(name = "page", defaultValue = "0") Integer page){
        Integer size = 2;
        Pageable pageable = PageRequest.of(page, size);
        Page<Employee> employeePage = employeeRespository.findAll(pageable);
        return employeePage.getContent();
    }
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable String employeeId){
        return employeeService.getEmployee(employeeId);
    }

    @PostMapping("/employees")
    public  void addEmployee(@Valid @RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }

    /*@PatchMapping("/employees/{employeeId}")
    public*/

    @PutMapping("/employees/{employeeId}")
    public void updateEmployee(@PathVariable String employeeId,@Valid @RequestBody Employee employee){
        employeeService.updateEmployee(employeeId, employee);
    }
    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable String employeeId){
        employeeService.deleteEmployee(employeeId);
    }
}
