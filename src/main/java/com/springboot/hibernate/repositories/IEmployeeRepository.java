package com.springboot.hibernate.repositories;

import com.springboot.hibernate.entities.Employee;
import com.springboot.hibernate.repositories.base.IBaseRepository;

public interface IEmployeeRepository extends IBaseRepository<Employee> {

  Employee findByFullName(String fullName);
}
