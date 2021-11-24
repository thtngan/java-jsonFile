package com.example.demo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import com.fasterxml.jackson.core.exc.*;

import java.io.*;
import java.util.List;

import com.example.demo.models.Employee;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws IOException  {
		SpringApplication.run(DemoApplication.class, args);
//		String path = "../demo/src/main/resources/EmployeeList.json";
//		List<Employee> listEmployee = readEmployee(path);
//		printEmployee(listEmployee);
//
//		//Add new employee to listEmployee
//		Employee emp1 = new Employee();
//		emp1.setName("Ryan");
//		emp1.setAge(28);
//		listEmployee.add(emp1);
//
//		writeEmployee(path, listEmployee);

	}


	private static void writeEmployee(String pathName, List<Employee> list) throws IOException {
		try {
			ObjectMapper objectMapper = new ObjectMapper();

			File file = new File(pathName);
			FileOutputStream outputStream = new FileOutputStream(file);
			String str = objectMapper.writeValueAsString(list);
			outputStream.write(str.getBytes());

			outputStream.close();


			System.out.println("Data append to an existing file successfully");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}


}
