package com.springboot.hibernate.services.impl;

import com.springboot.hibernate.entities.CitizenIDCard;
import com.springboot.hibernate.repositories.impl.CitizenIDCardRepositoryImpl;
import com.springboot.hibernate.services.ICitizenIDCardService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CitizenIDCardServiceImpl implements ICitizenIDCardService {

  private final CitizenIDCardRepositoryImpl citizenIDCardDRepository;

  @Override
  public List<CitizenIDCard> findAll() {
    return citizenIDCardDRepository.findAll(CitizenIDCard.class);
  }

  @Override
  public CitizenIDCard save(CitizenIDCard citizenIDCard) {
    return citizenIDCardDRepository.save(citizenIDCard);
  }

  @Override
  public CitizenIDCard findById(Long id) {
    return citizenIDCardDRepository.findById(id, CitizenIDCard.class);
  }

  @Override
  public CitizenIDCard update(Long id,CitizenIDCard citizenIDCard) {
    return citizenIDCardDRepository.update(id, citizenIDCard);
  }

  @Override
  public int delete(Long id) {
    return citizenIDCardDRepository.delete(id, CitizenIDCard.class);
  }
}
