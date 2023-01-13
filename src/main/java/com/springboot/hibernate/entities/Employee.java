package com.springboot.hibernate.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.springboot.hibernate.converters.GenderConverter;
import com.springboot.hibernate.enums.Gender;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "EMPLOYEE",
    uniqueConstraints =  @UniqueConstraint(
        name = "CITIZEN_ID_CARD_ID_UNIQUE",
        columnNames = {
            "CITIZEN_ID_CARD_ID"
        }
    ))
public class Employee extends BaseEntity<Long> {

  @Column(name = "FULL_NAME")
  private String fullName;

  @Column(name = "EMAIL")
  private String email;

  @Column(name = "PHONE_NUMBER")
  private String phoneNumber;

  @Convert( converter = GenderConverter.class )
  @Column(name = "GENDER")
  public Gender gender;

  @OneToOne(cascade = CascadeType.ALL,fetch= FetchType.LAZY)
  @JoinColumn(name = "CITIZEN_ID_CARD_ID", referencedColumnName ="ID",
      foreignKey = @ForeignKey(name = "CITIZEN_ID_CARD_FK"))
  @JsonIgnoreProperties("employee")
  private CitizenIDCard citizenIDCard;

  @ManyToMany(cascade = CascadeType.ALL,fetch= FetchType.LAZY)
  @JoinTable(
      name = "EMPLOYEE_JOB",
      joinColumns = { @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "ID",
          foreignKey = @ForeignKey(name = "EMPLOYEE_ID_FK")) },
      inverseJoinColumns = { @JoinColumn(name = "JOB_ID", referencedColumnName = "ID",
          foreignKey = @ForeignKey(name = "JOB_ID_FK")) }
  )
  @JsonIgnoreProperties("employees")
  private List<Job> jobs;

  @OneToMany(cascade = CascadeType.ALL,fetch= FetchType.LAZY, mappedBy = "employee")
  @JsonIgnoreProperties("employee")
  private List<BankCard> bankCards;
}
