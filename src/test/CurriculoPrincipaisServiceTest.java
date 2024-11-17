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
       // Similar ao exemplo anterior, adicione testes para salvar, buscar e deletar.
       // O mesmo padrão se aplica aqui como nos outros serviços.
       
       // Exemplo:
       CurriculoPrincipais principais = new CurriculoPrincipais();

       when(repository.save(any(CurriculumPrincipals.class))).thenReturn(principais);

       CurriculumPrincipals saved = service.salvar(principais);

       assertThat(saved).isNotNull();
       verify(repository, times(1)).save(principais);
   }
}
