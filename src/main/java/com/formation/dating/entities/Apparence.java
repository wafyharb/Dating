package com.formation.dating.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Apparence {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 10)
	private Integer taille;
	@Column(length = 10)
	private String couleurYeux;
	@Column(length = 10)
	private String typeCheveux;
	@Column(length = 10)
	private String origine;
	@Column(length = 10)
	private String couleurcheveux;
	@Column(length = 10)
	private Float masse;
    
	

	public Apparence(Integer taille, String couleurYeux, String typeCheveux, String origine, String couleurcheveux,
			Float masse) {
		super();
		this.taille = taille;
		this.couleurYeux = couleurYeux;
		this.typeCheveux = typeCheveux;
		this.origine = origine;
		this.couleurcheveux = couleurcheveux;
		this.masse = masse;
		
	}

	public Apparence() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getTaille() {
		return taille;
	}

	public void setTaille(Integer taille) {
		this.taille = taille;
	}

	public String getCouleurYeux() {
		return couleurYeux;
	}

	public void setCouleurYeux(String couleurYeux) {
		this.couleurYeux = couleurYeux;
	}

	public String getTypeCheveux() {
		return typeCheveux;
	}

	public void setTypeCheveux(String typeCheveux) {
		this.typeCheveux = typeCheveux;
	}

	public String getOrigine() {
		return origine;
	}

	public void setOrigine(String origine) {
		this.origine = origine;
	}

	public String getCouleurcheveux() {
		return couleurcheveux;
	}

	public void setCouleurcheveux(String couleurcheveux) {
		this.couleurcheveux = couleurcheveux;
	}

	public Float getMasse() {
		return masse;
	}

	public void setMasse(Float masse) {
		this.masse = masse;
	}

}
