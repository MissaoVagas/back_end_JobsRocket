package com.back_end.JobsRocket.repository;

import com.back_end.JobsRocket.model.CurriculoAcademicos;
import com.back_end.JobsRocket.model.enums.Status;
import com.back_end.JobsRocket.model.enums.TipoCurso;
import com.back_end.JobsRocket.model.enums.TipoFormacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurriculoAcademicosRepository extends JpaRepository<CurriculoAcademicos, Integer> {

    // Método para buscar por nome da faculdade
    List<CurriculoAcademicos> findByNomeFaculdade(String nomeFaculdade);

    // Método para buscar por nome do curso
    List<CurriculoAcademicos> findByNomeCurso(String nomeCurso);

    // Método para buscar por status da faculdade
    List<CurriculoAcademicos> findByStatusFaculdade(Status statusFaculdade);

    // Busca por status e tipo de curso
    List<CurriculoAcademicos> findByStatusFaculdadeAndTipoCurso(Status statusFaculdade, TipoCurso tipoCurso);

    // Busca por tipo de formação
    List<CurriculoAcademicos> findByTipoFormacao(TipoFormacao tipoFormacao);
    
}
