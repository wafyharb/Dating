package com.formation.dating.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dating.entities.Situation;
import com.formation.dating.repositories.SituationRepository;

@Service
public class SituationService {
	private final SituationRepository cr;
	@Autowired
	public SituationService(SituationRepository cr)
	{
		this.cr=cr;
	}
	public List<Situation> getAll() {
		return cr.findAll();
	}

	public void add(Situation c) {
		cr.save(c);
	}

	public void delete(Situation c) {
		cr.delete(c);
	}

	public Situation findById(Long id) {
		if (cr.findById(id).isPresent())
			return cr.findById(id).get();
		return null;
	}

	public void update(Situation carnet) {
		Optional<Situation> co = cr.findById(carnet.getId());		
		if (co.isPresent()) {
			
			cr.save(co.get());
		}

	}
	public void deleteById(Long id)
	{
		cr.deleteById(id);
	}
}
