package com.example.SpringBootAssignment.repository;


import com.example.SpringBootAssignment.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRespository extends JpaRepository<Employee, String> {
}
