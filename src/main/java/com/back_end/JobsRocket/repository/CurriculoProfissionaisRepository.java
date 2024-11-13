package com.back_end.JobsRocket.repository;

import com.back_end.JobsRocket.model.CurriculoProfissionais;
import com.back_end.JobsRocket.model.enums.TipoEmprego;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CurriculoProfissionaisRepository extends JpaRepository<CurriculoProfissionais, Integer> {

    // Método para buscar currículos por nome da empresa
    List<CurriculoProfissionais> findByNomeEmpresa(String nomeEmpresa);

    // Método para buscar currículos por cargo
    List<CurriculoProfissionais> findByCargo(String cargo);

    // Busca por tipo de emprego
    List<CurriculoProfissionais> findByTipoEmprego(TipoEmprego tipoEmprego);

    // Busca por intervalo de datas
    List<CurriculoProfissionais> findByDataInicioBetween(Date startDate, Date endDate);

    // Busca por cargo e tipo de emprego
    List<CurriculoProfissionais> findByCargoAndTipoEmprego(String cargo, TipoEmprego tipoEmprego);

    
}
