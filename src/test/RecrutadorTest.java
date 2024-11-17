package com.back_end.JobsRocket.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RecrutadorTest {

    @Test
    public void testGettersAndSetters() {
        Recrutador recrutador = new Recrutador();
        recrutador.setNome("Carlos Silva");
        recrutador.setNomeEmpresa("Recrutadora XYZ");

        assertThat(recrutador.getNome()).isEqualTo("Carlos Silva");
        assertThat(recrutador.getNomeEmpresa()).isEqualTo("Recrutadora XYZ");
    }

    @Test
    public void testSetNomeNull() {
        Recrutador recrutador = new Recrutador();
        
        // Testando se uma exceção é lançada ao definir nome como null
        assertThrows(IllegalArgumentException.class, () -> {
            recrutador.setNome(null); // Supondo que isso não é permitido
        });
    }

    @Test
    public void testSetNomeEmpresaNull() {
        Recrutador recrutador = new Recrutador();
        
        // Testando se uma exceção é lançada ao definir nomeEmpresa como null
        assertThrows(IllegalArgumentException.class, () -> {
            recrutador.setNomeEmpresa(null); // Supondo que isso não é permitido
        });
    }

    @Test
    public void testSetEmail() {
        Recrutador recrutador = new Recrutador();
        recrutador.setEmail("carlos.silva@example.com");

        assertThat(recrutador.getEmail()).isEqualTo("carlos.silva@example.com");
    }

    @Test
    public void testSetTelefone() {
        Recrutador recrutador = new Recrutador();
        recrutador.setTelefone("123456789");

        assertThat(recrutador.getTelefone()).isEqualTo("123456789");
    }

    
}
