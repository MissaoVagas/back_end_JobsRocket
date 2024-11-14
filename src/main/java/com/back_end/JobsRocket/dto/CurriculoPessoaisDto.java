package com.back_end.JobsRocket.dto;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class CurriculoPessoaisDto {
	
	private Date dataNascimento;

    private String pais;

    private String cep;

    private String estado;

    private String cidade;

    private String endereco;

    private String linkedin;

    private String github;

    private String portfolioUrl;

}
