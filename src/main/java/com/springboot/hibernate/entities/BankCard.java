package com.springboot.hibernate.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "BANK_CARD")
public class BankCard extends BaseEntity<Long> {

  @Column(name = "BANK_CARD_NO")
  private String bankCardNo;

  @Column(name = "BANK_CARD_SERIAL")
  private String bankCardSerial;

  @Column(name = "BANK_CARD_NAME")
  private String bankCardName;

  @ManyToOne
  @JoinColumn(name = "EMPLOYEE_ID", nullable = false, referencedColumnName ="ID")
  @JsonIgnoreProperties("bankCards")
  private Employee employee;
}
