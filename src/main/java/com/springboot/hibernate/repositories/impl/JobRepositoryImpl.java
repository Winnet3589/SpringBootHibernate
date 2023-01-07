package com.springboot.hibernate.repositories.impl;

import com.springboot.hibernate.entities.Job;
import com.springboot.hibernate.repositories.IJobRepository;
import com.springboot.hibernate.repositories.base.BaseRepositoryImpl;
import org.springframework.stereotype.Repository;

@Repository
public class JobRepositoryImpl extends BaseRepositoryImpl<Job> implements
    IJobRepository {

}
