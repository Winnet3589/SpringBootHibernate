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

  // Flush.AUTO
  @Override
  public void autoFlushingPriorToCommiting(Address address) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(address);
    log.info("Entity is in persisted state");
  }

  @Override
  public void autoFlushingHqlQuery(Address address) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(address);
    session.createQuery("from Company ").getResultList();
    session.createQuery("from Address ").getResultList();
  }

  @Override
  public void autoFlushingNativeSql(Address address) {
    Session session = sessionFactory.getCurrentSession();
    String sql = "select count(\"ID\") from \"ADDRESS\"";

    session.persist(address);
    session.createNativeQuery(sql)
        .addSynchronizedEntityClass(Address.class) // Must be add
        .getSingleResult();
  }

  // Flush.COMMIT
  @Override
  public void commitFlushingHqlQuery(Address address) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(address);
    session.createQuery("from Company ")
        .setFlushMode(FlushModeType.COMMIT)
        .getResultList();
    session.createQuery("from Address ")
        .setFlushMode(FlushModeType.COMMIT)
        .getResultList();
  }

  @Override
  public void commitFlushingNativeSql(Address address) {
    Session session = sessionFactory.getCurrentSession();
    String sql = "select count(\"ID\") from \"ADDRESS\"";

    session.persist(address);
    session.createNativeQuery(sql)
        .addSynchronizedEntityClass(Address.class) // Must be add
        .getSingleResult();
  }


  @Override
  public void alwaysFlushingHqlQuery(Address address) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(address);
    session.createQuery("from Company ")
        .setHibernateFlushMode(FlushMode.ALWAYS)
        .getResultList();
    session.createQuery("from Address ")
        .setHibernateFlushMode(FlushMode.ALWAYS)
        .getResultList();
  }

  @Override
  public void alwaysFlushingNativeSql(Address address) {
    Session session = sessionFactory.getCurrentSession();
    String sql = "select count(\"ID\") from \"ADDRESS\"";

    session.persist(address);
    session.createNativeQuery(sql).setHibernateFlushMode(FlushMode.ALWAYS).getSingleResult();
  }

  @Override
  public void manualFlushingHqlQuery(Address address) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(address);
    session.flush();// uncomment to demo
    session.createQuery("from Company ")
        .setHibernateFlushMode(FlushMode.MANUAL)
        .getResultList();
    session.createQuery("from Address ")
        .setHibernateFlushMode(FlushMode.MANUAL)
        .getResultList();
  }

  @Override
  public void manualFlushingNativeSql(Address address) {
    Session session = sessionFactory.getCurrentSession();
    String sql = "select count(\"ID\") from \"ADDRESS\"";

    session.persist(address);
    session.flush();// uncomment to demo
    session.createNativeQuery(sql).setHibernateFlushMode(FlushMode.MANUAL).getSingleResult();
  }

  @Override
  public void pessimisticFindById(Long id, LockMode lockMode) {
    Session session = sessionFactory.getCurrentSession();
    session.load(Address.class, id, lockMode);
  }
}

