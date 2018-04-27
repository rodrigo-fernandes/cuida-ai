package com.rodrigo.project.model.person;

import java.util.Date;

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

import com.rodrigo.project.model.contact.ContactEntity;
import com.rodrigo.project.model.user.UserEntity;

/* @author Rodrigo Fernandes */

@Entity
@Table(name = "pessoa")
public class PersonEntity {

	private static final long serialVersionUID = 1L;

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO) -- Conexao com o Mysql

	/* PostgreSQL: conexao com o postgres.... cria a sequencia (auto incremento) */
	@SequenceGenerator(name = "person_seq", sequenceName = "person_seq")
	/* PostgreSQL: gera o auto incremento */
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq")
	@Column(name = "id_pessoa", nullable = false)
	private Long id;

	@NotNull
	@Column(name = "pes_nome", nullable = false, length = 100)
	private String name;

	@NotNull
	@Column(name = "pes_sobrenome", nullable = false)
	private String lastname;

	@Column(name = "pes_cpf", nullable = false, length = 11)
	private String cpf;

	@Column(name = "pes_genero", nullable = false, length = 1)
	private String genre;

	@NotNull
	@Column(name = "pes_dtnascimento", nullable = false)
	private Date dtbirth;

	@Column(name = "pes_situacao", nullable = false, length = 1)
	private char situation;

	@Column(name = "pes_dtinclusao", nullable = false)
	private Date dtinclusion;

	@Column(name = "pes_rg", nullable = false, length = 10)
	private String rg;

	@Column(name = "pes_tipo", nullable = false, length = 1)
	private char type;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_contact_person"), nullable = false, name = "id_contato")
	private ContactEntity contactEntity;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_user_person"), nullable = false, name = "id_usuario")
	private UserEntity userEntity;

	// Construction
	public PersonEntity(String name, String lastname, String cpf, String genre, Date dtbirth, char situation,
			Date dtinclusion, String rg, char type) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.cpf = cpf;
		this.genre = genre;
		this.dtbirth = dtbirth;
		this.situation = situation;
		this.dtinclusion = dtinclusion;
		this.rg = rg;
		this.type = type;
	}

	public PersonEntity() {

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

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Date getDtbirth() {
		return dtbirth;
	}

	public void setDtbirth(Date dtbirth) {
		this.dtbirth = dtbirth;
	}

	public char getSituation() {
		return situation;
	}

	public void setSituation(char situation) {
		this.situation = situation;
	}

	public Date getDtinclusion() {
		return dtinclusion;
	}

	public void setDtinclusion(Date dtinclusion) {
		this.dtinclusion = dtinclusion;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public ContactEntity getContactEntity() {
		return contactEntity;
	}

	public void setContactEntity(ContactEntity contactEntity) {
		this.contactEntity = contactEntity;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
