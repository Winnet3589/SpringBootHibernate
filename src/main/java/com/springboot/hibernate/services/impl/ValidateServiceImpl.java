package com.springboot.hibernate.services.impl;

import com.springboot.hibernate.entities.Company;
import com.springboot.hibernate.services.IValidateService;
import com.springboot.hibernate.utils.InvalidPayloadException;
import com.springboot.hibernate.utils.ValidatorUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ValidateServiceImpl implements IValidateService {

  private final ValidatorUtil validatorUtil;
  @Override
  public void validate(Company company) throws InvalidPayloadException {
    validatorUtil.validate(company);
  }
}
