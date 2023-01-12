package com.springboot.hibernate.dtos;

import com.springboot.hibernate.dtos.base.BaseDto;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class EmployeeDto extends BaseDto<Long> {

  private String fullName;
  private String email;
  private String phoneNumber;
  private String gender;
  private CitizenIDCardInEmployeeDto citizenIDCard;
  private List<JobInEmployeeDto> jobs;
  private List<BankCardInEmployeeDto> bankCards;

  @NoArgsConstructor
  @AllArgsConstructor
  @Getter
  @Setter
  @SuperBuilder
  public static class CitizenIDCardInEmployeeDto extends BaseDto<Long> {

    private String citizenIdNo;
    private Date dayOfBirth;
    private String city;
    private String state;
    private String country;
  }

  @NoArgsConstructor
  @AllArgsConstructor
  @Getter
  @Setter
  @SuperBuilder
  public static class JobInEmployeeDto extends BaseDto<Long> {

    private String jobType;
    private String jobName;
    private String jobDescription;
  }

  @NoArgsConstructor
  @AllArgsConstructor
  @Getter
  @Setter
  @SuperBuilder
  public static class BankCardInEmployeeDto extends BaseDto<Long> {

    private String bankCardNo;
    private String bankCardSerial;
    private String bankCardName;
  }

}
