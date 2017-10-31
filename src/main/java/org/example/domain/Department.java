package org.example.domain;

import com.querydsl.core.annotations.QueryEntity;

import javax.persistence.*;

@Entity
@QueryEntity
@Table(name = "department")
public class Department extends Model
{
  @JoinColumn(name = "company_id", nullable = false, updatable = false)
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  private Company company;

  @Column(length = 100, name = "name", nullable = false)
  private String name;

  Department()
  {
    super();
  }

  public Department(final Company company, final String name)
  {
    this();

    this.name = name;
    this.company = company;
  }

  public Company getCompany()
  {
    return company;
  }

  public String getName()
  {
    return name;
  }
}
