package com.springboot.hibernate.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.springboot.hibernate.entities.base.BaseEntity;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "CITIZEN_ID_CARD",
    uniqueConstraints =  @UniqueConstraint(
        name = "CITIZEN_ID_NO_UNIQUE",
        columnNames = {
            "CITIZEN_ID_NO"
        }
    ))
public class CitizenIDCard extends BaseEntity<Long> {

  @Column(name = "CITIZEN_ID_NO")
  private String citizenIdNo;

  @Column(name = "DAY_OF_BIRTH")
  @Temporal(TemporalType.DATE)
  private Date dayOfBirth;

  @Column(name = "CITY")
  private String city;

  @Column(name = "STATE")
  private String state;

  @Column(name = "COUNTRY")
  private String country;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "citizenIDCard")
  @JsonIgnoreProperties("citizenIDCard")
  private Employee employee;
}
