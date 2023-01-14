package com.springboot.hibernate.repositories.base;

import java.util.List;

public interface IBaseRepository<T> {

  List<T> findAll(Class<T> type);

  T findById(Long id, Class<T> type);

  T save(final T obj);

  T update(Long id, final T obj);

  int delete(Long id,Class<T> type);
}
