package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import com.example.demo.domain.Academy;
import com.example.demo.domain.QAcademy;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class AcademyRepositorySupport extends QuerydslRepositorySupport{

  private final JPAQueryFactory queryFactory;
  
  public AcademyRepositorySupport(JPAQueryFactory queryFactory) {
    super(Academy.class);
    this.queryFactory = queryFactory;
  }
  
  public List<Academy> findByName(String name){
    return queryFactory
          .selectFrom(new QAcademy("academy"))
          .where(new QAcademy("academy").name.eq(name))
          .fetch();
  }
}

