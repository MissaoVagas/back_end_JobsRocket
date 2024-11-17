package com.back_end.JobsRocket.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CurriculoPrincipaisTest {

    @Test
    public void testGettersAndSetters() {
        CurriculoPrincipais principais = new CurriculoPrincipais();
        principais.setUsername("usuario_principal");
        principais.setSobre("Desenvolvedor de software.");
        
        // A propriedade foto é um File, que pode ser difícil de testar diretamente
        principais.setFoto(null); // Simulando que não há foto

        assertThat(principais.getUsername()).isEqualTo("usuario_principal");
        assertThat(principais.getSobre()).isEqualTo("Desenvolvedor de software.");
    }

    @Test
    public void testSetFoto() {
        CurriculoPrincipais principais = new CurriculoPrincipais();
        
        // Testando a definição da foto como null
        principais.setFoto(null);
        assertThat(principais.getFoto()).isNull();
        
        // Se houver uma lógica específica para a foto (ex: não permitir null), adicione aqui.
    }

    @Test
    public void testInvalidUsername() {
        CurriculoPrincipais principais = new CurriculoPrincipais();
        
        // Testando se uma exceção é lançada ao definir um username inválido (se aplicável)
        assertThrows(IllegalArgumentException.class, () -> {
            principais.setUsername(null); // Supondo que isso não é permitido
        });
    }
    
    @Test
    public void testInvalidSobre() {
        CurriculoPrincipais principais = new CurriculoPrincipais();
        
        // Testando se uma exceção é lançada ao definir um sobre inválido (se aplicável)
        assertThrows(IllegalArgumentException.class, () -> {
            principais.setSobre(null); // Supondo que isso não é permitido
        });
    }
}
