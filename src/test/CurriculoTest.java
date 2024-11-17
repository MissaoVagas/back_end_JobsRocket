package com.back_end.JobsRocket.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CurriculoTest {

    @Test
    public void testGettersAndSetters() {
        Curriculo curriculo = new Curriculo();
        curriculo.setCurriculo_id(1);
        
        assertEquals(1, curriculo.getCurriculo_id());
    }
}
