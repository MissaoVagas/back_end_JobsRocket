package com.back_end.JobsRocket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back_end.JobsRocket.model.Recrutador;

@Repository
public interface RecrutadorRepository extends JpaRepository<Recrutador, Integer>{

}
