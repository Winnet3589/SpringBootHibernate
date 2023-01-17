package com.springboot.hibernate.controllers;

import com.springboot.hibernate.services.impl.NetworkSocialServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class NetworkSocialController {

  private final NetworkSocialServiceImpl networkSocialService;

  // Second cache
  @GetMapping(value = "/networksocials/secondLevelCache/{id}")
  public ResponseEntity secondLevelCache(@PathVariable Long id) {
    networkSocialService.secondLevelCache(id);
    return ResponseEntity.ok("OK");
  }
}
