package org.example.domain;

import com.querydsl.core.annotations.QueryEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@QueryEntity
@Table(name = "person")
public class Person extends Model
{
  @Column(length = 100, name = "first_name", nullable = false)
  private String firstName;

  @Column(length = 100, name = "last_name", nullable = false)
  private String lastName;

  @Column(length = 100, name = "middle_name")
  private String middleName;

  Person()
  {
    super();
  }

  public Person(final String firstName, final String lastName)
  {
    this(firstName, null, lastName);
  }

  public Person(final String firstName, final String middleName, final String lastName)
  {
    this();

    this.firstName = firstName;
    this.lastName = lastName;
    this.middleName = middleName;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public String getMiddleName()
  {
    return middleName;
  }
}
