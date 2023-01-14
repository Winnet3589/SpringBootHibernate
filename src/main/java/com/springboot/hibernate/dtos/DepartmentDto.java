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
public class DepartmentDto extends BaseDto<Long> {

  private String departmentName;

  private CompanyInDepartmentDto company;

  @NoArgsConstructor
  @AllArgsConstructor
  @Getter
  @Setter
  @SuperBuilder
  public static class CompanyInDepartmentDto extends BaseDto<Long> {

    private String companyName;
  }

}
