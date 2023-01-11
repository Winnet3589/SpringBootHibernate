package com.springboot.hibernate.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.springboot.hibernate.entities.base.BaseEntity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
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
@Entity
@Table(name = "BANK_CARD",
    uniqueConstraints =  @UniqueConstraint(
        name = "BANK_CARD_NO_UNIQUE",
        columnNames = {
            "BANK_CARD_NO"
        }
    ))
public class BankCard extends BaseEntity<Long> {

  @Column(name = "BANK_CARD_NO")
  private String bankCardNo;

  @Column(name = "BANK_CARD_SERIAL")
  private String bankCardSerial;

  @Column(name = "BANK_CARD_NAME")
  private String bankCardName;

  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "ID",
      foreignKey = @ForeignKey(name = "EMPLOYEE_ID_FK"))
  @JsonIgnoreProperties("bankCards")
  private Employee employee;
}
