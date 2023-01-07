package com.springboot.hibernate.service;

import com.springboot.hibernate.entities.Address;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.springboot.hibernate.repositories.AddressRepositoryImpl;

@Service
@Transactional
public class AddressServiceImpl implements IAddressService {

  @Autowired
  private AddressRepositoryImpl addressRepository;

  public List<Address> findAll() {
    return addressRepository.findAll(Address.class);
  }
}
