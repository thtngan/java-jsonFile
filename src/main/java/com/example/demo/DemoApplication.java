package com.example.demo;


import org.springframework.asm.TypeReference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.util.List;

import com.example.demo.models.Employee;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws IOException {
//		SpringApplication.run(DemoApplication.class, args);

		String path = "../demo/src/main/resources/EmployeeList.json";
		File initialFile = new File(path);
		InputStream fileInputStream = new FileInputStream(initialFile);

		InputStreamReader inputStream = new InputStreamReader(fileInputStream);
		//Creating a BufferedReader object
		BufferedReader input = new BufferedReader(inputStream);


		StringBuffer sb = new StringBuffer();
		String str;
		while((str = input.readLine())!= null){
			sb.append(str + "\n");
		}
		System.out.println(sb.toString());
	}





}
