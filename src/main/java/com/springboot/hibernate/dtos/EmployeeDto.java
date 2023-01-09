package com.springboot.hibernate.dtos;

import com.springboot.hibernate.dtos.base.BaseDto;
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
  private AddressInEmployeeDto address;
  private List<JobInEmployeeDto> jobs;
  private List<BankCardInEmployeeDto> bankCards;

  @NoArgsConstructor
  @AllArgsConstructor
  @Getter
  @Setter
  @SuperBuilder
  public static class AddressInEmployeeDto extends BaseDto<Long> {

    private String city;
    private String state;
    private String country;
    private Integer pinCode;
  }

  @NoArgsConstructor
  @AllArgsConstructor
  @Getter
  @Setter
  @SuperBuilder
  public static class JobInEmployeeDto extends BaseDto<Long> {
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
