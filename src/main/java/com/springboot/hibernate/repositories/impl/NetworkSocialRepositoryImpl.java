package com.springboot.hibernate.repositories.impl;

import com.springboot.hibernate.entities.NetworkSocial;
import com.springboot.hibernate.repositories.INetworkSocialRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
@Slf4j
@Transactional
public class NetworkSocialRepositoryImpl implements INetworkSocialRepository {

  @Autowired
  protected SessionFactory sessionFactory;

  @Override
  public void secondLevelCache(Long id) {
    Session session1 = sessionFactory.getCurrentSession();
    Session session2 = sessionFactory.openSession();

    NetworkSocial networkSocial1 = session1.load(NetworkSocial.class, id);
    System.out.println("networkSocial1:" + networkSocial1);

    // deleting cache objects via session object won't be useful even if we clear all sessions created by the SessionFactory that spawned it.
//    session1.evict(networkSocial1);
//    session1.clear();
//    session2.evict(networkSocial1);
//    session2.clear();
//
//    //Delete cach
//    sessionFactory.getCache().evictEntityRegion(NetworkSocial.class);

    NetworkSocial networkSocial2 = session2.load(NetworkSocial.class, id);
    System.out.println("networkSocial2:" + networkSocial2);
  }

  @Override
  public void save(NetworkSocial networkSocial) {
    Session session = this.sessionFactory.getCurrentSession();
    session.save(networkSocial);
  }

  @Override
  public List<Object> projection(String type) {
    Session session = this.sessionFactory.getCurrentSession();
    Projection projection = null;
    Criteria criteria = session.createCriteria(NetworkSocial.class);
    if ("single".equals(type)) {

      projection = Projections.property("code");
    }

    if ("multi".equals(type)) {
      projection =
          Projections.projectionList()
              .add(Projections.property("code"))
              .add(Projections.property("name"));
    }

    criteria.setProjection(projection);
    List list = criteria.list();
    return list;
  }
}

