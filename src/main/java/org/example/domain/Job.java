package org.example.domain;

import com.querydsl.core.annotations.QueryEntity;
import com.querydsl.core.annotations.QueryInit;

import javax.persistence.*;

@Entity
@QueryEntity
@Table(name = "job")
public class Job extends Model
{
  @JoinColumn(name = "employee_id", nullable = false, updatable = false)
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @QueryInit("*.*")
  private Employee employee;

  @JoinColumn(name = "position_id", nullable = false, updatable = false)
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @QueryInit("*.*")
  private Position position;

  Job()
  {
    super();
  }

  public Job(final Position position, final Employee employee)
  {
    this();

    this.employee = employee;
    this.position = position;
  }

  public Employee getEmployee()
  {
    return employee;
  }

  public Position getPosition()
  {
    return position;
  }
}
