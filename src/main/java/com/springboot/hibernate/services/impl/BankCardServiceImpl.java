package com.springboot.hibernate.service.impl;

import com.springboot.hibernate.entities.BankCard;
import com.springboot.hibernate.entities.Employee;
import com.springboot.hibernate.repositories.impl.BankCardRepositoryImpl;
import com.springboot.hibernate.repositories.impl.EmployeeRepositoryImpl;
import com.springboot.hibernate.service.IBankCardService;
import com.springboot.hibernate.service.IEmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BankCardServiceImpl implements IBankCardService {

  @Autowired
  private BankCardRepositoryImpl bankCardRepository;

  @Override
  public List<BankCard> findAll() {
    return bankCardRepository.findAll(BankCard.class);
  }

  @Override
  public void save(BankCard bankCard) {
    bankCardRepository.save(bankCard);
  }
}
