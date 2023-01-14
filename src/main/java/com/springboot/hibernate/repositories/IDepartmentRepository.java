package com.springboot.hibernate.repositories;

import com.springboot.hibernate.entities.Department;
import com.springboot.hibernate.repositories.base.IBaseRepository;

public interface IDepartmentRepository extends IBaseRepository<Department> {

  void insertBatch(Department department, int numberOfRecords, int batchSize);

  void insertNotBatch(Department department, int numberOfRecords, int batchSize);

  void firstLevelCacheSameSession(Long id);

  void firstLevelCacheDiffSession(Long id);
}
