package com.springboot.hibernate.configs;

import com.springboot.hibernate.entities.Address;
import com.springboot.hibernate.entities.BankCard;
import com.springboot.hibernate.entities.CitizenIDCard;
import com.springboot.hibernate.entities.Company;
import com.springboot.hibernate.entities.Department;
import com.springboot.hibernate.entities.Employee;
import com.springboot.hibernate.entities.Job;
import com.springboot.hibernate.entities.NetworkSocial;
import com.springboot.hibernate.enums.Gender;
import com.springboot.hibernate.enums.JobType;
import com.springboot.hibernate.services.impl.AddressServiceImpl;
import com.springboot.hibernate.services.impl.BankCardServiceImpl;
import com.springboot.hibernate.services.impl.CitizenIDCardServiceImpl;
import com.springboot.hibernate.services.impl.CompanyServiceImpl;
import com.springboot.hibernate.services.impl.DepartmentServiceImpl;
import com.springboot.hibernate.services.impl.EmployeeServiceImpl;
import com.springboot.hibernate.services.impl.NetworkSocialServiceImpl;
import com.springboot.hibernate.utils.InvalidPayloadException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitData {

  private final CitizenIDCardServiceImpl citizenIDCardDService;
  private final EmployeeServiceImpl employeeService;
  private final BankCardServiceImpl bankCardService;
  private final CompanyServiceImpl companyService;
  private final AddressServiceImpl addressService;
  private final DepartmentServiceImpl departmentService;
  private final NetworkSocialServiceImpl networkSocialService;

  @PostConstruct
  void init() throws InvalidPayloadException {

    // CitizenIDCard
    CitizenIDCard citizenIDCard = CitizenIDCard.builder()
        .citizenIdNo("205467129")
        .dayOfBirth(new Date())
        .city("NewYork")
        .country("America")
        .state("A5AB5B")
        .build();
    CitizenIDCard citizenIDCard2 = CitizenIDCard.builder()
        .citizenIdNo("305467129")
        .dayOfBirth(Timestamp.valueOf("2019-09-01 09:01:15"))
        .city("Quang Nam")
        .country("Viet Nam")
        .state("CACD2D")
        .build();
    citizenIDCardDService.save(citizenIDCard);
    citizenIDCardDService.save(citizenIDCard2);

    //Job
    Job job = Job.builder()
        .jobName("Developer")
        .jobDescription("Code")
        .jobType(JobType.FULL_TIME)
        .build();
    Job job2 = Job.builder()
        .jobName("Tester")
        .jobDescription("Test")
        .jobType(JobType.PART_TIME)
        .build();

    // Employee
    Employee employee = Employee
        .builder()
        .fullName("Nguyen Thi A")
        .email("a@gmail.com")
        .gender(Gender.FEMALE)
        .citizenIDCard(citizenIDCard)
        .phoneNumber("0905 030589")
        .jobs(List.of(job))
        .build();
    Employee employee2 = Employee
        .builder()
        .fullName("Nguyen Van B")
        .gender(Gender.MALE)
        .email("b@gmail.com")
        .citizenIDCard(citizenIDCard2)
        .phoneNumber("0906 030589")
        .jobs(List.of(job, job2))
        .build();
    employeeService.save(employee);
    employeeService.save(employee2);

    // Bank Card
    BankCard bankCard = BankCard.builder()
        .bankCardNo("1111-2222")
        .bankCardName("TPBank")
        .bankCardSerial("1111-2222")
        .employee(employee)
        .build();
    BankCard bankCard2 = BankCard.builder()
        .bankCardNo("1111-3333")
        .bankCardName("Vietcombank")
        .bankCardSerial("1111-3333")
        .employee(employee)
        .build();
    BankCard bankCard3 = BankCard.builder()
        .bankCardNo("1111-4444")
        .bankCardName("Sacombank")
        .bankCardSerial("1111-4444")
        .employee(employee2)
        .build();
    bankCardService.save(bankCard);
    bankCardService.save(bankCard2);
    bankCardService.save(bankCard3);

    Address address = Address.builder()
        .city("Hue")
        .country("Viet Nam")
        .state("CACD2D")
        .build();
    Address address2 = Address.builder()
        .city("Da Nang")
        .country("Viet Nam")
        .state("BCAD2D")
        .build();
    addressService.save(address);
    addressService.save(address2);

    Company company = Company.builder()
        .companyName("Mobifone")
        .build();
    Company company1 = Company.builder()
        .companyName("Vina")
        .build();
    companyService.save(company);
    companyService.save(company1);

    Department department = Department.builder()
        .departmentName("Hanh chinh")
        .company(company)
        .build();
    Department department1 = Department.builder()
        .departmentName("Ke toan")
        .company(company)
        .build();

    Department department2 = Department.builder()
        .departmentName("Nhan su")
        .company(company)
        .build();

    Department department3 = Department.builder()
        .departmentName("Bao Hiem")
        .company(company1)
        .build();
    Department department4 = Department.builder()
        .departmentName("Cham soc khach hang")
        .company(company1)
        .build();

    departmentService.save(department);
    departmentService.save(department1);
    departmentService.save(department2);
    departmentService.save(department3);
    departmentService.save(department4);

    NetworkSocial networkSocial = NetworkSocial.builder()
        .code("F")
        .name("Facebook").note("Facebook 1").build();
    NetworkSocial networkSocial1 = NetworkSocial.builder()
        .code("Z")
        .name("Zalo").note("Zalo 1").build();
    NetworkSocial networkSocial2 = NetworkSocial.builder()
        .code("I")
        .name("Instagram").note("Instagram 1").build();
    networkSocialService.save(networkSocial);
    networkSocialService.save(networkSocial1);
    networkSocialService.save(networkSocial2);

  }
}
