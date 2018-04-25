package com.rodrigo.project.model.state;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/* @author Rodrigo Fernandes */

@Entity
@Table(name = "uf")
public class StateEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_uf", nullable = false)
	private Long id;

	@Column(name = "uf_estado")
	private char abbreviation;

	@Column(name = "nm_estado")
	private String name;

	// Construction
	public StateEntity(char abbreviation, String name) {
		super();
		this.abbreviation = abbreviation;
		this.name = name;
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public char getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(char abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
