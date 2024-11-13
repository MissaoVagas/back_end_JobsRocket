package com.back_end.JobsRocket.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name= "curriculos")
public class Curriculo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer curriculo_id;
    
    @OneToOne
    @JoinColumn(name = "candidato_id", referencedColumnName = "user_id")
    private Candidato candidato;
    
    @OneToOne
    @JoinColumn(name = "principais_id")
    private CurriculoPrincipais principais;
    
    @OneToOne
    @JoinColumn(name = "pessoais_id")
    private CurriculoPessoais pessoais;
    
    @OneToMany(mappedBy = "curriculo", cascade = CascadeType.ALL)
    private List<CurriculoAcademicos> academicos;
    
    @OneToMany(mappedBy = "curriculo", cascade = CascadeType.ALL)
    private List<CurriculoProfissionais> profissionais;
    
    @OneToMany(mappedBy = "curriculo", cascade = CascadeType.ALL)
    private List<CurriculoCursos> cursos;

    
}
