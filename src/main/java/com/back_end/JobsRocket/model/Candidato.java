package com.back_end.JobsRocket.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "candidatos")
public class Candidato extends User {
    private String campoDeInteresse;

    @OneToOne
    @JoinColumn(name = "curriculo_id")
    private Curriculo curriculo;
}
