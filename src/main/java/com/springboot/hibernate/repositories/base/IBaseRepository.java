package com.springboot.hibernate.repositories.base;

import java.util.List;

public interface IBaseRepository<T> {
  List<T> findAll(Class<T> type);
  void save(final T obj);
}
