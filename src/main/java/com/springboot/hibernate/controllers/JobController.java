package com.springboot.hibernate.controllers;

import com.springboot.hibernate.entities.Job;
import com.springboot.hibernate.service.impl.JobServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController {

	@Autowired
	private JobServiceImpl jobService;

	@GetMapping(value= "/job-list")
	public List<Job> listJob() {
		List<Job> list =  jobService.findAll();
		return list;
	}


}
