package com.springboot.hibernate.services;

import com.springboot.hibernate.entities.Address;
import com.springboot.hibernate.services.base.IBaseService;

public interface IAddressService extends IBaseService<Address> {

  // Flushing
  void autoFlushingPriorToCommiting(Address address);

  void autoFlushingHqlQuery(Address address);

  void autoFlushingNativeSql(Address address);

  void commitFlushingHqlQuery(Address address);

  //optimistic lock
  Address optimisticLocking_thread_10s_exception(Long id, Address address);
  Address suport_optimisticLocking_thread_10s_exception(Long id, Address address);
}
