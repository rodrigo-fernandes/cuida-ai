package com.rodrigo.project.model.institution;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.rodrigo.project.model.logradouro.LogradouroEntity;

/* @author Rodrigo Fernandes */

@Entity
@Table(name = "instituicao")
public class InstitutionEntity {

	private static final long serialVersionUID = 1L;

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO) -- Conexao com o Mysql

	/* PostgreSQL: conexao com o postgres.... cria a sequencia (auto incremento) */
	@SequenceGenerator(name = "instituition_seq", sequenceName = "instituition_seq")
	/* PostgreSQL: gera o auto incremento */
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "instituition_seq")
	@Column(name = "id_instituicao", nullable = false)
	private Long id;

	@NotNull
	@Column(name = "razaosocial", nullable = false, length = 100)
	private String name;

	@NotNull
	@Column(name = "nomefantasia", nullable = false, length = 100)
	private String fantasyName;

	@NotNull
	@Column(name = "cnpj", nullable = false, length = 15)
	private String cnpj;

	@NotNull
	@Column(name = "inscmunicipal", nullable = false, length = 15)
	private String municipalRegistration;

	@Column(name = "homepage", nullable = false, length = 50)
	private String homePage;

	@OneToOne
	@JoinColumn(name = "id_lgd")
	private LogradouroEntity logradouroEntity;

	// Construction
	public InstitutionEntity(@NotNull String name, @NotNull String fantasyName, @NotNull String cnpj,
			@NotNull String municipalRegistration, String homePage) {
		super();
		this.name = name;
		this.fantasyName = fantasyName;
		this.cnpj = cnpj;
		this.municipalRegistration = municipalRegistration;
		this.homePage = homePage;
	}

	public InstitutionEntity() {

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

	public String getFantasyName() {
		return fantasyName;
	}

	public void setFantasyName(String fantasyName) {
		this.fantasyName = fantasyName;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getMunicipalRegistration() {
		return municipalRegistration;
	}

	public void setMunicipalRegistration(String municipalRegistration) {
		this.municipalRegistration = municipalRegistration;
	}

	public String getHomePage() {
		return homePage;
	}

	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}

	public LogradouroEntity getLogradouroEntity() {
		return logradouroEntity;
	}

	public void setLogradouroEntity(LogradouroEntity logradouroEntity) {
		this.logradouroEntity = logradouroEntity;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
