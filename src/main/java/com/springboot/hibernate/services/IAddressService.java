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
  Address optimisticLockingThread10sEx(Long id, Address address);

  Address supportToChangeDataOptimisticLockingThread10sEx(Long id, Address address);

  //optimistic lock
  Address pessimisticLockingFindById(Long id, Address address, String lockMode,
      Long numberOfRecordsFind);

  Address supportPessimisticLockingUpdate(Long id, Address address);

  int supportPessimisticLockingDelete(Long id, Address address);

  void alwaysFlushingHqlQuery(Address address);

  void manualFlushingHqlQuery(Address address);
}
