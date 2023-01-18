package com.springboot.hibernate.services.base;

import com.springboot.hibernate.utils.InvalidPayloadException;
import java.util.List;

public interface IBaseService<T> {
  List<T> findAll();
  T save(final T obj) throws InvalidPayloadException;
  T findById(Long id);
  T update(Long id,T obj);
  int delete(Long id);
}
