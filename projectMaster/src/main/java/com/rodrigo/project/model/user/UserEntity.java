package com.rodrigo.project.model.user;

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

import com.rodrigo.project.model.person.PersonEntity;

/* @author Rodrigo Fernandes */

@Entity
@Table(name = "usuario")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_usuario", nullable = false)
	private Long id;

	@NotNull
	@Column(name = "usu_login", nullable = false)
	private String login;

	@NotNull
	@Column(name = "usu_senha", nullable = false)
	private String password;

	@Column(name = "usu_situacao", nullable = false)
	private char situation;

	@Column(name = "usu_admin", nullable = false)
	private char typeadmin;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_person_user"), nullable = false, name = "id_pessoa")
	private PersonEntity persons;

	// Construction
	public UserEntity(String login, String password, char situation, char typeadmin) {
		super();
		this.login = login;
		this.password = password;
		this.situation = situation;
		this.typeadmin = typeadmin;
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

	public char getSituation() {
		return situation;
	}

	public void setSituation(char situation) {
		this.situation = situation;
	}

	public char getTypeadmin() {
		return typeadmin;
	}

	public void setTypeadmin(char typeadmin) {
		this.typeadmin = typeadmin;
	}

	public PersonEntity getPersons() {
		return persons;
	}

	public void setPersons(PersonEntity persons) {
		this.persons = persons;
	}

}
