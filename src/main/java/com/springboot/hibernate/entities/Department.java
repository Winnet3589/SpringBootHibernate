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
@Table(name = "DEPARTMENT")
public class Department extends BaseEntity<Long> {

  @Column(name = "DEPARTMENT_NAME")
  private String departmentName;

  @ManyToOne(cascade =CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "COMPANY_ID", referencedColumnName = "ID",
      foreignKey = @ForeignKey(name = "COMPANY_ID_FK"))
  @JsonIgnoreProperties("departments")
  private Company company;
}
