package com.rodrigo.project.model.logradouro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.rodrigo.project.model.neighborhood.NeighborhoodEntity;

/* @author Rodrigo Fernandes */

@Entity
@Table(name = "logradouro")
public class LogradouroEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_lgd", nullable = false)
	private Long id;

	@NotNull
	@Column(name = "ldg_descricao", nullable = false)
	private String name;

	@NotNull
	@Column(name = "lgd_cep", nullable = false)
	private String cep;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_logradouro_neighborhood"), nullable = false, name = "id_bairro")
	private NeighborhoodEntity neighborhood;

	// Construction
	public LogradouroEntity(String name, String cep, NeighborhoodEntity neighborhood) {
		super();
		this.name = name;
		this.cep = cep;
		this.neighborhood = neighborhood;
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public NeighborhoodEntity getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(NeighborhoodEntity neighborhood) {
		this.neighborhood = neighborhood;
	}

}
