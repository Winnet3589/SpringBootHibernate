package com.springboot.hibernate.service;

import com.springboot.hibernate.entities.Employee;
import java.util.List;

public interface IEmployeeService {
  List<Employee> findAll();
}
