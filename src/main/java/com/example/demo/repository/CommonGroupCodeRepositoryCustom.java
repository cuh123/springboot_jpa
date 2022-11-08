package com.example.demo.repository;

import java.util.List;
import com.example.demo.domain.CommonGroupCode;

public interface CommonGroupCodeRepositoryCustom {

  public List<CommonGroupCode> getCommomGroupCodeListQueryDSL(String groupCd);

}
