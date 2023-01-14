package com.springboot.hibernate.services;

import com.springboot.hibernate.entities.Department;
import com.springboot.hibernate.services.base.IBaseService;

public interface IDepartmentService extends IBaseService<Department> {

  int insertBatch(Department department, int numberOfRecords);

  int insertNotBatch(Department department, int numberOfRecords);

  void firstLevelCacheSameSession(Long id);

  void firstLevelCacheDiffSession(Long id);
}
