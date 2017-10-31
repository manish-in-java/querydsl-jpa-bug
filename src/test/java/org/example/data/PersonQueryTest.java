package org.example.data;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import org.example.domain.QPerson;
import org.example.domain.QQuotation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Collections;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PersonQueryTest
{
  @Mock
  private EntityManager        entityManager;
  @Mock
  private EntityManagerFactory entityManagerFactory;

  @Before
  public void setup()
  {
    when(entityManager.getEntityManagerFactory()).thenReturn(entityManagerFactory);

    when(entityManagerFactory.getProperties()).thenReturn(Collections.emptyMap());
  }

  @Test
  public void test()
  {
    final QQuotation quotation = QQuotation.quotation;

    BooleanExpression expression = quotation.customer.isNotNull();

    expression = expression.and(quotation.supplier.isNotNull());

    expression = expression.and(getPersonNameRestriction(quotation.representative.jobs.any().employee.person, "John Smith"));

    final JPAQuery<QQuotation> query = new JPAQuery<>(entityManager);

    System.out.println(query.where(expression).select(quotation).toString());
  }

  private BooleanExpression getPersonNameRestriction(final QPerson person, final String name)
  {
    return person.firstName.concat(" ")
                           .concat(person.middleName.concat(" ").coalesce(""))
                           .concat(person.lastName)
                           .containsIgnoreCase(name);
  }
}
