package com.back_end.JobsRocket.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RecrutadorDto {
	
	private Integer user_id;
	
	private String nome;
	
	private String email;
	
	private String nomeEmpresa;

}
