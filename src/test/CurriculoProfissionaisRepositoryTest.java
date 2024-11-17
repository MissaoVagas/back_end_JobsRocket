package com.back_end.JobsRocket.repository;

import com.back_end.JobsRocket.model.CurriculoProfissionais;
import com.back_end.JobsRocket.model.enums.TipoEmprego;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CurriculoProfissionaisRepositoryTest {

    @Autowired
    private CurriculoProfissionaisRepository curriculoProfissionaisRepository;

    @BeforeEach
    public void setUp() {
        CurriculoProfissionais profissionais = new CurriculoProfissionais();
        profissionais.setNomeEmpresa("Empresa ABC");
        profissionais.setCargo("Desenvolvedor");
        profissionais.setDataInicio(new Date());
        profissionais.setTipoEmprego(TipoEmprego.FULL_TIME); // Supondo que FULL_TIME é um valor do enum TipoEmprego
        curriculoProfissionaisRepository.save(profissionais);
    }

    @Test
    public void testFindByNomeEmpresa() {
        List<CurriculoProfissionais> resultados = curriculoProfissionaisRepository.findByNomeEmpresa("Empresa ABC");
        assertThat(resultados).isNotEmpty();
        assertThat(resultados.get(0).getNomeEmpresa()).isEqualTo("Empresa ABC");
    }

    @Test
    public void testFindByCargo() {
        List<CurriculoProfissionais> resultados = curriculoProfissionaisRepository.findByCargo("Desenvolvedor");
        assertThat(resultados).isNotEmpty();
        assertThat(resultados.get(0).getCargo()).isEqualTo("Desenvolvedor");
    }

    @Test
    public void testFindByTipoEmprego() {
        List<CurriculoProfissionais> resultados = curriculoProfissionaisRepository.findByTipoEmprego(TipoEmprego.FULL_TIME);
        assertThat(resultados).isNotEmpty();
        assertThat(resultados.get(0).getTipoEmprego()).isEqualTo(TipoEmprego.FULL_TIME);
    }
}
