package com.springboot.hibernate.repositories.base;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseRepositoryImpl<T> implements IBaseRepository<T> {

  @Autowired
  private SessionFactory sessionFactory;

  public List<T> findAll(Class<T> type) {
    Session session = this.sessionFactory.getCurrentSession();
    // return session.createQuery("SELECT c FROM T c", type).getResultList();
    Query q = session.createQuery("FROM " + type.getName());
    List<T> result = q.list();
    return result;
  }

  public void save(final T obj) {
    Session session = this.sessionFactory.getCurrentSession();
    session.save(obj);
  }
}
