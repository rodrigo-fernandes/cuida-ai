package com.rodrigo.project.model.notification;

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

import com.rodrigo.project.model.institution.InstitutionEntity;
import com.rodrigo.project.model.person.PersonEntity;

/* @author Rodrigo Fernandes */

@Entity
@Table(name = "notificacao")
public class NotificationEntity {

	private static final long serialVersionUID = 1L;

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO) -- Conexao com o Mysql

	/* PostgreSQL: conexao com o postgres.... cria a sequencia (auto incremento) */
	@SequenceGenerator(name = "notification_seq", sequenceName = "notification_seq")
	/* PostgreSQL: gera o auto incremento */
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notification_seq")
	@Column(name = "id_notificacao", nullable = false)
	private Long id;

	@Column(name = "not_descricao", nullable = false, length = 100)
	private String description;

	@Column(name = "not_texto", nullable = false, length = 1000)
	private String text;

	@Column(name = "not_dtenvio", nullable = false)
	private String sendDate;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_person_notification"), nullable = false, name = "id_pessoa")
	private PersonEntity personEntity;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_instituition_notification"), nullable = false, name = "id_instituicao")
	private InstitutionEntity institutionEntity;

	// Construction
	public NotificationEntity(String description, String text, String sendDate) {
		super();
		this.description = description;
		this.text = text;
		this.sendDate = sendDate;
	}

	public NotificationEntity(String description, String text, String sendDate, PersonEntity personEntity,
			InstitutionEntity institutionEntity) {
		super();
		this.description = description;
		this.text = text;
		this.sendDate = sendDate;
		this.personEntity = personEntity;
		this.institutionEntity = institutionEntity;
	}
	
	public NotificationEntity() {
		
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getSendDate() {
		return sendDate;
	}

	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
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

	public InstitutionEntity getInstitutionEntity() {
		return institutionEntity;
	}

	public void setInstitutionEntity(InstitutionEntity institutionEntity) {
		this.institutionEntity = institutionEntity;
	}

}
