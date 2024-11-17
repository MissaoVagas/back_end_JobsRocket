package com.back_end.JobsRocket.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CurriculoCursosTest {

    @Test
    public void testGettersAndSetters() {
        CurriculoCursos curso = new CurriculoCursos();
        curso.setNomeCurso("Java Avançado");
        
        assertEquals("Java Avançado", curso.getNomeCurso());
    }
}
