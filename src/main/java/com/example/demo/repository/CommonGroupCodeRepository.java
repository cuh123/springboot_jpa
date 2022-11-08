package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.domain.CommonGroupCode;

@Repository
public interface CommonGroupCodeRepository extends JpaRepository<CommonGroupCode, String>, CommonGroupCodeRepositoryCustom{

}
