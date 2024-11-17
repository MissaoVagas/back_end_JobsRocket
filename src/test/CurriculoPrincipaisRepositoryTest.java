package com.back_end.JobsRocket.repository;

import com.back_end.JobsRocket.model.CurriculoPrincipais;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CurriculoPrincipaisRepositoryTest {

    @Autowired
    private CurriculoPrincipaisRepository curriculoPrincipaisRepository;

    @BeforeEach
    public void setUp() {
        CurriculoPrincipais principais = new CurriculoPrincipais();
        principais.setUsername("usuario_principal");
        curriculoPrincipaisRepository.save(principais);
    }

    @Test
    public void testFindById() {
        CurriculoPrincipais principais = curriculoPrincipaisRepository.findById(1).orElse(null);
        assertThat(principais).isNotNull();
        assertThat(principais.getUsername()).isEqualTo("usuario_principal");
    }
}
