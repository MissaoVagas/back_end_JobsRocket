package com.back_end.JobsRocket.repository;

import com.back_end.JobsRocket.model.Recrutador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class RecrutadorRepositoryTest {

    @Autowired
    private RecrutadorRepository recrutadorRepository;

    private Recrutador recrutador;

    @BeforeEach
    public void setUp() {
        recrutador = new Recrutador();
        recrutador.setNome("Carlos Silva");
        recrutador.setNomeEmpresa("Recrutadora XYZ");
        recrutadorRepository.save(recrutador);
    }

    @Test
    public void testFindById() {
        Recrutador foundRecrutador = recrutadorRepository.findById(recrutador.getUser_id()).orElse(null);
        assertThat(foundRecrutador).isNotNull();
        assertThat(foundRecrutador.getNome()).isEqualTo("Carlos Silva");
    }

    @Test
    public void testFindAll() {
        List<Recrutador> recrutadores = recrutadorRepository.findAll();
        assertThat(recrutadores).isNotEmpty();
        assertThat(recrutadores.size()).isGreaterThan(0);
    }

    @Test
    public void testDelete() {
        recrutadorRepository.delete(recrutador);
        
        // Verifica se o recrutador foi realmente deletado
        assertThat(recrutadorRepository.findById(recrutador.getUser_id())).isEmpty();
    }
}
