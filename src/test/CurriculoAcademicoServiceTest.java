package com.back_end.JobsRocket.service;

import com.back_end.JobsRocket.model.CurriculoAcademicos;
import com.back_end.JobsRocket.model.enums.Status;
import com.back_end.JobsRocket.repository.CurriculoAcademicosRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CurriculoAcademicosServiceTest {

    @InjectMocks
    private CurriculoAcademicosService service;

    @Mock
    private CurriculoAcademicosRepository repository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testListarTodos() {
        CurriculoAcademicos academico1 = new CurriculoAcademicos();
        academico1.setNomeFaculdade("Universidade A");
        
        CurriculoAcademicos academico2 = new CurriculoAcademicos();
        academico2.setNomeFaculdade("Universidade B");

        when(repository.findAll()).thenReturn(Arrays.asList(academico1, academico2));

        List<CurriculoAcademicos> result = service.listarTodos();
        
        assertThat(result).hasSize(2);
        assertThat(result.get(0).getNomeFaculdade()).isEqualTo("Universidade A");
        assertThat(result.get(1).getNomeFaculdade()).isEqualTo("Universidade B");
    }

    @Test
    public void testSalvar() {
        CurriculoAcademicos academico = new CurriculoAcademicos();
        academico.setNomeFaculdade("Universidade A");

        when(repository.save(any(CurriculoAcademicos.class))).thenReturn(academico);

        CurriculoAcademicos saved = service.salvar(academico);
        
        assertThat(saved.getNomeFaculdade()).isEqualTo("Universidade A");
        verify(repository, times(1)).save(academico);
    }

    @Test
    public void testBuscarPorId() {
        CurriculoAcademicos academico = new CurriculoAcademicos();
        academico.setNomeFaculdade("Universidade A");

        when(repository.findById(1)).thenReturn(java.util.Optional.of(academico));

        CurriculoAcademicos found = service.buscarPorId(1);
        
        assertThat(found).isNotNull();
        assertThat(found.getNomeFaculdade()).isEqualTo("Universidade A");
    }

    @Test
    public void testDeletar() {
        doNothing().when(repository).deleteById(1);
        
        service.deletar(1);
        
        verify(repository, times(1)).deleteById(1);
    }
}
