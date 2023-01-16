package com.springboot.hibernate.services.impl;

import com.springboot.hibernate.entities.Address;
import com.springboot.hibernate.repositories.impl.AddressRepositoryImpl;
import com.springboot.hibernate.services.IAddressService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.hibernate.LockMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AddressServiceImpl implements IAddressService {

  private final AddressRepositoryImpl addressRepository;

  @Override
  public List<Address> findAll() {
    return addressRepository.findAll(Address.class);
  }

  @Override
  public Address save(Address address) {
    return addressRepository.save(address);
  }

  @Override
  public Address findById(Long id) {
    return addressRepository.findById(id, Address.class);
  }

  @Override
  public void autoFlushingPriorToCommiting(Address address) {
    addressRepository.autoFlushingPriorToCommiting(address);
  }

  @Override
  public void autoFlushingHqlQuery(Address address) {
    addressRepository.autoFlushingHqlQuery(address);
  }

  @Override
  public void autoFlushingNativeSql(Address address) {
    addressRepository.autoFlushingNativeSql(address);
  }

  @Override
  public void commitFlushingHqlQuery(Address address) {
    addressRepository.commitFlushingHqlQuery(address);
  }

  @Override
  public void alwaysFlushingHqlQuery(Address address) {
    addressRepository.alwaysFlushingHqlQuery(address);
  }

  @Override
  public void manualFlushingHqlQuery(Address address) {
    addressRepository.manualFlushingHqlQuery(address);
  }

  @Override
  public Address update(Long id, Address address) {
    Address address1 = setDataUpdate(id, address);
    return addressRepository.update(id, address1);
  }

  @Override
  public int delete(Long id) {
    return addressRepository.delete(id, Address.class);
  }

  private Address setDataUpdate(Long id, Address address) {
    Address address1 = addressRepository.findById(id, Address.class);
    address1.setCity(address.getCity());
    address1.setState(address.getState());
    address1.setCountry(address.getCountry());
    return address1;
  }

  // Optimistic
  @Override
  public Address optimisticLockingThread10sEx(Long id, Address address) {
    Address address1 = setDataUpdate(id, address);
    try {
      Thread.sleep(10000);
      return addressRepository.update(id, address1);
    } catch (InterruptedException e) {
      System.out.println(e.getStackTrace());
//      if (e instanceof HibernateOptimisticLockingFailureException){
//        System.out.println("Retry because occur HibernateOptimisticLockingFailureException");
//        optimisticLockingThread10sEx(id, address);
//      }
    }
    return null;
  }

  @Override
  public Address supportToChangeDataOptimisticLockingThread10sEx(Long id, Address address) {
    return update(id, address);
  }

  // Pessimistic
  @Override
  public Address pessimisticLockingFindById(Long id, Address address, String lockMode,
      Long numberOfRecordsFind) {
    for (int i = 0; i < numberOfRecordsFind; i++) {

      //1.Demo with lock
      // PESSIMISTIC_READ - Allows you to have a shared lock and prevent updates and deletions
      // PESSIMISTIC_WRITE - Allows you to have an exclusive lock that prevents read , updated , deleted
      // PESSIMISTIC_FORCE_INCREMENT - Same as PESSIMISTIC_WRITE and adds version attribute of version entity
      LockMode lm = LockMode.valueOf(lockMode);
      addressRepository.pessimisticFindById(id, lm);
      
      
      //2.Demo no lock
      // addressRepository.findById(id, Address.class);
    }
    return null;
  }

  @Override
  public Address supportPessimisticLockingUpdate(Long id, Address address) {
      return this.update(id, address);
  }

  @Override
  public int supportPessimisticLockingDelete(Long id, Address address) {
    return this.delete(id);
  }

}
