package com.springboot.hibernate.controllers;

import com.springboot.hibernate.dtos.EmployeeDto;
import com.springboot.hibernate.entities.Employee;
import com.springboot.hibernate.mappers.MapStructMapper;
import com.springboot.hibernate.services.impl.EmployeeServiceImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

	private final EmployeeServiceImpl employeeService;

	@GetMapping(value= "/employee-list-dto")
	public List<EmployeeDto> listEmployeeDto() {
		return MapStructMapper.INSTANCE.mapEmployeeFromEntityToDtoList(employeeService.findAll());
	}

	@GetMapping(value= "/employee-list")
	public List<Employee> listEmployee() {
		return employeeService.findAll();
	}

}
