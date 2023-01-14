package com.springboot.hibernate.repositories.impl;

import com.springboot.hibernate.entities.Employee;
import com.springboot.hibernate.repositories.IEmployeeRepository;
import com.springboot.hibernate.repositories.base.BaseRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class EmployeeRepositoryImpl extends BaseRepositoryImpl<Employee> implements
    IEmployeeRepository {

  @Override
  public Employee findByFullName(String fullName) {
    Session session = sessionFactory.getCurrentSession();
    return (Employee) session.createQuery("FROM Employee e where e.fullName = :fullName")
        .setParameter("fullName", fullName).getResultList().get(0);
  }
}
