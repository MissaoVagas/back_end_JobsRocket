package com.back_end.JobsRocket.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class CurriculoAcademicosTest {

    @Test
    public void testGettersAndSetters() {
        CurriculoAcademicos academico = new CurriculoAcademicos();
        academico.setNomeFaculdade("Universidade XYZ");
        academico.setDataInicio(new Date());
        
        assertEquals("Universidade XYZ", academico.getNomeFaculdade());
        assertNotNull(academico.getDataInicio());
    }
}
