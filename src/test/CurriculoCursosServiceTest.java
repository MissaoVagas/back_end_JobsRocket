package com.back_end.JobsRocket.service;

import com.back_end.JobsRocket.model.CurriculoCursos;
import com.back_end.JobsRocket.repository.CurriculoCursosRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class CurriculoCursosServiceTest {

    @InjectMocks
    private CurriculoCursosService service;

    @Mock
    private CurriculoCursosRepository repository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCriarCurso() {
        CurriculoCursos curso = new CurriculoCursos();
        curso.setNomeCurso("Curso de Java");

        when(repository.save(any(CurriculoCursos.class))).thenReturn(curso);

        CurriculoCursos savedCurso = service.criarCurso(curso);
        
        assertThat(savedCurso.getNomeCurso()).isEqualTo("Curso de Java");
        verify(repository, times(1)).save(curso);
    }

    @Test
    public void testAtualizarCurso() {
        CurriculoCursos cursoExistente = new CurriculoCursos();
        cursoExistente.setId(1);
        
        when(repository.findById(1)).thenReturn(Optional.of(cursoExistente));
        
        CurriculoCursos novoCurso = new CurriculoCursos();
        novoCurso.setInstituicao("Nova Instituição");
        
        when(repository.save(any(CurriculoCursos.class))).thenReturn(novoCurso);

        CurriculoCursos updatedCurso = service.atualizarCurso(novoCurso, 1);
        
        assertThat(updatedCurso.getInstituicao()).isEqualTo("Nova Instituição");
    }

    @Test
    public void testDeletarCurso() {
        doNothing().when(repository).delete(any(CurriculoCursos.class));
        
        service.deletarCurso(1);
        
        verify(repository, times(1)).deleteById(1);
    }
}
