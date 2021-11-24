package com.example.demo.controller;

import com.example.demo.models.Employee;
import com.example.demo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    private ResponseEntity<List<Employee>> getAllEmployees() throws IOException {
        return ResponseEntity.ok(employeeService.getEmployees());
    }

    @PostMapping("/addEmployee")
    private ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) throws IOException {
       return ResponseEntity.ok(employeeService.addEmployee(employee));
    }


}
