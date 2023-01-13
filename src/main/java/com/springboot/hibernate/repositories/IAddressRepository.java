package com.springboot.hibernate.repositories;

import com.springboot.hibernate.entities.Address;
import com.springboot.hibernate.repositories.base.IBaseRepository;

public interface IAddressRepository extends IBaseRepository<Address> {

  void autoFlushingPriorToCommiting(Address address);
  void autoFlushingHqlQuery(Address address);
  void autoFlushingNativeSql(Address address);
  void commitFlushingHqlQuery(Address address);
}
