package com.springboot.hibernate.services;

import com.springboot.hibernate.utils.InvalidPayloadException;

public interface IValidateService {
  <T> void validate(T payload) throws InvalidPayloadException;
}
