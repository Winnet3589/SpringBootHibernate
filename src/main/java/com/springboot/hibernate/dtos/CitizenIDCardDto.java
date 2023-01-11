package com.springboot.hibernate.dtos;

import com.springboot.hibernate.dtos.base.BaseDto;
import java.sql.Timestamp;
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
public class CitizenIDCardDto extends BaseDto<Long> {

  private String citizenIdNo;
  private Timestamp dayOfBirth;
  private String city;
  private String state;
  private String country;
  private Integer pinCode;
  private EmployeeInCitizenIDCardDto employee;

  @NoArgsConstructor
  @AllArgsConstructor
  @Getter
  @Setter
  @SuperBuilder
  public static class EmployeeInCitizenIDCardDto extends BaseDto<Long> {

    private String fullName;
    private String email;
  }
}
