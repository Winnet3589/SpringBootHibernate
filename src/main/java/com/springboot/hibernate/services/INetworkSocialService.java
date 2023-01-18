package com.springboot.hibernate.services;

import com.springboot.hibernate.entities.NetworkSocial;
import java.util.List;

public interface INetworkSocialService {

  void secondLevelCache(Long id);

  void save(NetworkSocial networkSocial);

  List<Object> projection(String type);
}
