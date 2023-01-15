package com.springboot.hibernate.services.impl;

import com.springboot.hibernate.entities.NetworkSocial;
import com.springboot.hibernate.repositories.impl.NetworkSocialRepositoryImpl;
import com.springboot.hibernate.services.INetworkSocialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class NetworkSocialServiceImpl implements INetworkSocialService {

  private final NetworkSocialRepositoryImpl provinceRepository;

  @Override
  public void secondLevelCache(Long id) {
    provinceRepository.secondLevelCache(id);
  }

  @Override
  public void save(NetworkSocial province) {
    provinceRepository.save(province);
  }
}
