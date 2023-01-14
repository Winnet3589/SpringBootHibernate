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
public class AddressDto extends BaseDto<Long> {

  private Long id;

  private String city;

  private String state;

  private String country;
}
