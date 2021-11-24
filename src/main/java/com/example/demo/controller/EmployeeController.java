package com.example.demo.controller;

import com.example.demo.models.Employee;
import com.example.demo.service.EmployeeService;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.util.List.of;


@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    private static List<Employee> getAllEmployees() throws IOException {
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
        return listEmployee;

    }


}
