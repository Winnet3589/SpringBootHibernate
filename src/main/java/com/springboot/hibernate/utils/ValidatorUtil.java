package com.springboot.hibernate.utils;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ValidatorUtil {
  public <T> void validate(T requestPayload) throws InvalidPayloadException {
    ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    Validator validator = validatorFactory.getValidator();
    Set<ConstraintViolation<T>> violations =validator.validate(requestPayload);
    if (!violations.isEmpty()) {
      final var violation = violations.iterator().next();
      final var errorPath = violation.getPropertyPath().toString();
      throw new InvalidPayloadException(errorPath);
    }
  }
}
