package com.springboot.hibernate.services.impl;

import com.springboot.hibernate.entities.CitizenIDCard;
import com.springboot.hibernate.repositories.impl.CitizenIDCardDRepositoryImpl;
import com.springboot.hibernate.services.ICitizenIDCardDService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CitizenIDCardDServiceImpl implements ICitizenIDCardDService {

  @Autowired
  private CitizenIDCardDRepositoryImpl addressRepository;

  @Override
  public List<CitizenIDCard> findAll() {
    return addressRepository.findAll(CitizenIDCard.class);
  }

  @Override
  public void save(CitizenIDCard obj) {
    addressRepository.save(obj);
  }
}
