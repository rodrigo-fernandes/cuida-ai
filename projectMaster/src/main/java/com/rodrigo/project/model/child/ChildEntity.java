package com.rodrigo.project.model.child;

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

import com.rodrigo.project.model.person.PersonEntity;
import com.rodrigo.project.model.schedule.ScheduleEntity;

/* @author Rodrigo Fernandes */

@Entity
@Table(name = "crianca")
public class ChildEntity {

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO) -- Conexao com o Mysql

	/* PostgreSQL: conexao com o postgres.... cria a sequencia (auto incremento) */
	@SequenceGenerator(name = "child_seq", sequenceName = "child_seq")
	/* PostgreSQL: gera o auto incremento */
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "child_seq")
	@Column(name = "id_crianca", nullable = false)
	private Long id;

	@Column(name = "tiposangue", nullable = false, length = 3)
	private String bloodType;

	@Column(name = "ptdnecessidade", nullable = false, length = 1)
	private char needBearer;

	@Column(name = "complemento", nullable = false)
	private char complement;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_schuedule_child"), nullable = false, name = "id_agenda")
	private ScheduleEntity scheduleEntity;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_person_child"), nullable = false, name = "id_pessoa")
	private PersonEntity personEntity;

	// Construction
	public ChildEntity(String bloodType, char needBearer, char complement) {
		super();
		this.bloodType = bloodType;
		this.needBearer = needBearer;
		this.complement = complement;
	}

	public ChildEntity() {

	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public char getNeedBearer() {
		return needBearer;
	}

	public void setNeedBearer(char needBearer) {
		this.needBearer = needBearer;
	}

	public char getComplement() {
		return complement;
	}

	public void setComplement(char complement) {
		this.complement = complement;
	}

	public ScheduleEntity getScheduleEntity() {
		return scheduleEntity;
	}

	public void setScheduleEntity(ScheduleEntity scheduleEntity) {
		this.scheduleEntity = scheduleEntity;
	}

	public PersonEntity getPersonEntity() {
		return personEntity;
	}

	public void setPersonEntity(PersonEntity personEntity) {
		this.personEntity = personEntity;
	}

}
