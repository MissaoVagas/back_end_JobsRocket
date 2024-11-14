package com.back_end.JobsRocket.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RecrutadorRequestDto extends UserRequestDto {
	
	private String nomeEmpresa;

}
