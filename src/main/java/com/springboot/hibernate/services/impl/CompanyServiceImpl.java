package com.springboot.hibernate.services.impl;

import com.springboot.hibernate.entities.Company;
import com.springboot.hibernate.repositories.impl.CompanyRepositoryImpl;
import com.springboot.hibernate.services.ICompanyService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements ICompanyService {

  private final CompanyRepositoryImpl companyRepository;

  @Override
  public List<Company> findAll() {
    return companyRepository.findAll(Company.class);
  }

  @Override
  public Company save(Company company) {
    return companyRepository.save(company);
  }

  @Override
  public Company findById(Long id) {
    return companyRepository.findById(id, Company.class);
  }

  @Override
  public Company update(Long id,Company company) {
    return companyRepository.update(id, company);
  }

  @Override
  public int delete(Long id) {
    return companyRepository.delete(id, Company.class);
  }
}
