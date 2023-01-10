package com.springboot.hibernate.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.springboot.hibernate.entities.base.BaseEntity;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Source;
import org.hibernate.annotations.SourceType;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
@Table(name = "CITIZEN_ID_CARD")
public class CitizenIDCard extends BaseEntity<Long> {

  @Column(name = "CITIZEN_ID_NO")
  private String citizenIdNo;

  @Column(name = "DAY_OF_BIRTH")
  private Timestamp dayOfBirth;

  @Column(name = "CITY")
  private String city;

  @Column(name = "STATE")
  private String state;

  @Column(name = "COUNTRY")
  private String country;

  @Column(name = "PIN_CODE")
  private Integer pinCode;

  @OneToOne(cascade = CascadeType.ALL,fetch= FetchType.LAZY,mappedBy = "citizenIDCard")
  @JsonIgnoreProperties("citizenIDCard")
  private Employee employee;

  @Version
  @Source(value = SourceType.DB)
  private Date version;
}
