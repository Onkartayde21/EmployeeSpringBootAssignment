package com.example.SpringBootAssignment;

import com.example.SpringBootAssignment.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootAssignmentApplication {

	/*@Autowired
	private EmployeeService employeeService;*/

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAssignmentApplication.class, args);
	}

	/*@PostConstruct
	public void printAppInfo(){
		employeeService.printAppInfo();
	}*/

}
