package com.back_end.JobsRocket.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CurriculoTest {

    @Test
    public void testGettersAndSetters() {
        Curriculo curriculo = new Curriculo();
        curriculo.setCurriculo_id(1);

        assertThat(curriculo.getCurriculo_id()).isEqualTo(1);
    }

    @Test
    public void testSetCandidato() {
        Curriculo curriculo = new Curriculo();
        Candidato candidato = new Candidato();
        candidato.setNome("João Silva");

        curriculo.setCandidato(candidato);
        
        assertThat(curriculo.getCandidato()).isNotNull();
        assertThat(curriculo.getCandidato().getNome()).isEqualTo("João Silva");
    }

    @Test
    public void testSetPessoais() {
        Curriculo curriculo = new Curriculo();
        CurriculoPessoais pessoais = new CurriculoPessoais();
        pessoais.setLinkedin("linkedin.com/in/exemplo");

        curriculo.setPessoais(pessoais);
        
        assertThat(curriculo.getPessoais()).isNotNull();
        assertThat(curriculo.getPessoais().getLinkedin()).isEqualTo("linkedin.com/in/exemplo");
    }

    @Test
    public void testSetPrincipais() {
        Curriculo curriculo = new Curriculo();
        CurriculoPrincipais principais = new CurriculoPrincipais();
        principais.setUsername("usuario_principal");

        curriculo.setPrincipais(principais);
        
        assertThat(curriculo.getPrincipais()).isNotNull();
        assertThat(curriculo.getPrincipais().getUsername()).isEqualTo("usuario_principal");
    }

    @Test
    public void testSetAcademicos() {
        Curriculo curriculo = new Curriculo();
        List<CurriculoAcademicos> academicos = new ArrayList<>();
        
        CurriculoAcademicos academico = new CurriculoAcademicos();
        academico.setNomeFaculdade("Universidade A");
        
        academicos.add(academico);
        
        curriculo.setAcademicos(academicos);
        
        assertThat(curriculo.getAcademicos()).isNotEmpty();
        assertThat(curriculo.getAcademicos().get(0).getNomeFaculdade()).isEqualTo("Universidade A");
    }

    @Test
    public void testSetProfissionais() {
        Curriculo curriculo = new Curriculo();
        List<CurriculoProfissionais> profissionais = new ArrayList<>();
        
        CurriculoProfissionais profissional = new CurriculoProfissionais();
        profissional.setNomeEmpresa("Empresa B");
        
        profissionais.add(profissional);
        
        curriculo.setProfissionais(profissionais);
        
        assertThat(curriculo.getProfissionais()).isNotEmpty();
        assertThat(curriculo.getProfissionais().get(0).getNomeEmpresa()).isEqualTo("Empresa B");
    }

    @Test
    public void testSetCursos() {
        Curriculo curriculo = new Curriculo();
        List<CurriculoCursos> cursos = new ArrayList<>();
        
        CurriculoCursos curso = new CurriculoCursos();
        curso.setNomeCurso("Curso de Java");
        
        cursos.add(curso);
        
        curriculo.setCursos(cursos);
        
        assertThat(curriculo.getCursos()).isNotEmpty();
        assertThat(curriculo.getCursos().get(0).getNomeCurso()).isEqualTo("Curso de Java");
    }


}
