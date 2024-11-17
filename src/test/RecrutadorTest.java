package com.back_end.JobsRocket.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RecrutadorTest {

    @Test
    public void testGettersAndSetters() {
        Recrutador recrutador = new Recrutador();
        recrutador.setNome("Carlos Silva");
        recrutador.setNomeEmpresa("Recrutadora XYZ");

        assertEquals("Carlos Silva", recrutador.getNome());
        assertEquals("Recrutadora XYZ", recrutador.getNomeEmpresa());
    }
}
