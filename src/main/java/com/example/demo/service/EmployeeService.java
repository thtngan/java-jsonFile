package com.example.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Service;

import com.example.demo.models.Employee;

import java.io.*;
import java.util.List;

@Service
public class EmployeeService {

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

    public Employee addEmployee(Employee employee) {
        try {
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

            //Add employee to list
            Employee emp1 = new Employee();
            emp1.setName(employee.getName());
            emp1.setAge(employee.getAge());
            listEmployee.add(emp1);

            //Write to json
            FileOutputStream outputStream = new FileOutputStream(file);
            String str = objectMapper.writeValueAsString(listEmployee);
            outputStream.write(str.getBytes());
            outputStream.close();

            System.out.println("Data append to an existing file successfully");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (StreamReadException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employee;

    }
}
