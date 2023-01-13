package com.springboot.hibernate.services.impl;

import com.springboot.hibernate.repositories.impl.AddressRepositoryImpl;
import com.springboot.hibernate.entities.Address;
import com.springboot.hibernate.services.IAddressService;
import java.util.List;
import lombok.RequiredArgsConstructor;
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
}
