package com.springboot.hibernate.services;

import com.springboot.hibernate.entities.Company;
import com.springboot.hibernate.utils.InvalidPayloadException;

public interface IValidateService {

  void validate(Company company) throws InvalidPayloadException;
}
