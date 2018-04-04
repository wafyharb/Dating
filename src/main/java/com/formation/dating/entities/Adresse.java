package com.formation.dating.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Adresse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 10)
	private Integer codePostale;
	@Column(length = 4)
	private Integer numero;
	@Column(length = 25)
    private String ville;
	@Column(length = 10)
	private String typeRue;
	@Column(length = 50)
	private String nomRue;
	@Column(length = 25)
	private String complement;
	@Column(length = 25)
	private String prefixe;
    
	public Adresse() {

	}

	public Adresse(Integer codePostale, Integer numero, String ville, String typeRue, String nomRue, String complement,
			String prefixe) {
		super();
		this.codePostale = codePostale;
		this.numero = numero;
		this.ville = ville;
		this.typeRue = typeRue;
		this.nomRue = nomRue;
		this.complement = complement;
		this.prefixe = prefixe;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCodePostale() {
		return codePostale;
	}

	public void setCodePostale(Integer codePostale) {
		this.codePostale = codePostale;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTypeRue() {
		return typeRue;
	}

	public void setTypeRue(String typeRue) {
		this.typeRue = typeRue;
	}

	public String getNomRue() {
		return nomRue;
	}

	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getPrefixe() {
		return prefixe;
	}

	public void setPrefixe(String prefixe) {
		this.prefixe = prefixe;
	}

}
