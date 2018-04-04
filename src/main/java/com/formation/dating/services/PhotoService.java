package com.formation.dating.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dating.entities.Photo;
import com.formation.dating.repositories.PhotoRepository;

@Service
public class PhotoService {
	private final PhotoRepository cr;
	@Autowired
	public PhotoService(PhotoRepository cr)
	{
		this.cr=cr;
	}
	public List<Photo> getAll() {
		return cr.findAll();
	}

	public void add(Photo c) {
		cr.save(c);
	}

	public void delete(Photo c) {
		cr.delete(c);
	}

	public Photo findById(Long id) {
		if (cr.findById(id).isPresent())
			return cr.findById(id).get();
		return null;
	}

	public void update(Photo carnet) {
		Optional<Photo> co = cr.findById(carnet.getId());		
		if (co.isPresent()) {
			
			cr.save(co.get());
		}

	}
	public void deleteById(Long id)
	{
		cr.deleteById(id);
	}
}
