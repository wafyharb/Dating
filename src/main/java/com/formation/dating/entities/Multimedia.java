package com.formation.dating.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Multimedia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 10)
	private String typeMultimedia;
	@Column(length = 10)
	private String genre;
	@Column(length = 10)
	private String titre;
	@Column(length = 10)
	private String artiste;
	
	@ManyToMany
	List<CentreInteret> centresinterets;
	
	public Multimedia() {
		
	}

	public Multimedia(String typeMultimedia, String genre, String titre, String artiste) {
		super();
		this.typeMultimedia = typeMultimedia;
		this.genre = genre;
		this.titre = titre;
		this.artiste = artiste;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTypeMultimedia() {
		return typeMultimedia;
	}

	public void setTypeMultimedia(String typeMultimedia) {
		this.typeMultimedia = typeMultimedia;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getArtiste() {
		return artiste;
	}

	public void setArtiste(String artiste) {
		this.artiste = artiste;
	}

}
