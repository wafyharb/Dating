package com.formation.dating.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dating.entities.Apparence;
import com.formation.dating.repositories.ApparenceRepository;

@Service
public class ApparenceService {
	private final ApparenceRepository cr;
	@Autowired
	public ApparenceService(ApparenceRepository cr)
	{
		this.cr=cr;
	}
	public List<Apparence> getAll() {
		return cr.findAll();
	}

	public void add(Apparence c) {
		cr.save(c);
	}

	public void delete(Apparence c) {
		cr.delete(c);
	}

	public Apparence findById(Long id) {
		if (cr.findById(id).isPresent())
			return cr.findById(id).get();
		return null;
	}

	public void update( Apparence carnet) {
		Optional<Apparence> co = cr.findById(carnet.getId());		
		if (co.isPresent()) {
			
			cr.save(co.get());
		}

	}
	public void deleteById(Long id)
	{
		cr.deleteById(id);
	}
	
}
