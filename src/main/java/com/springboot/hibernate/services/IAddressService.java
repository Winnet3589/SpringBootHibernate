package com.springboot.hibernate.services;

import com.springboot.hibernate.entities.Address;
import com.springboot.hibernate.services.base.IBaseService;
import org.hibernate.LockMode;

public interface IAddressService extends IBaseService<Address> {

  // Flushing
  void autoFlushingPriorToCommiting(Address address);

  void autoFlushingHqlQuery(Address address);

  void autoFlushingNativeSql(Address address);

  void commitFlushingHqlQuery(Address address);

  //optimistic lock
  Address optimisticLockingThread10sException(Long id, Address address);

  Address supportOptimisticLockingThread10sException(Long id, Address address);

  //optimistic lock
  Address pessimisticLockingFindById(Long id, Address address, String lockMode);

  Address supportPessimisticLockingUpdate(Long id, Address address);

  int supportPessimisticLockingDelete(Long id, Address address);
}
