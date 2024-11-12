package com.back_end.JobsRocket.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "curriculo_profissionais")
public class CurriculoProfissionais {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private String nomeEmpresa;

    @Column(nullable = false)
    private String cargo;

    @Column(nullable = false)
    private Date dataInicio;

    @Column(nullable = false)
    private Date dataFinal;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoEmprego tipoEmprego;

    private String responsabilidades;
    
    // Relacionamento com Curriculo (se necessário)
    @ManyToOne
    @JoinColumn(name = "curriculo_id")
    private Curriculo curriculo;
}
