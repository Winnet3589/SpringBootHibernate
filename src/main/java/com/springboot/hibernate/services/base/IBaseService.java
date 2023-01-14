package com.springboot.hibernate.services.base;

import java.util.List;

public interface IBaseService<T> {
  List<T> findAll();
  T save(final T obj);
  T findById(Long id);
  T update(Long id,T obj);
}
