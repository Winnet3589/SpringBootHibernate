package com.springboot.hibernate.services.impl;

import com.springboot.hibernate.entities.Employee;
import com.springboot.hibernate.repositories.impl.EmployeeRepositoryImpl;
import com.springboot.hibernate.services.IEmployeeService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService {

  private final EmployeeRepositoryImpl employeeRepository;

  @Override
  public List<Employee> findAll() {
    return employeeRepository.findAll(Employee.class);
  }

  @Override
  public Employee save(Employee employee) {
    return employeeRepository.save(employee);
  }

  @Override
  public Employee findById(Long id) {
    return employeeRepository.findById(id, Employee.class);
  }
}
