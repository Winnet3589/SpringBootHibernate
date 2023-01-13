package com.springboot.hibernate.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Source;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@SuperBuilder
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity<T extends Serializable> {

  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private T id;

  @Column(name = "CREATED_DATE",updatable = false)
  @CreationTimestamp
  private Timestamp createdDate;

  @UpdateTimestamp
  @Column(name = "MODIFIED_DATE")
  private Timestamp modifiedDate;

  @Version
  @Column(name = "VERSION")
  @Source(value = SourceType.DB)
  private Date version;
}
