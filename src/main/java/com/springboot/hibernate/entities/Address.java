package com.springboot.hibernate.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import com.springboot.hibernate.entities.base.BaseEntity;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
@Table(name = "ADDRESS")
public class Address extends BaseEntity<Long> {

  @Column(name = "ADDRESS_LINE")
  private String addressLine;

  @Column(name = "CITY")
  private String city;

  @Column(name = "STATE")
  private String state;

  @Column(name = "COUNTRY")
  private String country;

  @Column(name = "PIN_CODE")
  private int pinCode;

  @OneToOne(mappedBy = "address")
  @JsonIgnoreProperties("address")
  private Employee employee;
}
