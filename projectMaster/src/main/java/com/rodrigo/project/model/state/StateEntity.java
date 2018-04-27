package com.rodrigo.project.model.state;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/* @author Rodrigo Fernandes */

@Entity
@Table(name = "uf")
public class StateEntity {

	private static final long serialVersionUID = 1L;

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO) -- Conexao com o Mysql

	/* PostgreSQL: conexao com o postgres.... cria a sequencia (auto incremento) */
	@SequenceGenerator(name = "uf_seq", sequenceName = "uf_seq")
	/* PostgreSQL: gera o auto incremento */
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "uf_seq")
	@Column(name = "id_uf", nullable = false)
	private Long id;

	@Column(name = "uf_estado", length = 2)
	private String abbreviation;

	@Column(name = "nm_estado", length = 100)
	private String name;

	// Construction
	public StateEntity(String abbreviation, String name) {
		super();
		this.abbreviation = abbreviation;
		this.name = name;
	}
	
	
	public StateEntity() {
		
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
