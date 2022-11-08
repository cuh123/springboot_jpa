package com.example.demo.domain;

import java.util.List;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class AcademyRepositoryImpl implements AcademyRepositoryCustom{
  
  private final JPAQueryFactory queryFactory;
  
  public AcademyRepositoryImpl(JPAQueryFactory queryFactory) {
    this.queryFactory = queryFactory;
  }
  
  @Override
  public List<Academy> findByName(String name){
    return queryFactory.selectFrom(QAcademy.academy)
            .where(QAcademy.academy.name.eq(name))
            .fetch();
  }
  

}
