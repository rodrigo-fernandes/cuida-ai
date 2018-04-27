package com.rodrigo.project.model.schedule;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/* @author Rodrigo Fernandes */

@Entity
@Table(name = "agenda")
public class ScheduleEntity {

	private static final long serialVersionUID = 1L;

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO) -- Conexao com o Mysql

	/* PostgreSQL: conexao com o postgres.... cria a sequencia (auto incremento) */
	@SequenceGenerator(name = "schedule_seq", sequenceName = "schedule_seq")
	/* PostgreSQL: gera o auto incremento */
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "schedule_seq")
	@Column(name = "id_agenda", nullable = false)
	private Long id;

	@Column(name = "agd_descricao", nullable = false)
	private String description;

	@Column(name = "agd_data", nullable = false)
	private Date date;

	@Column(name = "agd_cafemanha", nullable = false, length = 1)
	private char breakfast;

	@Column(name = "agd_almoco", nullable = false, length = 1)
	private char lunch;

	@Column(name = "agd_cafetarde", nullable = false, length = 1)
	private char afternoonCoffee;

	@Column(name = "agd_necessidade", nullable = false, length = 1)
	private char need;

	// Construction
	public ScheduleEntity(String description, Date date, char breakfast, char lunch, char afternoonCoffee, char need) {
		super();
		this.description = description;
		this.date = date;
		this.breakfast = breakfast;
		this.lunch = lunch;
		this.afternoonCoffee = afternoonCoffee;
		this.need = need;
	}
	
	public ScheduleEntity() {
		
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public char getBreakfast() {
		return breakfast;
	}

	public void setBreakfast(char breakfast) {
		this.breakfast = breakfast;
	}

	public char getLunch() {
		return lunch;
	}

	public void setLunch(char lunch) {
		this.lunch = lunch;
	}

	public char getAfternoonCoffee() {
		return afternoonCoffee;
	}

	public void setAfternoonCoffee(char afternoonCoffee) {
		this.afternoonCoffee = afternoonCoffee;
	}

	public char getNeed() {
		return need;
	}

	public void setNeed(char need) {
		this.need = need;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
