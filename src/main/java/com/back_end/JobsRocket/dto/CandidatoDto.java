package com.back_end.JobsRocket.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
 class CandidatoDto {
	
	private Integer user_id;
	
	private String nome;
	
	private String email;
	
	private String campoDeInteresse;

    private Integer curriculo_id;

}
