package com.back_end.JobsRocket.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "curriculo_pessoais")
public class CurriculoPessoais {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer pessoais_id;

    @Column(nullable = false)
    private Date dataNascimento;

    @Column(nullable = false)
    private String pais;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private String linkedin;

    @Column(nullable = false)
    private String github;

    @Column(nullable = false)
    private String portfolioUrl;

    @OneToOne
    @JoinColumn(name = "curriculo_id")
    private Curriculo curriculo;
}
