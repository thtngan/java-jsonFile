package com.example.demo;


import com.example.demo.models.Employee;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws IOException  {
		String path = "../demo/src/main/resources/EmployeeList.json";
		List<Employee> listEmployee = readEmployee(path);
		writeEmployee(listEmployee);

	}

	private static List<Employee> readEmployee(String pathName) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();

		File file = new File(pathName);
		InputStream inputStream = new FileInputStream(file);
		TypeReference<List<Employee>> typeReference = new TypeReference<List<Employee>>() {
		};
		List<Employee> listEmployee = objectMapper.readValue(inputStream, typeReference);

		return listEmployee;
	}

	private static void writeEmployee(List<Employee> list) {
		list.stream()
				.forEach(employee -> System.out.println(employee.toString()));
	}


}
