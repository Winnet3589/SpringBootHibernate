package com.springboot.hibernate.services.impl;

import com.springboot.hibernate.entities.CitizenIDCard;
import com.springboot.hibernate.repositories.impl.CitizenIDCardRepositoryImpl;
import com.springboot.hibernate.services.ICitizenIDCardDService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CitizenIDCardDServiceImpl implements ICitizenIDCardDService {

  private final CitizenIDCardRepositoryImpl citizenIDCardDRepository;

  @Override
  public List<CitizenIDCard> findAll() {
    return citizenIDCardDRepository.findAll(CitizenIDCard.class);
  }

  @Override
  public void save(CitizenIDCard obj) {
    citizenIDCardDRepository.save(obj);
  }
}
