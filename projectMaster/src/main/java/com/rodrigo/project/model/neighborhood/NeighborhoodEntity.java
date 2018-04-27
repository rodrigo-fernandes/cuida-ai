package com.rodrigo.project.model.neighborhood;

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

import com.rodrigo.project.model.city.CityEntity;

/* @author Rodrigo Fernandes */

@Entity
@Table(name = "bairro")
public class NeighborhoodEntity {

	private static final long serialVersionUID = 1L;

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO) -- Conexao com o Mysql

	/* PostgreSQL: conexao com o postgres.... cria a sequencia (auto incremento) */
	@SequenceGenerator(name = "neighborhood_seq", sequenceName = "neighborhood_seq")
	/* PostgreSQL: gera o auto incremento */
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "neighborhood_seq")
	@Column(name = "id_bairro", nullable = false)
	private Long id;

	@Column(name = "bai_nome", nullable = false, length = 200)
	private String name;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_city_neighborhood"), nullable = false, name = "id_cid")
	private CityEntity citys;

	// Construction
	public NeighborhoodEntity(String name, CityEntity citys) {
		super();
		this.name = name;
		this.citys = citys;
	}

	public NeighborhoodEntity() {

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

	public CityEntity getCitys() {
		return citys;
	}

	public void setCitys(CityEntity citys) {
		this.citys = citys;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
