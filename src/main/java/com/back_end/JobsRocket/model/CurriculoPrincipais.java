package com.back_end.JobsRocket.model;

import jakarta.persistence.*;
import lombok.Data;
import java.io.File;

@Entity
@Data
@Table(name = "curriculo_principais")
public class CurriculoPrincipais {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String sobre;

    @Column(nullable = false)
    private File foto;

    @OneToOne
    @JoinColumn(name = "curriculo_id")
    private Curriculo curriculo;
}
