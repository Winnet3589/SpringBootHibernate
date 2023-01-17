package com.springboot.hibernate.repositories;

import com.springboot.hibernate.entities.NetworkSocial;

public interface INetworkSocialRepository {

  void secondLevelCache(Long id);

  void save(NetworkSocial networkSocial);
}
