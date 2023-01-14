package com.springboot.hibernate.repositories.impl;

import com.springboot.hibernate.entities.Address;
import com.springboot.hibernate.repositories.IAddressRepository;
import com.springboot.hibernate.repositories.base.BaseRepositoryImpl;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    Session session = sessionFactory.getCurrentSession();
    session.persist(address);
    log.info("Entity is in persisted state");

    // session.getTransaction().commit();
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
    session.createNativeQuery(sql)
        .getSingleResult();
    session.persist(address);
    session.createNativeQuery(sql)
        .addSynchronizedEntityClass(Address.class)
        .getSingleResult();

  }

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
  public Address pessimisticFindById(Long id, LockMode lockMode) {
    Session session = sessionFactory.getCurrentSession();
    return session.load(Address.class, id, lockMode);
  }
}

