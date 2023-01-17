package com.springboot.hibernate.services;

import com.springboot.hibernate.entities.NetworkSocial;

public interface INetworkSocialService {

  void secondLevelCache(Long id);

  void save(NetworkSocial networkSocial2);
}
