package com.formation.dating.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.dating.entities.Multimedia;

@Repository
public interface MultimediaRepository extends JpaRepository<Multimedia, Long> {

}
