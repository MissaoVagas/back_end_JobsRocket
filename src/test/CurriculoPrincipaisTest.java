package com.back_end.JobsRocket.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CurriculoPrincipaisTest {

    @Test
    public void testGettersAndSetters() {
        CurriculoPrincipais principais = new CurriculoPrincipais();
        principais.setUsername("usuario_principal");
        principais.setSobre("Desenvolvedor de software.");
        
        // A propriedade foto é um File, que pode ser difícil de testar diretamente
        // Portanto, vamos apenas verificar se as outras propriedades funcionam
        principais.setFoto(null); // Simulando que não há foto

        assertEquals("usuario_principal", principais.getUsername());
        assertEquals("Desenvolvedor de software.", principais.getSobre());
    }
}
