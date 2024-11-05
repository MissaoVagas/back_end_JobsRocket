package com.back_end.JobsRocket.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.back_end.JobsRocket.model.Curriculo;

public interface CurriculoRepository extends JpaRepository<Curriculo, Integer>{
	
	Optional<Curriculo> findByCandidatoId(Integer candidato_id);

}
