package com.springboot.hibernate.service;

import com.springboot.hibernate.entities.Address;
import java.util.List;

public interface IAddressService {
  List<Address> findAll();
}
