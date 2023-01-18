package com.springboot.hibernate.dtos;

import com.springboot.hibernate.dtos.base.BaseDto;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

  @Size(max = 20, min = 3, message = "Company name size should be between 3 to 20 characters.")
  @NotEmpty(message = "Please enter Company name.")
  @NotNull(message = "Company name is not null.")
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
