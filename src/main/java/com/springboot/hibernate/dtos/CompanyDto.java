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
public class CompanyDto extends BaseDto<Long> {

  private String companyName;

  private List<DepartmentInCompanyDto> departments;

  @NoArgsConstructor
  @AllArgsConstructor
  @Getter
  @Setter
  @SuperBuilder
  public static class DepartmentInCompanyDto extends BaseDto<Long> {

    private String departmentName;

  }
}
