package com.back_end.JobsRocket.repository;

import com.back_end.JobsRocket.model.CurriculoPessoais;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CurriculoPessoaisRepositoryTest {

    @Autowired
    private CurriculoPessoaisRepository curriculoPessoaisRepository;

    @BeforeEach
    public void setUp() {
        CurriculoPessoais pessoais = new CurriculoPessoais();
        pessoais.setPais("Brasil");
        curriculoPessoaisRepository.save(pessoais);
    }

    @Test
    public void testFindById() {
        CurriculoPessoais pessoais = curriculoPessoaisRepository.findById(1).orElse(null);
        assertThat(pessoais).isNotNull();
        assertThat(pessoais.getPais()).isEqualTo("Brasil");
    }
}
