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
public class JobDto extends BaseDto<Long> {
  private String jobName;
  private String jobDescription;
  private List<EmployeeInJobDto> employees;

  @NoArgsConstructor
  @AllArgsConstructor
  @Getter
  @Setter
  @SuperBuilder
  public static class EmployeeInJobDto extends BaseDto<Long> {
    private String fullName;
    private String email;
  }
}
