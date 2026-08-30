package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	List<Employee> employees = new ArrayList<>(
			Arrays.asList(
					new Employee(1, "John Doe", "Developer"),
					new Employee(2, "Jane Smith", "Manager"),
					new Employee(3, "Alice Johnson", "Designer")
			)
	);
	
	@GetMapping
	public List<Employee> getEmployee() {
		return employees;
	}
	
}
