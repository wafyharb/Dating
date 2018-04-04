package com.formation.dating.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dating.entities.CentreInteret;
import com.formation.dating.repositories.CentreInteretRepository;

@Service
public class CentreInteretService {
	private final CentreInteretRepository cr;
	@Autowired
	public CentreInteretService(CentreInteretRepository cr)
	{
		this.cr=cr;
	}
	public List<CentreInteret> getAll() {
		return cr.findAll();
	}

	public void add(CentreInteret c) {
		cr.save(c);
	}

	public void delete(CentreInteret c) {
		cr.delete(c);
	}

	public CentreInteret findById(Long id) {
		if (cr.findById(id).isPresent())
			return cr.findById(id).get();
		return null;
	}

	public void update(CentreInteret carnet) {
		Optional<CentreInteret> co = cr.findById(carnet.getId());		
		if (co.isPresent()) {
			
			cr.save(co.get());
		}

	}
	public void deleteById(Long id)
	{
		cr.deleteById(id);
	}
	
}
