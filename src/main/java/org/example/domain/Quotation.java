package org.example.domain;

import com.querydsl.core.annotations.QueryEntity;

import javax.persistence.*;

@Entity
@QueryEntity
@Table(name = "quotation")
public class Quotation extends Model
{
  @JoinColumn(name = "customer_id", nullable = false, updatable = false)
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  private Company customer;

  @JoinColumn(name = "representative_id", nullable = false, updatable = false)
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  private Position representative;

  @JoinColumn(name = "supplier_id", nullable = false, updatable = false)
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  private Company supplier;

  Quotation()
  {
    super();
  }

  public Quotation(final Company customer, final Company supplier, final Position representative)
  {
    this();

    this.customer = customer;
    this.representative = representative;
    this.supplier = supplier;
  }

  public Company getCustomer()
  {
    return customer;
  }

  public Company getSupplier()
  {
    return supplier;
  }

  public Position getRepresentative()
  {
    return representative;
  }
}
