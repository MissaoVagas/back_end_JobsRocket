package com.back_end.JobsRocket.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;
import com.back_end.JobsRocket.model.enums.TipoEmprego;

public class CurriculoProfissionaisTest {

    @Test
    public void testGettersAndSetters() {
        CurriculoProfissionais profissionais = new CurriculoProfissionais();
        profissionais.setNomeEmpresa("Empresa ABC");
        profissionais.setCargo("Desenvolvedor");
        profissionais.setDataInicio(new Date());
        profissionais.setDataFinal(new Date());
        profissionais.setTipoEmprego(TipoEmprego.FULL_TIME); // Supondo que TipoEmprego é um enum

        assertEquals("Empresa ABC", profissionais.getNomeEmpresa());
        assertEquals("Desenvolvedor", profissionais.getCargo());
        assertNotNull(profissionais.getDataInicio());
        assertNotNull(profissionais.getDataFinal());
        assertEquals(TipoEmprego.FULL_TIME, profissionais.getTipoEmprego());
    }
}
