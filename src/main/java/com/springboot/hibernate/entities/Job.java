package com.springboot.hibernate.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.springboot.hibernate.enums.JobType;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
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
@Table(name = "JOB")
public class Job extends BaseEntity<Long> {

  @Column(name = "JOB_NAME")
  private String jobName;

  @Column(name = "JOB_DESCRIPTION")
  private String jobDescription;

  @Column(name = "JOB_TYPE")
  @Enumerated(EnumType.STRING)
  private JobType jobType;

  @ManyToMany(cascade = CascadeType.ALL,fetch= FetchType.LAZY, mappedBy = "jobs")
  @JsonIgnoreProperties("jobs")
  private List<Employee> employees;
}
