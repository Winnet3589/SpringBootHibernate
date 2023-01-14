package com.springboot.hibernate.repositories.impl;

import com.springboot.hibernate.entities.Department;
import com.springboot.hibernate.repositories.IDepartmentRepository;
import com.springboot.hibernate.repositories.base.BaseRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DepartmentRepositoryImpl extends BaseRepositoryImpl<Department> implements
    IDepartmentRepository {
}
