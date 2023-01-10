package com.springboot.hibernate.repositories.impl;

import com.springboot.hibernate.entities.CitizenIDCard;
import com.springboot.hibernate.repositories.ICitizenIDCardRepository;
import com.springboot.hibernate.repositories.base.BaseRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CitizenIDCardRepositoryImpl extends BaseRepositoryImpl<CitizenIDCard> implements
    ICitizenIDCardRepository {
}
