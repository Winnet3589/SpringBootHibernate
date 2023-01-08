package com.springboot.hibernate.configs;

import com.springboot.hibernate.entities.Address;
import com.springboot.hibernate.entities.BankCard;
import com.springboot.hibernate.entities.Employee;
import com.springboot.hibernate.entities.Job;
import com.springboot.hibernate.service.impl.AddressServiceImpl;
import com.springboot.hibernate.service.impl.BankCardServiceImpl;
import com.springboot.hibernate.service.impl.EmployeeServiceImpl;
import com.springboot.hibernate.service.impl.JobServiceImpl;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitData {

  @Autowired
  private AddressServiceImpl addressService;
  @Autowired
  private EmployeeServiceImpl employeeService;
  @Autowired
  private BankCardServiceImpl bankCardService;
  @Autowired
  private JobServiceImpl jobService;

  @PostConstruct
  void init(){

    // Address
    Address address = Address.builder()
        .city("NewYork")
        .pinCode(1)
        .country("America")
        .state("A5AB5B")
        .build();
    Address address2 = Address.builder()
        .city("NewYork2")
        .pinCode(2)
        .country("America2")
        .state("A5AB5B2")
        .build();
    addressService.save(address);
    addressService.save(address2);

    // Employee
    Employee employee = Employee
        .builder()
        .fullName("David")
        .email("david@gmail.com")
        .address(address)
        .build();
    Employee employee2 = Employee
        .builder()
        .fullName("David2")
        .email("david2@gmail.com")
        .address(address2)
        .build();
    employeeService.save(employee);
    employeeService.save(employee2);

    // Bank Card
    BankCard bankCard= BankCard.builder()
        .bankCardNo("1111-2222")
        .bankCardName("TPBank")
        .bankCardSerial("1111-2222")
        .employee(employee)
        .build();
    BankCard bankCard2= BankCard.builder()
        .bankCardNo("1111-3333")
        .bankCardName("Vietcombank")
        .bankCardSerial("1111-3333")
        .employee(employee)
        .build();
    BankCard bankCard3= BankCard.builder()
        .bankCardNo("1111-4444")
        .bankCardName("Sacombank")
        .bankCardSerial("1111-4444")
        .employee(employee2)
        .build();
    bankCardService.save(bankCard);
    bankCardService.save(bankCard2);
    bankCardService.save(bankCard3);

    //Job
    Job job = Job.builder()
        .jobName("Developer")
        .jobDescription("Code")
        .employees(List.of(employee, employee2))
        .build();
    Job job2 = Job.builder()
        .jobName("Tester")
        .jobDescription("Test")
        .employees(List.of(employee))
        .build();
    jobService.save(job);
    jobService.save(job2);

    employee.setJobs(List.of(job, job2));
    employeeService.save(employee);
    employee2.setJobs(List.of(job2));
    employeeService.save(employee2);

  }
}
