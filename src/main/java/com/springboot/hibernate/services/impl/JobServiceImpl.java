package com.springboot.hibernate.services.impl;

import com.springboot.hibernate.entities.Job;
import com.springboot.hibernate.repositories.impl.JobRepositoryImpl;
import com.springboot.hibernate.services.IJobService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements IJobService {

  private final JobRepositoryImpl jobRepository;

  @Override
  public List<Job> findAll() {
    return jobRepository.findAll(Job.class);
  }

  @Override
  public Job save(Job job) {
    return jobRepository.save(job);
  }

  @Override
  public Job findById(Long id) {
    return jobRepository.findById(id, Job.class);
  }

  @Override
  public Job update(Long id, Job job) {
    return jobRepository.update(id, job);
  }

  @Override
  public int delete(Long id) {
    return jobRepository.delete(id, Job.class);
  }
}
