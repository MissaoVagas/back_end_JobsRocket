package com.back_end.JobsRocket.service;

import com.back_end.JobsRocket.model.CurriculoPessoais;
import com.back_end.JobsRocket.repository.CurriculoPessoaisRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class CurriculoPessoaisServiceTest {

    @InjectMocks
    private CurriculoPessoaisService service;

    @Mock
    private CurriculoPessoaisRepository repository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSalvar() {
        CurriculoPessoais pessoais = new CurriculoPessoais();
        
        when(repository.save(any(CurriculoPessoais.class))).thenReturn(pessoais);

        CurriculoPessoais saved = service.salvar(pessoais);
        
        assertThat(saved).isNotNull();
        verify(repository, times(1)).save(pessoais);
    }

    @Test
    public void testBuscarPorId() {
        CurriculoPessoais pessoais = new CurriculoPessoais();

        when(repository.findById(1)).thenReturn(Optional.of(pessoais));

        CurriculoPessoais found = service.buscarPorId(1);
        
        assertThat(found).isNotNull();
    }

    @Test
    public void testDeletar() {
        doNothing().when(repository).deleteById(1);
        
        service.deletar(1);
        
        verify(repository, times(1)).deleteById(1);
    }
}
