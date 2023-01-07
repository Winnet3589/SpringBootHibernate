package com.springboot.hibernate.repositories;

import com.springboot.hibernate.entities.Employee;
import com.springboot.hibernate.repositories.base.BaseRepositoryImpl;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepositoryImpl extends BaseRepositoryImpl<Employee> implements IEmployeeRepository {

}
