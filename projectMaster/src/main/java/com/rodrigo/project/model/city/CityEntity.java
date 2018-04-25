package com.rodrigo.project.model.city;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.rodrigo.project.model.state.StateEntity;

/* @author Rodrigo Fernandes */

@Entity
@Table(name = "cidade")
public class CityEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_cid", nullable = false)
	private Long id;

	@Column(name = "cid_nome", nullable = false)
	private String name;

	@Column(name = "cid_codibge", nullable = false)
	private String codibge;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_state_city"), nullable = false, name = "id_uf")
	private StateEntity states;

	// Construction
	public CityEntity(String name, String codibge) {
		super();
		this.name = name;
		this.codibge = codibge;

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

	public String getCodibge() {
		return codibge;
	}

	public void setCodibge(String codibge) {
		this.codibge = codibge;
	}

	public StateEntity getStates() {
		return states;
	}

	public void setStates(StateEntity states) {
		this.states = states;
	}

}
