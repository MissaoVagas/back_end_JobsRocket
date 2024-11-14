package com.back_end.JobsRocket.dto;


import com.back_end.JobsRocket.model.Curriculo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class CandidatoResponseDto extends UserResponseDto {
	
	private String campoDeInteresse;

    private Curriculo curriculo;

}
