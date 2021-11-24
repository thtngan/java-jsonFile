package com.example.demo.controller;

import com.example.demo.models.Employee;
import com.example.demo.service.EmployeeService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.util.List.of;


@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    private ResponseEntity<List<Employee>> getAllEmployees() throws IOException {
        return ResponseEntity.ok(employeeService.getEmployees());
    }

    @PostMapping("/addEmployee")
    public void addEmployee(@RequestBody Employee employee) throws IOException {
        ///////////
        String pathName = "../demo/src/main/resources/EmployeeList.json";
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

        File file = new File(pathName);
        InputStream inputStream = new FileInputStream(file);
        TypeReference<List<Employee>> typeReference = new TypeReference<List<Employee>>() {
        };
        List<Employee> listEmployee = objectMapper.readValue(inputStream, typeReference);
        System.out.println("Read json file successfully");
        inputStream.close();
        ///////////

        //Add employee to list
        Employee emp1 = new Employee();
		emp1.setName(employee.getName());
		emp1.setAge(employee.getAge());
		listEmployee.add(emp1);

        System.out.println(employee);


        //Write to json
        FileOutputStream outputStream = new FileOutputStream(file);
        String str = objectMapper.writeValueAsString(listEmployee);
        outputStream.write(str.getBytes());
        outputStream.close();

        System.out.println("Data append to an existing file successfully");

    }


}
