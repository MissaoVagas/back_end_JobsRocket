package com.back_end.JobsRocket.repository;

import com.back_end.JobsRocket.model.CurriculoCursos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CurriculoCursosRepositoryTest {

    @Autowired
    private CurriculoCursosRepository curriculoCursosRepository;

    @BeforeEach
    public void setUp() {
        CurriculoCursos curso = new CurriculoCursos();
        curso.setNomeCurso("Java Básico");
        curriculoCursosRepository.save(curso);
    }

    @Test
    public void testFindById() {
        CurriculoCursos curso = curriculoCursosRepository.findById(1).orElse(null);
        assertThat(curso).isNotNull();
        assertThat(curso.getNomeCurso()).isEqualTo("Java Básico");
    }
}
