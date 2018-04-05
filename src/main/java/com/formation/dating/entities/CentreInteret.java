package com.formation.dating.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class CentreInteret {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 10)
	private String sport;
	@Column(length = 10)
	private String loisir;
	@ManyToMany
	List<Utilisateur> utilisateurs;
	@ManyToMany(mappedBy="centresinterets")
	List<Multimedia> multimedias=new ArrayList<Multimedia>();;
	public CentreInteret() {
		//List<Multimedia> multimedias= new ArrayList<Multimedia>();
	}

	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public List<Multimedia> getMultimedias() {
		return multimedias;
	}

	public void setMultimedias(List<Multimedia> multimedias) {
		this.multimedias = multimedias;
	}

	public CentreInteret(String sport, String loisir) {
		
		this.sport = sport;
		this.loisir = loisir;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public String getLoisir() {
		return loisir;
	}

	public void setLoisir(String loisir) {
		this.loisir = loisir;
	}

}
