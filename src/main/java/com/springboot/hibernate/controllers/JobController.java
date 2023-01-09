package com.springboot.hibernate.controllers;

import com.springboot.hibernate.dtos.JobDto;
import com.springboot.hibernate.mappers.MapStructMapper;
import com.springboot.hibernate.services.impl.JobServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController {

	@Autowired
	private JobServiceImpl jobService;

	@GetMapping(value= "/job-list")
	public List<JobDto> listJob() {
		List<JobDto> list =  MapStructMapper.INSTANCE.mapJobFromEntityToDtoList(jobService.findAll());
		return list;
	}


}
