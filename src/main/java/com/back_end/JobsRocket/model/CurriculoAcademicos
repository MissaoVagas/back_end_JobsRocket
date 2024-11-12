package com.back_end.JobsRocket.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "curriculo_academicos")
public class CurriculoAcademicos {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private String nomeFaculdade;

    @Column(nullable = false)
    private String nomeCurso;

    @Column(nullable = false)
    private Date dataInicio;

    @Column(nullable = false)
    private Date dataFinal;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status statusFaculdade;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoCurso tipoCurso;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoFormacao tipoFormacao;

    private String atividadesExtras;
    
    // Relacionamento com Curriculo (se necessário)
    @ManyToOne
    @JoinColumn(name = "curriculo_id")
    private Curriculo curriculo;
}
