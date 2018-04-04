package com.formation.dating.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dating.entities.Adresse;
import com.formation.dating.repositories.AdresseRepository;


@Service
public class AdresseService {
	private final AdresseRepository cr;
	@Autowired
	public AdresseService(AdresseRepository cr)
	{
		this.cr=cr;
	}
	public List<Adresse> getAll() {
		return cr.findAll();
	}

	public void add(Adresse c) {
		cr.save(c);
	}

	public void delete(Adresse c) {
		cr.delete(c);
	}

	public Adresse findById(Long id) {
		if (cr.findById(id).isPresent())
			return cr.findById(id).get();
		return null;
	}

	public void update( Adresse carnet) {
		Optional<Adresse> co = cr.findById(carnet.getId());		
		if (co.isPresent()) {
			
			cr.save(co.get());
		}

	}
	public void deleteById(Long id)
	{
		cr.deleteById(id);
	}
	
}
