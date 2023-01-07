package com.springboot.hibernate.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
@Table(name = "EMPLOYEE")
public class Employee extends BaseEntity<Long> {

  @Column(name = "FULL_NAME")
  private String fullName;

  @Column(name = "EMAIL")
  private String email;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "ADDRESS_ID", referencedColumnName ="ID")
  @JsonIgnoreProperties("employee")
  private Address address;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "JOB_ID", referencedColumnName ="ID")
  @JsonIgnoreProperties("employees")
  private List<Job> jobs;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
  @JsonIgnoreProperties("employee")
  private List<BankCard> bankCards;
}
