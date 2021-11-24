package com.example.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import com.example.demo.models.Employee;
import com.example.demo.repository.EmployeeRepository;

import java.io.*;
import java.util.List;

@Service
public class EmployeeService {
//    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() throws IOException {
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
