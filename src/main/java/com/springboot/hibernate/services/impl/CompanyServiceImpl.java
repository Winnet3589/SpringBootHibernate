package com.springboot.hibernate.services.impl;

import com.springboot.hibernate.entities.Company;
import com.springboot.hibernate.repositories.ICompanyRepository;
import com.springboot.hibernate.services.ICompanyService;
import com.springboot.hibernate.utils.InvalidPayloadException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CompanyServiceImpl implements ICompanyService {

  private final ICompanyRepository companyRepository;
  private final ValidateServiceImpl validateService;

  @Override
  public List<Company> findAll() {
    return companyRepository.findAll(Company.class);
  }

  @Override
  public Company save(Company company) throws InvalidPayloadException {

    validateService.validate(company);
    return companyRepository.save(company);
  }

  @Override
  public Company findById(Long id) {
    return companyRepository.findById(id, Company.class);
  }

  @Override
  public Company findByIdLazyEx(Long id) {
    return companyRepository.findByIdLazyEx(id, Company.class);
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
