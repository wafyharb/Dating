package com.formation.dating.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dating.entities.Multimedia;
import com.formation.dating.repositories.MultimediaRepository;

@Service
public class MultimediaService {
	private final MultimediaRepository cr;
	@Autowired
	public MultimediaService(MultimediaRepository cr)
	{
		this.cr=cr;
	}
	public List<Multimedia> getAll() {
		return cr.findAll();
	}

	public void add(Multimedia c) {
		cr.save(c);
	}

	public void delete(Multimedia c) {
		cr.delete(c);
	}

	public Multimedia findById(Long id) {
		if (cr.findById(id).isPresent())
			return cr.findById(id).get();
		return null;
	}

	public void update(Multimedia carnet) {
		Optional<Multimedia> co = cr.findById(carnet.getId());		
		if (co.isPresent()) {
			
			cr.save(co.get());
		}

	}
	public void deleteById(Long id)
	{
		cr.deleteById(id);
	}
}
