package com.back_end.JobsRocket.dto;

import java.util.Date;

import com.back_end.JobsRocket.model.enums.TipoEmprego;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CurriculoProfissionaisDto {
	
	private String nomeEmpresa;

    private String cargo;

    private Date dataInicio;

    private Date dataFinal;

    private TipoEmprego tipoEmprego;

    private String responsabilidades;

}
