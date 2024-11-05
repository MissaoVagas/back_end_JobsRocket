package com.back_end.JobsRocket.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "recrutadores")
public class Recrutador extends User {

	@Column(nullable = false)
	private String nomeEmpresa;
}
