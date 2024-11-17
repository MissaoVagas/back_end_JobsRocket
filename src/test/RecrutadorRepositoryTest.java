package com.back_end.JobsRocket.repository;

import com.back_end.JobsRocket.model.Recrutador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class RecrutadorRepositoryTest {

    @Autowired
    private RecrutadorRepository recrutadorRepository;

    @BeforeEach
    public void setUp() {
        Recrutador recrutador = new Recrutador();
        recrutador.setNome("Carlos Silva");
        recrutador.setNomeEmpresa("Recrutadora XYZ");
        recrutadorRepository.save(recrutador);
    }

    @Test
    public void testFindById() {
        Recrutador recrutador = recrutadorRepository.findById(1).orElse(null);
        assertThat(recrutador).isNotNull();
        assertThat(recrutador.getNome()).isEqualTo("Carlos Silva");
    }
}
