package com.springboot.hibernate.repositories.impl;

import com.springboot.hibernate.entities.CitizenIDCard;
import com.springboot.hibernate.repositories.ICitizenIDCardDRepository;
import com.springboot.hibernate.repositories.base.BaseRepositoryImpl;
import org.springframework.stereotype.Repository;

@Repository
public class CitizenIDCardDRepositoryImpl extends BaseRepositoryImpl<CitizenIDCard> implements
    ICitizenIDCardDRepository {
}
