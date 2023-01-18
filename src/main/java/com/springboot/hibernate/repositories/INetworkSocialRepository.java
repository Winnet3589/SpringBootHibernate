package com.springboot.hibernate.repositories;

import com.springboot.hibernate.entities.NetworkSocial;
import java.util.List;

public interface INetworkSocialRepository {

  void secondLevelCache(Long id);

  void save(NetworkSocial networkSocial);

  List<Object> projection(String type);
}
