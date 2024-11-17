package com.back_end.JobsRocket.service;

import com.back_end.JobsRocket.model.CurriculumProfissionais;
import com.back_end.JobsRocket.repository.CurriculumProfissionaisRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CurriculoProfissionaisServiceTest {

   // Similar ao exemplo anterior, adicione testes para salvar, buscar e deletar.
   // O mesmo padrão se aplica aqui como nos outros serviços.

   // Exemplo:
   @InjectMocks
   private CurriculumProfissionaisService service;

   @Mock
   private CurriculumProfissionaisRepository repository;

   @BeforeEach
   public void setUp() {
       MockitoAnnotations.openMocks(this);
   }

}
