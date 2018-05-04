package com.rodrigo.project.model.user;

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
import javax.validation.constraints.NotNull;

import com.rodrigo.project.model.person.PersonEntity;

/* @author Rodrigo Fernandes */

@Entity
@Table(name = "usuario")
public class UserEntity {

	private static final long serialVersionUID = 1L;

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO) -- Conexao com o Mysql

	/* PostgreSQL: conexao com o postgres.... cria a sequencia (auto incremento) */
	@SequenceGenerator(name = "user_seq", sequenceName = "user_seq")
	/* PostgreSQL: gera o auto incremento */
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	@Column(name = "id_usuario", nullable = false)
	private Long id;

	@NotNull
	@Column(name = "usu_login", nullable = false, length = 30)
	private String login;

	@NotNull
	@Column(name = "usu_senha", nullable = false, length = 20)
	private String password;

	@Column(name = "usu_situacao", nullable = false, length = 1)
	private String situation;

	@Column(name = "usu_admin", nullable = false, length = 1)
	private String typeadmin;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_person_user"), nullable = false, name = "id_pessoa")
	private PersonEntity persons;

	// Construction

	public UserEntity(String login, String password, String situation, String typeadmin, PersonEntity persons) {
		super();
		this.login = login;
		this.password = password;
		this.situation = situation;
		this.typeadmin = typeadmin;
		this.persons = persons;
	}

	public UserEntity() {

	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	public String getTypeadmin() {
		return typeadmin;
	}

	public void setTypeadmin(String typeadmin) {
		this.typeadmin = typeadmin;
	}

	public PersonEntity getPersons() {
		return persons;
	}

	public void setPersons(PersonEntity persons) {
		this.persons = persons;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
