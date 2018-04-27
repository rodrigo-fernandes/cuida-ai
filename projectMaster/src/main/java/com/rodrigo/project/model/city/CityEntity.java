package com.rodrigo.project.model.city;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.rodrigo.project.model.state.StateEntity;

/* @author Rodrigo Fernandes */

@Entity
@Table(name = "cidade")
public class CityEntity {

	private static final long serialVersionUID = 1L;

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO) -- Conexao com o Mysql
	/* PostgreSQL: conexao com o postgres.... cria a sequencia (auto incremento) */
	@SequenceGenerator(name = "city_seq", sequenceName = "city_seq")
	/* PostgreSQL: gera o auto incremento */
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_seq")
	@Column(name = "id_cid", nullable = false)
	private Long id;

	@Column(name = "cid_nome", nullable = false, length = 100)
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

	public CityEntity() {

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
