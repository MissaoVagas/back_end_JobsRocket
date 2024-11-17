package com.back_end.JobsRocket.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CandidatoTest {

    @Test
    public void testGettersAndSetters() {
        Candidato candidato = new Candidato();
        candidato.setCampoDeInteresse("Desenvolvedor");
        
        assertEquals("Desenvolvedor", candidato.getCampoDeInteresse());
    }
}
