package com.springboot.hibernate.service;

import com.springboot.hibernate.entities.Employee;
import com.springboot.hibernate.repositories.EmployeeRepositoryImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {

  @Autowired
  private EmployeeRepositoryImpl employeeRepository;

  public List<Employee> findAll() {
    return employeeRepository.findAll(Employee.class);
  }
}
