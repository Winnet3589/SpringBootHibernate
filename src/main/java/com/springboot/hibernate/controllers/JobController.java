package com.springboot.hibernate.controllers;

import com.springboot.hibernate.dtos.JobDto;
import com.springboot.hibernate.entities.Job;
import com.springboot.hibernate.mappers.MapStructMapper;
import com.springboot.hibernate.services.impl.JobServiceImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JobController {

	private final JobServiceImpl jobService;

	@GetMapping(value= "/jobs/dto")
	public List<JobDto> listJobDto() {
		return MapStructMapper.INSTANCE.mapJobFromEntityToDtoList(jobService.findAll());
	}

	@GetMapping(value= "/jobs")
	public List<Job> listJob() {
		return jobService.findAll();
	}
}
