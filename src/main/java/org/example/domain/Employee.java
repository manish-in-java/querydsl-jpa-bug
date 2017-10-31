package org.example.domain;

import com.querydsl.core.annotations.QueryEntity;

import javax.persistence.*;

@Entity
@QueryEntity
@Table(name = "employee")
public class Employee extends Model
{
  @JoinColumn(name = "company_id", nullable = false, updatable = false)
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  private Company company;

  @JoinColumn(name = "person_id", nullable = false, updatable = false)
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  private Person person;

  @Column(length = 100, name = "title", nullable = false)
  private String title;

  Employee()
  {
    super();
  }

  public Employee(final Company company, final Person person, final String title)
  {
    this();

    this.company = company;
    this.person = person;
    this.title = title;
  }

  public Company getCompany()
  {
    return company;
  }

  public Person getPerson()
  {
    return person;
  }

  public String getTitle()
  {
    return title;
  }
}
