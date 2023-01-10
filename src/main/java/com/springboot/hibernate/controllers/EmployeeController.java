package com.springboot.hibernate.controllers;

import com.springboot.hibernate.dtos.EmployeeDto;
import com.springboot.hibernate.mappers.MapStructMapper;
import com.springboot.hibernate.services.impl.EmployeeServiceImpl;
import java.util.List;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeService;
	private MapStructMapper mapper = Mappers.getMapper(MapStructMapper.class);

	@GetMapping(value= "/employee-list")
	public List<EmployeeDto> listEmployee() {
		List<EmployeeDto> list =  MapStructMapper.INSTANCE.mapEmployeeFromEntityToDtoList(employeeService.findAll());
		return list;
	}


}
