package com.back_end.JobsRocket.repository;

import com.back_end.JobsRocket.model.CurriculoAcademicos;
import com.back_end.JobsRocket.model.enums.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CurriculoAcademicosRepositoryTest {

    @Autowired
    private CurriculoAcademicosRepository curriculoAcademicosRepository;

    @BeforeEach
    public void setUp() {
        CurriculoAcademicos academico = new CurriculoAcademicos();
        academico.setNomeFaculdade("Universidade XYZ");
        academico.setStatusFaculdade(Status.ATIVO);
        curriculoAcademicosRepository.save(academico);
    }

    @Test
    public void testFindByNomeFaculdade() {
        List<CurriculoAcademicos> resultados = curriculoAcademicosRepository.findByNomeFaculdade("Universidade XYZ");
        assertThat(resultados).isNotEmpty();
        assertThat(resultados.get(0).getNomeFaculdade()).isEqualTo("Universidade XYZ");
    }
}
