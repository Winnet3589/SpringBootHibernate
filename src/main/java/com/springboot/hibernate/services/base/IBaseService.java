package com.springboot.hibernate.services.base;

import java.util.List;

public interface IBaseService<T> {
  List<T> findAll();
  void save(final T obj);
}
