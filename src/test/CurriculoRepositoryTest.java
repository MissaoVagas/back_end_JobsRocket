package com.back_end.JobsRocket.repository;

import com.back_end.JobsRocket.model.Curriculo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CurriculoRepositoryTest {

    @Autowired
    private CurriculoRepository curriculoRepository;

    @BeforeEach
    public void setUp() {
        Curriculo curriculo = new Curriculo();
        // Defina os atributos do currículo conforme necessário
        curriculoRepository.save(curriculo);
    }

    @Test
    public void testFindById() {
        Curriculo curriculo = curriculoRepository.findById(1).orElse(null);
        assertThat(curriculo).isNotNull();
        // Adicione mais verificações conforme necessário
    }
}
