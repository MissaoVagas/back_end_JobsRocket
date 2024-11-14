package com.back_end.JobsRocket.dto;

import java.util.Date;

import com.back_end.JobsRocket.model.enums.Status;
import com.back_end.JobsRocket.model.enums.TipoCurso;
import com.back_end.JobsRocket.model.enums.TipoFormacao;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CurriculoAcademicosDto {
	
	private String nomeFaculdade;

    private String nomeCurso;

    private Date dataInicio;

    private Date dataFinal;

    private Status statusFaculdade;

    private TipoCurso tipoCurso;

    private TipoFormacao tipoFormacao;

    private String atividadesExtras;

}
