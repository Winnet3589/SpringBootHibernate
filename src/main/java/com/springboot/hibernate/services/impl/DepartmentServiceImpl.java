package com.springboot.hibernate.services.impl;

import com.springboot.hibernate.entities.Department;
import com.springboot.hibernate.repositories.impl.DepartmentRepositoryImpl;
import com.springboot.hibernate.services.IDepartmentService;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class DepartmentServiceImpl implements IDepartmentService {

  private final DepartmentRepositoryImpl departmentRepository;
  @Autowired
  private Environment env;

  @Override
  public List<Department> findAll() {
    return departmentRepository.findAll(Department.class);
  }

  @Override
  public Department save(Department department) {
    return departmentRepository.save(department);
  }

  @Override
  public Department findById(Long id) {
    return departmentRepository.findById(id, Department.class);
  }

  @Override
  public Department update(Long id, Department department) {
    return departmentRepository.update(id, department);
  }

  @Override
  public int delete(Long id) {
    return departmentRepository.delete(id, Department.class);
  }

  @Override
  public int insertBatch(Department department, int numberOfRecords) {

    final int batchSize = Integer.parseInt(
        Objects.requireNonNull(env.getProperty("spring.jpa.properties.hibernate.jdbc.batch_size"))); // same as the JDBC batch size
    departmentRepository.insertBatch(department, numberOfRecords, batchSize);
    return findAll().size();
  }

  @Override
  public int insertNotBatch(Department department, int numberOfRecords) {
    final int batchSize = Integer.parseInt(
        Objects.requireNonNull(env.getProperty("spring.jpa.properties.hibernate.jdbc.batch_size"))); // same as the JDBC batch size
    departmentRepository.insertNotBatch(department, numberOfRecords, batchSize);
    return findAll().size();
  }

  @Override
  public void firstLevelCacheSameSession(Long id) {
    departmentRepository.firstLevelCacheSameSession(id);
  }

  @Override
  public void firstLevelCacheDiffSession(Long id) {
    departmentRepository.firstLevelCacheDiffSession(id);
  }
}
