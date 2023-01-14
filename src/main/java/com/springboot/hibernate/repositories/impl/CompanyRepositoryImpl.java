package com.springboot.hibernate.repositories.impl;

import com.springboot.hibernate.entities.Company;
import com.springboot.hibernate.repositories.ICompanyRepository;
import com.springboot.hibernate.repositories.base.BaseRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CompanyRepositoryImpl extends BaseRepositoryImpl<Company> implements
    ICompanyRepository {
}
