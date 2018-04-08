package com.formation.dating.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;

@Entity
public class Utilisateur {

	@Id
	@Column(length = 100)
	@Pattern(message = "Email not good", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
	private String email;
	@Column(length = 70, name = "nom", nullable = false)
	@Pattern(regexp = "(?i)[a-zàâçéèêëîïôûùüÿñæœ -_]{1,70}", message = "problem")
	private String nom;
	@Column(length = 100, name = "prenom", nullable = false)
	@Pattern(regexp = "(?i)[a-zàâçéèêëîïôûùüÿñæœ -_]{1,100}")
	private String prenom;
	@Column(length = 10)
	private String dateNaissance;
	@Column(length = 10)
	private String sexe;
	@Column(length = 10)
	private String motDePass;
	@Column(length = 20)
	private String pseudo;
	@Column(length = 15)
	private String numTel;
	@Column(length = 10)
	private String type;
	@Column(length = 100)
	private String description;

	@ManyToOne
	@JoinColumn(name = "adresse")
	private Adresse adresse;

	@ManyToOne
	@JoinColumn(name = "situation")
	private Situation situation;

	@ManyToMany(mappedBy = "utilisateurs")
	List<CentreInteret> centresInterets;

	@ManyToOne
	@JoinColumn(name = "apparence")
	private Apparence apparence;

	@OneToMany
	private List<Photo> photos;

	@ManyToMany
	private List<Utilisateur> favoris;

	public Utilisateur(String email, String nom, String prenom, String dateNaissance, String sexe, String motDePass,
			String pseudo, String numTel) {
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.sexe = sexe;
		this.motDePass = motDePass;
		this.pseudo = pseudo;
		this.numTel = numTel;

	}

	public Utilisateur() {

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getMotDePass() {
		return motDePass;
	}

	public void setMotDePass(String motDePass) {
		this.motDePass = motDePass;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Situation getSituation() {
		return situation;
	}

	public void setSituation(Situation situation) {
		this.situation = situation;
	}

	public List<CentreInteret> getCentresInterets() {
		return centresInterets;
	}

	@Override
	public String toString() {
		return "Utilisateur [email=" + email + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance="
				+ dateNaissance + ", sexe=" + sexe + ", motDePass=" + motDePass + ", pseudo=" + pseudo + ", numTel="
				+ numTel + ", type=" + type + ", description=" + description + ", photos=" + photos.toString() + "]";
	}

	public void setCentresInterets(List<CentreInteret> centresInterets) {
		this.centresInterets = centresInterets;
	}

	public Apparence getApparence() {
		return apparence;
	}

	public void setApparence(Apparence apparence2) {
		this.apparence = apparence2;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public List<Utilisateur> getFavoris() {
		return favoris;
	}

	public void setFavoris(List<Utilisateur> favoris) {
		this.favoris = favoris;
	}

}
