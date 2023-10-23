package com.springboot.hibernate.dtos.base;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class BaseDto<T extends Serializable> {

  private T id;
  private Timestamp createdDate;
  private Timestamp modifiedDate;
}
