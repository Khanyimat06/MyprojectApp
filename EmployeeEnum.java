/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.employeeenum;
import java.util. * ;
/**
 *
 * @author mathebulakhanyisani
 */

// Step 1: Create an enum for employee types
enum EmployeeType {
    FIXED,
    PERMANENT,
    TEMPORARY
}

// Step 2: Employee class with enum as a field
class Employee {
    private int employeeNumber;
    private String name;
    private String idNumber;
    private EmployeeType type; // using the enum here

    // Constructor
    public Employee(int employeeNumber, String name, String idNumber, EmployeeType type) {
        this.employeeNumber = employeeNumber;
        this.name = name;
        this.idNumber = idNumber;
        this.type = type;
    }

    // Method to display employee details
    public void displayDetails() {
        System.out.println("Employee Number: " + employeeNumber);
        System.out.println("Name: " + name);
        System.out.println("ID Number: " + idNumber);
        System.out.println("Appointment Type: " + type);
        System.out.println("-----------------------------");
    }
}

// Step 3: Main class to test
public class EmployeeEnum {
    public static void main(String[] args) {
        // Create an array of Employees
        Employee[] employees = new Employee[3];

        employees[0] = new Employee(101, "Thabo Mokoena", "9001015001087", EmployeeType.PERMANENT);
        employees[1] = new Employee(102, "Sarah Jones", "9203056002088", EmployeeType.FIXED);
        employees[2] = new Employee(103, "Lindiwe Dlamini", "9807127003099", EmployeeType.TEMPORARY);

        // Loop through array and print details using the enum
        System.out.println("=== Employee Details ===");
        for (Employee emp : employees) {
            emp.displayDetails();
        }
    }
}