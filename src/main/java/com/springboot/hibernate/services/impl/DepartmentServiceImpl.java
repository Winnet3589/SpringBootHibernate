package com.springboot.hibernate.services.impl;

import com.springboot.hibernate.entities.Department;
import com.springboot.hibernate.repositories.impl.DepartmentRepositoryImpl;
import com.springboot.hibernate.services.IDepartmentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements IDepartmentService {

  private final DepartmentRepositoryImpl departmentRepository;

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
}
