package com.back_end.JobsRocket.dto;

import java.util.List;

import com.back_end.JobsRocket.model.CurriculoAcademicos;
import com.back_end.JobsRocket.model.CurriculoCursos;
import com.back_end.JobsRocket.model.CurriculoPessoais;
import com.back_end.JobsRocket.model.CurriculoPrincipais;
import com.back_end.JobsRocket.model.CurriculoProfissionais;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CurriculoResponseDto {
	
	private Integer curriculo_id;
	
	private Integer candidato_id;
	
	private CurriculoPrincipais principais;
    
    private CurriculoPessoais pessoais;
    
    private List<CurriculoAcademicos> academicos;
    
    private List<CurriculoProfissionais> profissionais;
    
    private List<CurriculoCursos> cursos;

}
