package com.back_end.JobsRocket.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CurriculoCursosDto {
	
	private String nomeCurso;
	
    private String instituicao;

    private String duracao;
	
    private String descricao;

}
