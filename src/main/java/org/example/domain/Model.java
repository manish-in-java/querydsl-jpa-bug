package org.example.domain;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class Model implements Serializable
{
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Long id;

  public Long getID()
  {
    return id;
  }
}
