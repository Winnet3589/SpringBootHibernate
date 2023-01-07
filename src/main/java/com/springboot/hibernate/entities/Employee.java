package com.springboot.hibernate.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.springboot.hibernate.entities.base.BaseEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
@Table(name = "EMPLOYEE")
public class Employee extends BaseEntity<Long> {

  @Column(name = "FULL_NAME")
  private String fullName;

  @Column(name = "EMAIL")
  private String email;

  @OneToOne(cascade = CascadeType.ALL,fetch= FetchType.LAZY)
  @JoinColumn(name = "ADDRESS_ID", referencedColumnName ="ID")
  @JsonIgnoreProperties("employee")
  private Address address;

  @ManyToMany(cascade = CascadeType.ALL,fetch= FetchType.EAGER)
  @JoinTable(
      name = "EMPLOYEE_JOB",
      joinColumns = { @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "ID") },
      inverseJoinColumns = { @JoinColumn(name = "JOB_ID", referencedColumnName = "ID") }
  )
  @JsonIgnoreProperties("employees")
  private List<Job> jobs = new ArrayList<>();

  @OneToMany(cascade = CascadeType.ALL,fetch= FetchType.LAZY, mappedBy = "employee")
  @JsonIgnoreProperties("employee")
  private List<BankCard> bankCards;
}
