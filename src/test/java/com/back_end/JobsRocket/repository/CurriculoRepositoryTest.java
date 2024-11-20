package com.back_end.JobsRocket.repository;

import com.back_end.JobsRocket.model.Curriculo;
import com.back_end.JobsRocket.model.Candidato;
import com.back_end.JobsRocket.model.CurriculoAcademicos;
import com.back_end.JobsRocket.model.CurriculoProfissionais;
import com.back_end.JobsRocket.model.CurriculoCursos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CurriculoRepositoryTest {

    @Autowired
    private CurriculoRepository curriculoRepository;

    @BeforeEach
    public void setUp() {
        // Aqui você pode configurar dados iniciais, se necessário.
    }

    @Test
    public void testSaveCurriculo() {
        // Arrange
        Candidato candidato = new Candidato();
        candidato.setUser_id(1);  // Por exemplo, um ID fictício para o candidato

        Curriculo curriculo = new Curriculo();
        curriculo.setCandidato(candidato);
        // Defina outros atributos de 'curriculo' conforme necessário

        // Act
        Curriculo savedCurriculo = curriculoRepository.save(curriculo);

        // Assert
        assertThat(savedCurriculo).isNotNull();
        assertThat(savedCurriculo.getCurriculo_id()).isGreaterThan(0);
        assertThat(savedCurriculo.getCandidato()).isEqualTo(candidato);
    }

    @Test
    public void testFindById() {
        // Arrange
        Candidato candidato = new Candidato();
        candidato.setUser_id(2); // Um ID fictício para o candidato

        Curriculo curriculo = new Curriculo();
        curriculo.setCandidato(candidato);
        curriculo = curriculoRepository.save(curriculo); // Salva no banco

        // Act
        Curriculo foundCurriculo = curriculoRepository.findById(curriculo.getCurriculo_id()).orElse(null);

        // Assert
        assertThat(foundCurriculo).isNotNull();
        assertThat(foundCurriculo.getCurriculo_id()).isEqualTo(curriculo.getCurriculo_id());
    }

    @Test
    public void testDeleteCurriculo() {
        // Arrange
        Candidato candidato = new Candidato();
        candidato.setUser_id(3); // Um ID fictício para o candidato

        Curriculo curriculo = new Curriculo();
        curriculo.setCandidato(candidato);
        curriculo = curriculoRepository.save(curriculo); // Salva no banco

        // Act
        curriculoRepository.delete(curriculo);

        // Assert
        Curriculo deletedCurriculo = curriculoRepository.findById(curriculo.getCurriculo_id()).orElse(null);
        assertThat(deletedCurriculo).isNull();
    }

    @Test
    public void testFindAllCurriculos() {
        // Arrange
        Candidato candidato1 = new Candidato();
        candidato1.setUser_id(4); // ID fictício para o candidato 1

        Candidato candidato2 = new Candidato();
        candidato2.setUser_id(5); // ID fictício para o candidato 2

        Curriculo curriculo1 = new Curriculo();
        curriculo1.setCandidato(candidato1);
        curriculoRepository.save(curriculo1);

        Curriculo curriculo2 = new Curriculo();
        curriculo2.setCandidato(candidato2);
        curriculoRepository.save(curriculo2);

        // Act
        List<Curriculo> curriculos = curriculoRepository.findAll();

        // Assert
        assertThat(curriculos).hasSize(2);
        assertThat(curriculos).extracting(Curriculo::getCandidato)
                .containsExactlyInAnyOrder(candidato1, candidato2);
    }
}
