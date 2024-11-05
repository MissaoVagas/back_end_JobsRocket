package com.back_end.JobsRocket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.back_end.JobsRocket.model.Candidato;

public interface CandidatoRepository extends JpaRepository<Candidato, Integer> {

}
