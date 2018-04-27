package com.rodrigo.project.model.contact;

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
@Table(name = "contato")
public class ContactEntity {

	private static final long serialVersionUID = 1L;

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO) -- Conexao com o Mysql

	/* PostgreSQL: conexao com o postgres.... cria a sequencia (auto incremento) */
	@SequenceGenerator(name = "contact_seq", sequenceName = "contact_seq")
	/* PostgreSQL: gera o auto incremento */
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_seq")
	@Column(name = "id_contato", nullable = false)
	private Long id;

	@Column(name = "ctt_tlfresidencial", nullable = false, length = 15)
	private String homephone;

	@Column(name = "ctt_tcelular", nullable = false, length = 15)
	private String phonecel1;

	@Column(name = "ctt_tcelular2", nullable = false, length = 15)
	private String phonecell2;

	@Column(name = "ctt_email", nullable = false, length = 100)
	private String email;

	@Column(name = "ctt_tipo", nullable = false, length = 1)
	private char type;

	@Column(name = "ctt_complemento", nullable = false)
	private String complement;

	@NotNull
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_contact_person"), nullable = false, name = "id_pessoa")
	private PersonEntity personEntity;

	// Construction
	public ContactEntity(String homephone, String phonecel1, String phonecell2, String email, char type,
			String complement) {
		super();
		this.homephone = homephone;
		this.phonecel1 = phonecel1;
		this.phonecell2 = phonecell2;
		this.email = email;
		this.type = type;
		this.complement = complement;
	}

	public ContactEntity() {

	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHomephone() {
		return homephone;
	}

	public void setHomephone(String homephone) {
		this.homephone = homephone;
	}

	public String getPhonecel1() {
		return phonecel1;
	}

	public void setPhonecel1(String phonecel1) {
		this.phonecel1 = phonecel1;
	}

	public String getPhonecell2() {
		return phonecell2;
	}

	public void setPhonecell2(String phonecell2) {
		this.phonecell2 = phonecell2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public PersonEntity getPersonEntity() {
		return personEntity;
	}

	public void setPersonEntity(PersonEntity personEntity) {
		this.personEntity = personEntity;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
