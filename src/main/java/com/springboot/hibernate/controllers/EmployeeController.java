package com.springboot.hibernate.controllers;

import com.springboot.hibernate.dtos.EmployeeDto;
import com.springboot.hibernate.entities.Employee;
import com.springboot.hibernate.mappers.MapStructMapper;
import com.springboot.hibernate.services.impl.EmployeeServiceImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

	private final EmployeeServiceImpl employeeService;

	@GetMapping(value= "/employees/dto")
	public List<EmployeeDto> listEmployeeDto() {
		return MapStructMapper.INSTANCE.mapEmployeeFromEntityToDtoList(employeeService.findAll());
	}

	@GetMapping(value= "/employees")
	public List<Employee> listEmployee() {
		return employeeService.findAll();
	}

	@GetMapping(value= "/employees/{id}")
	public Employee findById(@PathVariable Long id) {
		return employeeService.findById(id);
	}
	@GetMapping(value= "/employees/dto/{id}")
	public EmployeeDto findByIdDto(@PathVariable Long id) {
		return MapStructMapper.INSTANCE.mapEmployeeFromEntityToDto(employeeService.findById(id));
	}

}
