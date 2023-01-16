package com.springboot.hibernate.repositories.impl;

import com.springboot.hibernate.entities.Address;
import com.springboot.hibernate.repositories.IAddressRepository;
import com.springboot.hibernate.repositories.base.BaseRepositoryImpl;
import javax.persistence.FlushModeType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.FlushMode;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class AddressRepositoryImpl extends BaseRepositoryImpl<Address> implements
    IAddressRepository {

  @Override
  public void autoFlushingPriorToCommiting(Address address) {
    Session session = sessionFactory.openSession();
    session.getTransaction().begin();
    session.persist(address);
    log.info("Entity is in persisted state");
    session.getTransaction().commit();
  }

  @Override
  public void autoFlushingHqlQuery(Address address) {
    Session session = sessionFactory.openSession();
    session.getTransaction().begin();
    session.persist(address);
    session.createQuery("from Company ").getResultList();
    session.createQuery("from Address ").getResultList();
//    session.getTransaction().commit();
  }

  @Override
  public void autoFlushingNativeSql(Address address) {
    Session session = sessionFactory.openSession();
    session.getTransaction().begin();
    String sql = "select count(\"ID\") from \"ADDRESS\"";
    session.createNativeQuery(sql)
        .getSingleResult();
    session.persist(address);
    session.createNativeQuery(sql)
        .addSynchronizedEntityClass(Address.class)
        .getSingleResult();
//    session.getTransaction().commit();
  }

  @Override
  public void commitFlushingHqlQuery(Address address) {
    Session session = sessionFactory.openSession();
    session.getTransaction().begin();
    session.persist(address);
    session.createQuery("from Company ")
        .setFlushMode(FlushModeType.COMMIT)
        .getResultList();
    session.createQuery("from Address ")
        .setFlushMode(FlushModeType.COMMIT)
        .getResultList();
  }

  @Override
  public void alwaysFlushingHqlQuery(Address address) {
    Session session = sessionFactory.openSession();
    session.getTransaction().begin();
    session.persist(address);
    session.createQuery("from Company ")
        .setHibernateFlushMode(FlushMode.ALWAYS)
        .getResultList();
    session.createQuery("from Address ")
        .setHibernateFlushMode(FlushMode.ALWAYS)
        .getResultList();
  }

  @Override
  public void manualFlushingHqlQuery(Address address) {
    Session session = sessionFactory.openSession();
    session.getTransaction().begin();
    session.persist(address);
    session.createQuery("from Company ")
        .setHibernateFlushMode(FlushMode.MANUAL)
        .getResultList();
    session.createQuery("from Address ")
        .setHibernateFlushMode(FlushMode.MANUAL)
        .getResultList();
  }

  @Override
  public Address pessimisticFindById(Long id, LockMode lockMode) {
    Session session = sessionFactory.getCurrentSession();
    return session.load(Address.class, id, lockMode);
  }
}

