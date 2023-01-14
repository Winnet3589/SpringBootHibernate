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
  public BankCard save(BankCard bankCard) {
   return bankCardRepository.save(bankCard);
  }

  @Override
  public BankCard findById(Long id) {
    return bankCardRepository.findById(id, BankCard.class);
  }

  @Override
  public BankCard update(Long id, BankCard bankCard) {
    return bankCardRepository.update(id,bankCard);
  }

  @Override
  public int delete(Long id) {
    return bankCardRepository.delete(id, BankCard.class);
  }
}
