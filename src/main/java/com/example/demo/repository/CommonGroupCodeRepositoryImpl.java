package com.example.demo.repository;

import java.util.List;
import javax.persistence.EntityManager;
import com.example.demo.domain.CommonGroupCode;
import com.example.demo.domain.QCommonGroupCode;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommonGroupCodeRepositoryImpl implements CommonGroupCodeRepositoryCustom{
  
  private final JPAQueryFactory jpaQueryFactory;
  
//  public CommonGroupCodeRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
//    this.jpaQueryFactory = jpaQueryFactory;
//  }

  @Override
  public List<CommonGroupCode> getCommomGroupCodeListQueryDSL(String groupCd) {
    return jpaQueryFactory.selectFrom(QCommonGroupCode.commonGroupCode)
            .where(QCommonGroupCode.commonGroupCode.groupCd.eq(groupCd))
            .fetch();
  }
}
