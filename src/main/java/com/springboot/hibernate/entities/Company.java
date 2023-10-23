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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

  // Validator
  @Size(max = 20, min = 3, message = "Company name size should be between 3 to 20 characters.")
  @NotEmpty(message = "Please enter Company name.")
  @NotNull(message = "Company name is not null.")
  private String companyName;

  @OneToMany(cascade = CascadeType.ALL,fetch= FetchType.EAGER, mappedBy = "company")
  @JsonIgnoreProperties("company")
  private List<Department> departments;
}
