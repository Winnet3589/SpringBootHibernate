package com.springboot.hibernate.repositories.impl;

import com.springboot.hibernate.entities.Company;
import com.springboot.hibernate.repositories.ICompanyRepository;
import com.springboot.hibernate.repositories.base.BaseRepositoryImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CompanyRepositoryImpl extends BaseRepositoryImpl<Company> implements
    ICompanyRepository {

  @Autowired
  protected SessionFactory sessionFactoryCompany;

  @Override
  public Company findByIdLazyEx(Long id, Class<Company> companyClass) {
    Session session = sessionFactoryCompany.openSession();
    Company c = session.load(Company.class, id);
    session.close();
    List d = c.getDepartments();
    return c;
  }
}
