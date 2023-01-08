package com.springboot.hibernate.service.base;

import java.util.List;

public interface IBaseService<T> {
  List<T> findAll();
  void save(final T obj);
}
