package com.back_end.JobsRocket.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CurriculoRequestDto {
	
	private CurriculoPrincipaisDto principais;
    
    private CurriculoPessoaisDto pessoais;
    
    private List<CurriculoAcademicosDto> academicos;
    
    private List<CurriculoProfissionaisDto> profissionais;
    
    private List<CurriculoCursosDto> cursos;

}
