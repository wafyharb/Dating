package com.formation.dating.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dating.entities.Utilisateur;
import com.formation.dating.repositories.UtilisateurRepository;

@Service
public class UtilisateurService {
	private final UtilisateurRepository ur;
	@Autowired
	public UtilisateurService(UtilisateurRepository ur)
	{
		this.ur=ur;
	}
	public List<Utilisateur> getAll() {
		return ur.findAll();
	}

	public void add(Utilisateur c) {
		ur.save(c);
	}

	public void delete(Utilisateur c) {
		ur.delete(c);
	}

	public Utilisateur findById(String id) {
		if (ur.findById(id).isPresent())
			return ur.findById(id).get();
		return null;
	}

	public void update(Utilisateur user) {
		Optional<Utilisateur> co = ur.findById(user.getEmail());		
		if (co.isPresent()) {
			
			ur.save(co.get());
		}

	}
	public void deleteById(String id)
	{
		ur.deleteById(id);
	}
}
