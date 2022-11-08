package com.example.demo.domain;

import java.util.List;

public interface AcademyRepositoryCustom {
  
  public List<Academy> findByName(String name);

}
