package com.springboot.hibernate.dtos;

import com.springboot.hibernate.dtos.base.BaseDto;
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
public class BankCardDto extends BaseDto<Long> {
  private String bankCardNo;
  private String bankCardSerial;
  private String bankCardName;
  private EmployeeInBankCardDto employee;

  @NoArgsConstructor
  @AllArgsConstructor
  @Getter
  @Setter
  @SuperBuilder
  public static class EmployeeInBankCardDto extends BaseDto<Long> {
    private String fullName;
    private String email;
  }
}
