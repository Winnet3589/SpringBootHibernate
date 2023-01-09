package com.springboot.hibernate.dtos.base;

import java.io.Serializable;
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
public class BaseDto<T extends Serializable> {
  private T id;
//  private Timestamp createdDate;
//  private Timestamp modifiedDate;
}
