package com.springboot.hibernate.repositories.base;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class BaseRepositoryImpl<T> implements IBaseRepository<T> {

  @Autowired
  protected SessionFactory sessionFactory;

  public List<T> findAll(Class<T> type) {
    Session session = this.sessionFactory.getCurrentSession();
    Query q = session.createQuery("FROM " + type.getName());
    return (List<T>) q.list();
  }

  public T findById(Long id, Class<T> type) {
    Session session = this.sessionFactory.getCurrentSession();
    T t = session.load(type, id);
    return t;
  }

  public T save(final T obj) {
    Session session = this.sessionFactory.getCurrentSession();
    session.save(obj);
    return obj;
  }

  @Override
  public T update(Long id, T obj) {
    Session session = this.sessionFactory.getCurrentSession();
    session.update(obj);
    return obj;
  }

  @Override
  public int delete(Long id, Class<T> type) {
    Session session = this.sessionFactory.getCurrentSession();
    T obj = session.load(type, id);
    session.delete(obj);
    return 1;
  }
}
