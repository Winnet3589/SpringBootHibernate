package com.springboot.hibernate.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.springboot.hibernate.entities.base.BaseEntity;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
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
@Table(name = "COMPANY")
public class Company extends BaseEntity<Long> {

  @Column(name = "COMPANY_NAME")
  private String companyName;

  @OneToMany(cascade = CascadeType.ALL,fetch= FetchType.LAZY, mappedBy = "company")
  @JsonIgnoreProperties("company")
  private List<Department> departments;
}
