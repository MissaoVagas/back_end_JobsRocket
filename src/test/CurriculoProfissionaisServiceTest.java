package com.back_end.JobsRocket.service;

import com.back_end.JobsRocket.model.CurriculoProfissionais;
import com.back_end.JobsRocket.repository.CurriculoProfissionaisRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CurriculoProfissionaisServiceTest {

    @InjectMocks
    private CurriculoProfissionaisService service;

    @Mock
    private CurriculoProfissionaisRepository repository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSalvar() {
        CurriculoProfissionais profissional = new CurriculoProfissionais();
        profissional.setNomeEmpresa("Empresa XYZ");
        profissional.setCargo("Desenvolvedor");

        when(repository.save(any(CurriculoProfissionais.class))).thenReturn(profissional);

        CurriculoProfissionais saved = service.salvar(profissional);

        assertThat(saved).isNotNull();
        assertThat(saved.getNomeEmpresa()).isEqualTo("Empresa XYZ");
        assertThat(saved.getCargo()).isEqualTo("Desenvolvedor");
        verify(repository, times(1)).save(profissional);
    }

    @Test
    public void testBuscarPorId() {
        CurriculoProfissionais profissional = new CurriculoProfissionais();
        profissional.setNomeEmpresa("Empresa XYZ");

        when(repository.findById(1)).thenReturn(Optional.of(profissional));

        CurriculoProfissionais found = service.buscarPorId(1);

        assertThat(found).isNotNull();
        assertThat(found.getNomeEmpresa()).isEqualTo("Empresa XYZ");
        verify(repository, times(1)).findById(1);
    }

    @Test
    public void testDeletar() {
        doNothing().when(repository).deleteById(1);

        service.deletar(1);

        verify(repository, times(1)).deleteById(1);
    }

    @Test
    public void testAtualizar() {
        CurriculoProfissionais profissionalExistente = new CurriculoProfissionais();
        profissionalExistente.setId(1);
        profissionalExistente.setNomeEmpresa("Empresa XYZ");
        
        when(repository.findById(1)).thenReturn(Optional.of(profissionalExistente));
        
        CurriculoProfissionais novoDados = new CurriculoProfissionais();
        novoDados.setNomeEmpresa("Nova Empresa");

        when(repository.save(any(CurriculoProfissionais.class))).thenReturn(novoDados);

        CurriculoProfissionais updated = service.atualizar(novoDados, 1);
        
        assertThat(updated).isNotNull();
        assertThat(updated.getNomeEmpresa()).isEqualTo("Nova Empresa");
        
        verify(repository, times(1)).findById(1);
        verify(repository, times(1)).save(novoDados);
    }
}
