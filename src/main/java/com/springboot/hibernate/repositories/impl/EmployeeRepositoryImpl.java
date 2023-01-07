package com.springboot.hibernate.repositories.impl;

import com.springboot.hibernate.entities.Employee;
import com.springboot.hibernate.repositories.IEmployeeRepository;
import com.springboot.hibernate.repositories.base.BaseRepositoryImpl;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepositoryImpl extends BaseRepositoryImpl<Employee> implements
    IEmployeeRepository {

}
