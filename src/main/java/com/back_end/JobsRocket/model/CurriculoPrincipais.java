package com.back_end.JobsRocket.model;

import jakarta.persistence.*;
import lombok.Data;
import java.io.File;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@Table(name = "curriculo_principais")
public class CurriculoPrincipais {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer principais_id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String sobre;

    @Column
    private File foto;

    @OneToOne
    @JoinColumn(name = "curriculo_id")
    @JsonIgnore
    private Curriculo curriculo;
}
