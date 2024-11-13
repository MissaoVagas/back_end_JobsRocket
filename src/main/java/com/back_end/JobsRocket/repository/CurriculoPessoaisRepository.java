package com.back_end.JobsRocket.repository;

import com.back_end.JobsRocket.model.CurriculoPessoais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurriculoPessoaisRepository extends JpaRepository<CurriculoPessoais, Integer> {
}
