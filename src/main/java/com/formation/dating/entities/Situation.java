package com.formation.dating.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Situation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 2)
	private Integer nbrEnfant;
	@Column(length = 50)
	private String statutPro;
	@Column(length = 50)
	private String statutPerso;
	@Column(length = 50)
	private String orientation;
	@Column(length = 50)
	private String fumeur;
	@Column(length = 50)
	private String alcool;

	public Situation() {

	}

	public Situation(int nbrEnfant, String statutPro, String statutPerso, String orientation, String fumeur,
			String alcool) {
		
		this.nbrEnfant = nbrEnfant;
		this.statutPro = statutPro;
		this.statutPerso = statutPerso;
		this.orientation = orientation;
		this.fumeur = fumeur;
		this.alcool = alcool;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNbrEnfant() {
		return nbrEnfant;
	}

	public void setNbrEnfant(Integer nbrEnfant) {
		this.nbrEnfant = nbrEnfant;
	}

	public String getStatutPro() {
		return statutPro;
	}

	public void setStatutPro(String statutPro) {
		this.statutPro = statutPro;
	}

	public String getStatutPerso() {
		return statutPerso;
	}

	public void setStatutPerso(String statutPerso) {
		this.statutPerso = statutPerso;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public String getFumeur() {
		return fumeur;
	}

	public void setFumeur(String fumeur) {
		this.fumeur = fumeur;
	}

	public String getAlcool() {
		return alcool;
	}

	public void setAlcool(String alcool) {
		this.alcool = alcool;
	}

}
