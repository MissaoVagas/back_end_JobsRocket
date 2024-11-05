package com.back_end.JobsRocket.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "curriculo_cursos")
public class CurriculoCursos {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    
	@Column(nullable = false)
    private String nomeCurso;
	
	@Column(nullable = false)
    private String instituicao;
	
	@Column(nullable = false)
    private String duracao;
	
    private String descricao;
    
    @ManyToOne
    @JoinColumn(name = "curriculo_id")
    private Curriculo curriculo;
}
