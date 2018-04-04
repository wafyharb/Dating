package com.formation.dating.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.dating.entities.Photo;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long>  {

}
