package com.back_end.JobsRocket.repository;

import com.back_end.JobsRocket.model.Candidato;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test") // Certifique-se de que você tenha um perfil de teste configurado
public class CandidatoRepositoryTest {

    @Autowired
    private CandidatoRepository candidatoRepository;

    @BeforeEach
    public void setUp() {
        Candidato candidato = new Candidato();
        candidato.setNome("João Silva");
        candidato.setCampoDeInteresse("Desenvolvedor");
        candidatoRepository.save(candidato);
    }

    @Test
    public void testFindById() {
        Candidato candidato = candidatoRepository.findById(1).orElse(null);
        assertThat(candidato).isNotNull();
        assertThat(candidato.getNome()).isEqualTo("João Silva");
    }
}
