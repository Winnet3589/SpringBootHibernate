package com.springboot.hibernate.service.impl;

import com.springboot.hibernate.entities.Employee;
import com.springboot.hibernate.repositories.impl.EmployeeRepositoryImpl;
import com.springboot.hibernate.service.IEmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {

  @Autowired
  private EmployeeRepositoryImpl employeeRepository;

  @Override
  public List<Employee> findAll() {
    return employeeRepository.findAll(Employee.class);
  }

  @Override
  public void save(Employee employee) {
    employeeRepository.save(employee);
  }
}
