package com.back_end.JobsRocket.service;

import com.back_end.JobsRocket.model.CurriculoPrincipais;
import com.back_end.JobsRocket.repository.CurriculoPrincipaisRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CurriculoPrincipaisServiceTest {

    @InjectMocks
    private CurriculoPrincipaisService service;

    @Mock
    private CurriculoPrincipaisRepository repository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSalvar() {
        // Criação de um objeto CurriculoPrincipais para teste
        CurriculoPrincipais principais = new CurriculoPrincipais();
        principais.setUsername("usuario_principal");
        principais.setSobre("Desenvolvedor de software.");

        // Configurando o comportamento do mock
        when(repository.save(any(CurriculoPrincipais.class))).thenReturn(principais);

        // Chamando o método a ser testado
        CurriculoPrincipais saved = service.salvar(principais);

        // Verificações
        assertThat(saved).isNotNull();
        assertThat(saved.getUsername()).isEqualTo("usuario_principal");
        assertThat(saved.getSobre()).isEqualTo("Desenvolvedor de software.");
        
        // Verificando se o método save foi chamado uma vez
        verify(repository, times(1)).save(principais);
    }

    @Test
    public void testBuscarPorId() {
        // Configurando um objeto de exemplo para ser retornado pelo mock
        CurriculoPrincipais principais = new CurriculoPrincipais();
        principais.setUsername("usuario_principal");
        
        when(repository.findById(1)).thenReturn(Optional.of(principais));

        // Chamando o método a ser testado
        CurriculoPrincipais found = service.buscarPorId(1);

        // Verificações
        assertThat(found).isNotNull();
        assertThat(found.getUsername()).isEqualTo("usuario_principal");
        
        // Verificando se o método findById foi chamado uma vez
        verify(repository, times(1)).findById(1);
    }

    @Test
    public void testDeletar() {
        doNothing().when(repository).deleteById(1);

        // Chamando o método a ser testado
        service.deletar(1);

        // Verificando se o método deleteById foi chamado uma vez
        verify(repository, times(1)).deleteById(1);
    }
}
