package com.back_end.JobsRocket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back_end.JobsRocket.model.Candidato;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Integer> {

}
