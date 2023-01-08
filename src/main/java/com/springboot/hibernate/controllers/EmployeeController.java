package com.springboot.hibernate.controllers;

import com.springboot.hibernate.entities.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.hibernate.services.impl.EmployeeServiceImpl;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeService;

	@GetMapping(value= "/employee-list")
	public List<Employee> listCustomer() {
		List<Employee> list =  employeeService.findAll();
		return list;
	}


}
