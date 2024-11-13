package com.back_end.JobsRocket.repository;

import com.back_end.JobsRocket.model.CurriculoPrincipais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurriculoPrincipaisRepository extends JpaRepository<CurriculoPrincipais, Integer> {
}
