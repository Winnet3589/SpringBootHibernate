package com.springboot.hibernate.repositories;

import com.springboot.hibernate.entities.Address;
import com.springboot.hibernate.repositories.base.BaseRepositoryImpl;
import org.springframework.stereotype.Repository;

@Repository
public class AddressRepositoryImpl extends BaseRepositoryImpl<Address> implements IAddressRepository {
}
