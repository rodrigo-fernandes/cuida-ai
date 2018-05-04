package com.rodrigo.project.model.address;

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

import com.rodrigo.project.model.logradouro.LogradouroEntity;
import com.rodrigo.project.model.person.PersonEntity;

/* @author Rodrigo Fernandes */

@Entity
@Table(name = "endereco")
public class AddressEntity {

	private static final long serialVersionUID = 1L;

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO) -- Conexao com o Mysql

	/* PostgreSQL: conexao com o postgres.... cria a sequencia (auto incremento) */
	@SequenceGenerator(name = "address_seq", sequenceName = "address_seq")
	/* PostgreSQL: gera o auto incremento */
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
	@Column(name = "id_endereco", nullable = false)
	private Long id;

	@Column(name = "end_numero", nullable = false, length = 15)
	private String name;

	@Column(name = "end_complemento", nullable = false)
	private String complement;

	@Column(name = "end_tipo", nullable = false, length = 1)
	private char type;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_logradouro_endereco"), nullable = false, name = "id_lgd")
	private LogradouroEntity logradouroEntity;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_person_endereco"), nullable = false, name = "id_pessoa")
	private PersonEntity personEntity;

	// Construction
	public AddressEntity(String name, String complement, char type, LogradouroEntity logradouroEntity) {
		super();
		this.name = name;
		this.complement = complement;
		this.type = type;
		this.logradouroEntity = logradouroEntity;
	}

	public AddressEntity() {

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

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
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

	public PersonEntity getPersonEntity() {
		return personEntity;
	}

	public void setPersonEntity(PersonEntity personEntity) {
		this.personEntity = personEntity;
	}

}
