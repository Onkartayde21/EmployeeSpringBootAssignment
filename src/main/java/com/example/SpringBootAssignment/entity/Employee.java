package com.example.SpringBootAssignment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


@Entity

public class Employee {
    @Id
    @Pattern(regexp = "\\d{6}", message = "Enter only numbers upto 6 digits")
    @NotBlank
    private String EmployeeId;

    @NotBlank(message = "Employee Name is required")
    private String EmployeeName;

    @Column(unique = true)
    @Pattern(regexp = "\\d{10}", message = "Mobile number must be 10 digits only")
    @NotBlank
    private String Mobile;

    @Column(unique = true)
    @Email(message = "Email must be valid")
    @NotBlank
    private String EmployeeEmail;

    @NotBlank(message = "Designation is required")
    private String Designation;


    public Employee() {
    }

    public Employee(String employeeId, String employeeName, String mobile, String employeeEmail, String designation) {
        EmployeeId = employeeId;
        EmployeeName = employeeName;
        Mobile = mobile;
        EmployeeEmail = employeeEmail;
        Designation = designation;
    }

    public String getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(String employeeId) {
        EmployeeId = employeeId;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getEmployeeEmail() {
        return EmployeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        EmployeeEmail = employeeEmail;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "EmployeeId='" + EmployeeId + '\'' +
                ", EmployeeName='" + EmployeeName + '\'' +
                ", Mobile=" + Mobile +
                ", EmployeeEmail='" + EmployeeEmail + '\'' +
                ", Designation='" + Designation + '\'' +
                '}';
    }
}
