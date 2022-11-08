package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.domain.Academy;
import com.example.demo.domain.AcademyRepositoryCustom;

public interface AcademyRepository extends JpaRepository<Academy, Long>, AcademyRepositoryCustom{

}
