package org.example.domain;

import com.querydsl.core.annotations.QueryEntity;
import com.querydsl.core.annotations.QueryInit;

import javax.persistence.*;
import java.util.Set;

@Entity
@QueryEntity
@Table(name = "position")
public class Position extends Model
{
  @JoinColumn(name = "department_id", nullable = false, updatable = false)
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  private Department department;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "position")
  @QueryInit("*.*")
  private Set<Job> jobs;

  @Column(length = 100, name = "title", nullable = false)
  private String title;

  Position()
  {
    super();
  }

  public Position(final Department department, final String title)
  {
    this();

    this.department = department;
    this.title = title;
  }

  public Department getDepartment()
  {
    return department;
  }

  public String getTitle()
  {
    return title;
  }
}
