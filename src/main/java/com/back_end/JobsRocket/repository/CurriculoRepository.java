package com.back_end.JobsRocket.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back_end.JobsRocket.model.Curriculo;

@Repository
public interface CurriculoRepository extends JpaRepository<Curriculo, Integer>{
	
	

}
