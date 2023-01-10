package com.springboot.hibernate.services.impl;

import com.springboot.hibernate.entities.BankCard;
import com.springboot.hibernate.repositories.impl.BankCardRepositoryImpl;
import com.springboot.hibernate.services.IBankCardService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BankCardServiceImpl implements IBankCardService {

  private final BankCardRepositoryImpl bankCardRepository;

  @Override
  public List<BankCard> findAll() {
    return bankCardRepository.findAll(BankCard.class);
  }

  @Override
  public void save(BankCard bankCard) {
    bankCardRepository.save(bankCard);
  }
}
