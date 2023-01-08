package com.springboot.hibernate.service.impl;

import com.springboot.hibernate.entities.Address;
import com.springboot.hibernate.repositories.impl.AddressRepositoryImpl;
import com.springboot.hibernate.service.IAddressService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AddressServiceImpl implements IAddressService {

  @Autowired
  private AddressRepositoryImpl addressRepository;

  @Override
  public List<Address> findAll() {
    return addressRepository.findAll(Address.class);
  }

  @Override
  public void save(Address obj) {
    addressRepository.save(obj);
  }
}
