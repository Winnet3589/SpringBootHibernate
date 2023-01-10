package com.springboot.hibernate.services.impl;

import com.springboot.hibernate.entities.Job;
import com.springboot.hibernate.repositories.impl.JobRepositoryImpl;
import com.springboot.hibernate.services.IJobService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class JobServiceImpl implements IJobService {

  private final JobRepositoryImpl jobRepository;

  @Override
  public List<Job> findAll() {
    return jobRepository.findAll(Job.class);
  }

  @Override
  public void save(Job job) {
    jobRepository.save(job);
  }
}
