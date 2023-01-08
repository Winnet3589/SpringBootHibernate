package com.springboot.hibernate.services.impl;

import com.springboot.hibernate.entities.Job;
import com.springboot.hibernate.repositories.impl.JobRepositoryImpl;
import com.springboot.hibernate.services.IJobService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class JobServiceImpl implements IJobService {

  @Autowired
  private JobRepositoryImpl jobRepository;

  @Override
  public List<Job> findAll() {
    return jobRepository.findAll(Job.class);
  }

  @Override
  public void save(Job job) {
    jobRepository.save(job);
  }
}
