package com.springboot.hibernate.services.impl;

import com.springboot.hibernate.entities.NetworkSocial;
import com.springboot.hibernate.repositories.impl.NetworkSocialRepositoryImpl;
import com.springboot.hibernate.services.INetworkSocialService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class NetworkSocialServiceImpl implements INetworkSocialService {

  private final NetworkSocialRepositoryImpl networkSocialRepository;

  @Override
  public void secondLevelCache(Long id) {
    networkSocialRepository.secondLevelCache(id);
  }

  @Override
  public void save(NetworkSocial networkSocial) {
    networkSocialRepository.save(networkSocial);
  }

  @Override
  public List<Object> projection(String type) {
    return networkSocialRepository.projection(type);
  }
}
